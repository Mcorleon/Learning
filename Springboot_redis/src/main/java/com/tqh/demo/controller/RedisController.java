package com.tqh.demo.controller;

import com.tqh.demo.model.Dog;
import com.tqh.demo.model.User;
import com.tqh.demo.service.DogService;
import com.tqh.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class RedisController {
    @Autowired
    UserService userService;
    @Autowired
    DogService dogService;
    @RequestMapping("select/{id}")
    @ResponseBody
    public User ForTest(@PathVariable String id){
      return userService.selectUser(id);
    }

    @RequestMapping( "/update/{id}/{name}")
    @ResponseBody
    public String update(@PathVariable String id,@PathVariable String name){
        userService.updataById(id,name);
        return "update success";
    }

    @RequestMapping( "/delete/{id}")
    @ResponseBody
    public String delete (@PathVariable String id){
        userService.deleteById(id);
        return "delete success";
    }

    @RequestMapping("/dog/{id}")
    @ResponseBody
    public Dog DogTest(@PathVariable String id){
        return dogService.selectDog(id);
    }

}
