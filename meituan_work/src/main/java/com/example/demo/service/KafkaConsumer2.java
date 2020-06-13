package com.example.demo.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class KafkaConsumer2 {
   private static final Logger logger = LoggerFactory.getLogger(KafkaConsumer2.class);

   @KafkaListener(topics = KafkaSender.TOPIC_ONE,groupId = "B")
   public void consumerA(ConsumerRecord<?, ?> record, String topic,Acknowledgment ack){

      Optional message=Optional.ofNullable(record.value());
      if (message.isPresent()){
         Object msg=message.get();
         logger.info("被B消费了： +++++++++++++++ Topic:" + topic+",Record:" + record+",Message:" + msg);
         ack.acknowledge();
      }
   }


}