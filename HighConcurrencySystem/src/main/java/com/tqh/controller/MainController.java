package com.tqh.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tqh.model.Result;
import com.tqh.model.User;
import com.tqh.service.impl.UserServiceImpl;
import org.apache.ibatis.annotations.Mapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Author Mcorleon
 * @Date 2019/2/20 15:07
 */
@Controller
public class MainController {
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);
    private static ObjectMapper MAPPER = new ObjectMapper();
    @Autowired
    StringRedisTemplate redisTemplate;
    @Autowired
    UserServiceImpl userService;
    @PostMapping("/login")
    @ResponseBody
    public Result Login(String uid, String psw, HttpServletRequest request){
        String loginName =uid;
        String password=psw;
        return userService.userLogin(loginName,password,request);

    }

    @RequestMapping("/goods")
    public String goods(){
        return "goods_list";
    }
    @RequestMapping("/miaoshaGoods")
    public String miaoshaGoods(){
        return "miaoshaGoods";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @RequestMapping("/403")
    public String notAuthenticated(){
        return "403";
    }
    @RequestMapping("/checkOrder")
//    @RequiresRoles("vip")
    public String checkOrder(){
        return "checkOrder";
    }
    @RequestMapping("/order_list")
    public String order_list(){
        return "order_list";
    }
    @RequestMapping("/Err")
    public String Err(){
        return "error";
    }

}
