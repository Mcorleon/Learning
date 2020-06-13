package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
public class KafkaSender {

   private static final Logger logger = LoggerFactory.getLogger(KafkaSender.class);
   @Autowired
   private KafkaTemplate<String,String> kafkaTemplate;

   //自定义topic
   public static final String TOPIC_ONE="topic_order";

   public void send(String msg){
      //发送消息
      ListenableFuture<SendResult<String,String>> future=kafkaTemplate.send(TOPIC_ONE,msg);
      future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
         @Override
         public void onFailure(Throwable throwable) {
            //发送失败的处理
            logger.info(TOPIC_ONE+" - 生产者 发送消息失败："+throwable.getMessage());
         }

         @Override
         public void onSuccess(SendResult<String, String> stringObjectSendResult) {
            //成功的处理
            logger.info(TOPIC_ONE+" - 生产者 发送消息成功："+stringObjectSendResult.toString());
         }
      });

   }
}