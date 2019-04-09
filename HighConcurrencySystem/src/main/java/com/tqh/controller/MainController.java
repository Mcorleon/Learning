package com.tqh.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tqh.model.Result;
import com.tqh.service.MQSender;
import com.tqh.service.impl.UserServiceImpl;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;
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
import javax.servlet.http.HttpServletResponse;
import java.util.List;

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
    @Autowired
    MQSender sender;

    @PostMapping("/login")
    @ResponseBody
    public Result Login(String uid, String psw, HttpServletRequest request) {
        String loginName = uid;
        String password = psw;
        return userService.userLogin(loginName, password, request);

    }

    @RequestMapping("/goods")
    public String goods() {
        return "goods_list";
    }

    @RequestMapping("/miaoshaGoods")
    public String miaoshaGoods() {
        return "miaoshaGoods";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/403")
    public String notAuthenticated() {
        return "403";
    }

    @RequestMapping("/checkOrder")
//    @RequiresRoles("vip")
    public String checkOrder() {
        return "checkOrder";
    }

    @RequestMapping("/order_list")
    public String order_list() {
        return "order_list";
    }

    @RequestMapping("/Err")
    public String Err() {
        return "error";
    }

    @RequestMapping("/upload")
    public void upload(HttpServletRequest request, HttpServletResponse response) throws Exception {
        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(4 * 1024);
        ServletFileUpload upload = new ServletFileUpload(factory);
        List<FileItem> fileItems;

        fileItems = upload.parseRequest(new ServletRequestContext(request));
        //获取文件域
        FileItem fileItem = fileItems.get(0);


    }
}