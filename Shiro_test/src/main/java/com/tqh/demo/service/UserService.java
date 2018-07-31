package com.tqh.demo.service;

import com.tqh.demo.mapper.UserMapper;
import com.tqh.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: Mcorleon
 * @Date: 18-7-26 15:03
 */
@Service
public class UserService {
    @Autowired
    UserMapper userMaper;
    public User findUserByName(String name){
        return  userMaper.findByLoginName(name);
    }
}
