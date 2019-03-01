package com.tqh.controller;

import com.tqh.model.Address;
import com.tqh.model.User;
import com.tqh.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Mcorleon
 * @Date 2019/2/22 10:34
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserServiceImpl userService;

    @RequestMapping("/getCurrentUser")
    public User getCurrentUser(){
        User user=userService.getCurrentUser();
        return user;
    }

    /**
     *QPS:400
     * 500*10
     */
    @RequestMapping("/getAddressByNickName")
    public List<Address> getAddressByNickName(String nickName){
        List<Address> list=userService.getAddressByNickName(nickName);
        return list;
    }
}
