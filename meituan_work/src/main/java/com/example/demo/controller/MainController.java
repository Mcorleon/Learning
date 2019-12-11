package com.example.demo.controller;

import com.example.demo.service.MailService;
import com.example.demo.service.WebSocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * @Author Mcorleon
 * @Date 2019/11/26 20:18
 */
@Controller
public class MainController {
    @Autowired
    private MailService mailService;
    @Autowired
    private WebSocketServer webSocketServer;
    @PostMapping("/sendMail")
    @ResponseBody
    public String sendMail(String to,String subject,String content){
        boolean res= mailService.sendMail( to, subject, content);
        return res?"发送成功！":"发送失败！";
    }

    @GetMapping("/cli1")
    public  String test1(){
        return "cli1";
    }
    @GetMapping("/cli2")
    public  String test2(){
        return "cli2";
    }
    @GetMapping("/cli3")
    public  String test3(){
        return "cli3";
    }

    @PostMapping("/websocket/push")
    @ResponseBody
    public String websocketPush(String cid,String message) throws IOException {
        WebSocketServer.sendInfo(message,cid);
        return null;
    }
}
