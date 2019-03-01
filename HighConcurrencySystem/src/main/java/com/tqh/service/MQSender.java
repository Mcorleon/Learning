package com.tqh.service;

import com.tqh.config.RabbitMqConfig;
import com.tqh.model.Result;
import com.tqh.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Author Mcorleon
 * @Date 2019/2/26 21:47
 */
@Service
public class MQSender {
    @Autowired
    private AmqpTemplate amqpTemplate;
    private static final Logger logger = LoggerFactory.getLogger(MQSender.class);

    @Autowired
    RedisTemplate redisTemplate;
    public void sendOrderMessage(String miaosha_id, String nickName, int goods_num, String address_id){
        logger.info("sendOrderMessage:"+miaosha_id+","+nickName+","+goods_num+","+address_id);
        Map map=new HashMap();
        map.put("miaosha_id",miaosha_id);
        map.put("nickName",nickName);
        map.put("goods_num",goods_num);
        map.put("address_id",address_id);
        amqpTemplate.convertAndSend(RabbitMqConfig.DIRECT_QUEUE,map);
        //正在排队标记
        redisTemplate.opsForValue().set(miaosha_id+nickName,0,30,TimeUnit.MINUTES);
    }

}
