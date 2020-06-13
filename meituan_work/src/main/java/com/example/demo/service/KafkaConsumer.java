package com.example.demo.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class KafkaConsumer {
   private static final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

   @KafkaListener(topics = KafkaSender.TOPIC_ONE,groupId = "A")
   public void consumerA(ConsumerRecord<?, ?> record, String topic,Acknowledgment ack){

      Optional message=Optional.ofNullable(record.value());
      if (message.isPresent()){
         Object msg=message.get();
         logger.info("被A消费了： +++++++++++++++ Topic:" + topic+",Record:" + record+",Message:" + msg);
         ack.acknowledge();
      }
   }

   @KafkaListener(topics = KafkaSender.TOPIC_ONE,groupId = "C")
   public void consumerC(ConsumerRecord<?, ?> record, String topic,Acknowledgment ack){

      Optional message=Optional.ofNullable(record.value());
      if (message.isPresent()){
         Object msg=message.get();
         logger.info("被C消费了： +++++++++++++++ Topic:" + topic+",Record:" + record+",Message:" + msg);
         ack.acknowledge();
      }
   }


}