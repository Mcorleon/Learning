package com.tqh.service.impl;

import com.github.pagehelper.Page;
import com.tqh.mapper.OrderMapper;
import com.tqh.model.*;
import com.tqh.service.OrderService;
import com.tqh.util.SnowFlake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Mcorleon
 * @Date 2019/2/23 14:27
 */
@Service
public class OrderServiceImpl implements OrderService{
    private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    UserServiceImpl userService;
    @Autowired
    GoodsServiceImpl goodsService;
    @Autowired
    OrderMapper orderMapper;
    private static final SnowFlake SNOW_FLAKE=new SnowFlake(1,1);

    @Transactional
    @Override
    public Result generateOrder(String miaosha_id, String nickName, int goods_num, String address_id) {
        //找出用户
        User user=userService.findUserByName(nickName);
        if(user==null){
            return Result.UNKONWN_USER_ERR;
        }
        //找出秒杀商品
        MiaoshaGoodsVo miaoshaGoodsVo=goodsService.getMiaoshaGoodByID(miaosha_id);
        if(miaoshaGoodsVo==null){
            logger.info(Result.UNKONWN_GOODS_ERR.toString());
            return Result.UNKONWN_GOODS_ERR;
        }
        if(miaoshaGoodsVo.getStock()<1){
            logger.info(Result.LACK_STOCK_ERR.toString());
            return Result.LACK_STOCK_ERR;
        }
        long current_time=System.currentTimeMillis();
        if(current_time<miaoshaGoodsVo.getStart_time().getTime()){
            logger.info(Result.BEFORE_MIAOSHA_ERR.toString());
            return Result.BEFORE_MIAOSHA_ERR;
        }
        if(current_time>miaoshaGoodsVo.getEnd_time().getTime()){
            logger.info(Result.END_MIAOSHA_ERR.toString());
            return Result.END_MIAOSHA_ERR;
        }
        //找出地址
        Address address=userService.getAddressByAddressID(address_id);
        if(address==null){
            logger.info(Result.UNKONWN_ADDRESS_ERR.toString());
            return Result.UNKONWN_ADDRESS_ERR;
        }
        //生成订单
        Order order=new Order();
        order.setId(String.valueOf(SNOW_FLAKE.nextId()));
        order.setUser_id(String.valueOf(user.getId()));
        order.setGoods_id(miaoshaGoodsVo.getGoods_id());
        order.setAddress_id(address.getId());
        order.setGoods_name(miaoshaGoodsVo.getName());
        order.setGoods_num((long)goods_num);
        order.setGood_price(miaoshaGoodsVo.getMiaosha_price());
        order.setState(0);
        order.setOrder_time(new Date());
        orderMapper.inserOrder(order);
        //减库存
        goodsService.decreaseStock(miaoshaGoodsVo.getGoods_id());
        Result result=new Result(200,"下单成功");
        logger.info(result.toString());
        return result;
    }

    @Override
    public Map<String, Object> getOrderVoByUid(String uid) {
        List<OrderVo> list=orderMapper.getOrderVoByUid(uid);
        for(OrderVo orderVo:list){
            String stateVo;
            switch (orderVo.getState()){
                case 0:stateVo="未付款";break;
                case 1:stateVo="待发货";break;
                case 2:stateVo="已发货";break;
                case 3:stateVo="已收货";break;
                case 4:stateVo="已取消";break;
                case 5:stateVo="已完成";break;
                default:stateVo="状态有误";
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
}
