package com.tqh.service;

import com.tqh.config.RabbitMqConfig;
import com.tqh.mapper.OrderMapper;
import com.tqh.model.*;

import com.tqh.service.impl.GoodsServiceImpl;
import com.tqh.service.impl.OrderServiceImpl;
import com.tqh.service.impl.UserServiceImpl;
import com.tqh.util.SnowFlake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static com.tqh.service.impl.OrderServiceImpl.HAS_STOCK;

/**
 * @Author Mcorleon
 * @Date 2019/2/26 21:44
 */
@Service
public class MQReciver {
    private static final Logger logger = LoggerFactory.getLogger(MQReciver.class);
    @Autowired
    GoodsServiceImpl goodsService;
    @Autowired
    UserServiceImpl userService;
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    OrderServiceImpl orderService;
    @Autowired
    RedisTemplate redisTemplate;
    private static final SnowFlake SNOW_FLAKE = new SnowFlake(1, 1);


    //默认是单线程串行消费
    @RabbitListener(queues = RabbitMqConfig.DIRECT_QUEUE)
    public void generateOrder(Map map){
        String miaosha_id=(String) map.get("miaosha_id");
        String nickName=(String) map.get("nickName");
        int goods_num=(int) map.get("goods_num");
        String address_id=(String) map.get("address_id");


        try {
            orderService.dealOrderMessage(miaosha_id,nickName,goods_num,address_id);
        } catch (Exception e) {
            logger.error("消费者异常",e);
            redisTemplate.opsForValue().set(miaosha_id+nickName,-1,30,TimeUnit.MINUTES);
            return;
        }

    }



}
