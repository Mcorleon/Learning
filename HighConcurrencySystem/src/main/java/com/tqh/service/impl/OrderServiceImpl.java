package com.tqh.service.impl;

import com.github.pagehelper.Page;
import com.tqh.config.RabbitMqConfig;
import com.tqh.mapper.OrderMapper;
import com.tqh.model.*;
import com.tqh.service.MQSender;
import com.tqh.service.OrderService;
import com.tqh.util.SnowFlake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Author Mcorleon
 * @Date 2019/2/23 14:27
 */
@Service
public class OrderServiceImpl implements OrderService {
    private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    UserServiceImpl userService;
    @Autowired
    GoodsServiceImpl goodsService;
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    MQSender sender;
    @Autowired
    RedisTemplate redisTemplate;
    private static final SnowFlake SNOW_FLAKE = new SnowFlake(1, 1);
    public volatile static Map<String,Boolean> HAS_STOCK=new HashMap();

    @Override
    public Result generateOrder(String miaosha_id, String nickName, int goods_num, String address_id){
        if(HAS_STOCK.get(miaosha_id)==null){
            HAS_STOCK.put(miaosha_id,true);
        }
        if(!HAS_STOCK.get(miaosha_id)){
            //没库存了
            logger.info("没有库存了");
            return Result.LACK_STOCK_ERR;
        }
        sender.sendOrderMessage(miaosha_id,nickName,goods_num,address_id);
        return new Result(200,"排队中");

    }

    @Override
    public Map<String, Object> getOrderVoByUid(String uid) {
        List<OrderVo> list = orderMapper.getOrderVoByUid(uid);
        for (OrderVo orderVo : list) {
            String stateVo;
            switch (orderVo.getState()) {
                case 0:
                    stateVo = "未付款";
                    break;
                case 1:
                    stateVo = "待发货";
                    break;
                case 2:
                    stateVo = "已发货";
                    break;
                case 3:
                    stateVo = "已收货";
                    break;
                case 4:
                    stateVo = "已取消";
                    break;
                case 5:
                    stateVo = "已完成";
                    break;
                default:
                    stateVo = "状态有误";
            }
            orderVo.setStateVo(stateVo);
        }
        long total = ((Page<OrderVo>) list).getTotal();
        Map<String, Object> map = new HashMap();
        map.put("code", 0);
        map.put("msg", "getOrderVoByUid");
        map.put("count", total);
        map.put("data", list);
        return map;
    }

    @Override
    public String getMiaoshaState(String nickName, String miaosha_id) {
        return String.valueOf(redisTemplate.opsForValue().get(miaosha_id+nickName));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void dealOrderMessage(String miaosha_id, String nickName, int goods_num, String address_id) throws Exception {
        if(HAS_STOCK.get(miaosha_id)==null){
            HAS_STOCK.put(miaosha_id,true);
        }
        if(!HAS_STOCK.get(miaosha_id)){
            //没库存了
            redisTemplate.opsForValue().set(miaosha_id+nickName,-1,30, TimeUnit.MINUTES);
            logger.info("没有库存了");
            return;
        }
        //找出用户
        User user = userService.findUserByName(nickName);
        if (user == null) {
            logger.info(Result.UNKONWN_USER_ERR.toString());
            redisTemplate.opsForValue().set(miaosha_id+nickName,-1,30, TimeUnit.MINUTES);
            return;
        }
        //找出秒杀商品
        MiaoshaGoodsVo miaoshaGoodsVo = goodsService.getMiaoshaGoodByID(miaosha_id);
        if (miaoshaGoodsVo == null) {
            logger.info(Result.UNKONWN_GOODS_ERR.toString());
            redisTemplate.opsForValue().set(miaosha_id+nickName,-1,30,TimeUnit.MINUTES);
            return;
        }
        if (miaoshaGoodsVo.getStock() < 1) {
            HAS_STOCK.put(miaosha_id,false);
            logger.info(Result.LACK_STOCK_ERR.toString());
            redisTemplate.opsForValue().set(miaosha_id+nickName,-1,30,TimeUnit.MINUTES);
            return;
        }
        long current_time = System.currentTimeMillis();
        if (current_time < miaoshaGoodsVo.getStart_time().getTime()) {
            logger.info(Result.BEFORE_MIAOSHA_ERR.toString());
            redisTemplate.opsForValue().set(miaosha_id+nickName,-1,30,TimeUnit.MINUTES);
            return;
        }
        if (current_time > miaoshaGoodsVo.getEnd_time().getTime()) {
            logger.info(Result.END_MIAOSHA_ERR.toString());
            redisTemplate.opsForValue().set(miaosha_id+nickName,-1,30,TimeUnit.MINUTES);
            return;
        }
        //找出地址
        Address address = userService.getAddressByAddressID(address_id);
        if (address == null) {
            logger.info(Result.UNKONWN_ADDRESS_ERR.toString());
            redisTemplate.opsForValue().set(miaosha_id+nickName,-1,30,TimeUnit.MINUTES);
            return;
        }
        //减库存 要判断是否成功，不然库存不足照样生成订单
        if (goodsService.decreaseStock(miaoshaGoodsVo.getGoods_id())) {
            //生成订单
            Order order = new Order();
            order.setId(String.valueOf(SNOW_FLAKE.nextId()));
            order.setUser_id(String.valueOf(user.getId()));
            order.setGoods_id(miaoshaGoodsVo.getGoods_id());
            order.setAddress_id(address.getId());
            order.setGoods_name(miaoshaGoodsVo.getName());
            order.setGoods_num((long) goods_num);
            order.setGood_price(miaoshaGoodsVo.getMiaosha_price());
            order.setState(0);
            order.setOrder_time(new Date());
            orderMapper.inserOrder(order);
            redisTemplate.opsForValue().set(miaosha_id+nickName,1,30,TimeUnit.MINUTES);
            logger.info("下单成功!");
        } else {
            logger.info(Result.LACK_STOCK_ERR.toString());
            redisTemplate.opsForValue().set(miaosha_id+nickName,-1,30,TimeUnit.MINUTES);
        }
    }
}
