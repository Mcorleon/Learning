package com.example.demo.controller;

import com.example.demo.service.KafkaSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Mcorleon
 * @Date 2020/4/4 14:50
 */
@RestController
@RequestMapping("/kafka")
public class KafkaController {

    @Autowired
    private KafkaSender kafkaSender;
    @PostMapping("/publish")
    public String kafkaPublish( String msg){

        kafkaSender.send(msg);
        return "发送消息";
    }
}
