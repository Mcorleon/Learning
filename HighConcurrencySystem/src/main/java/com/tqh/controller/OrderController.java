package com.tqh.controller;

import com.github.pagehelper.PageHelper;
import com.tqh.model.Result;
import com.tqh.service.impl.OrderServiceImpl;
import com.tqh.util.JsonTool;
import com.tqh.util.SnowFlake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author Mcorleon
 * @Date 2019/2/22 21:20
 */
@RequestMapping("/order")
@RestController
public class OrderController {
    @Autowired
    OrderServiceImpl orderService;

    /**
     *QPS: 447
     * 1000*10
     * rabbitMQ+接口优化后600
     */
    @RequestMapping("/generateOrder")
    public Result generateOrder(String nickName, String miaosha_id, int goods_num, String address_id) {
        return orderService.generateOrder(miaosha_id,nickName,goods_num,address_id);
    }

    /**
     *QPS: 285
     * 500*20
     */
    @RequestMapping("/getOrderVoByUid")
    public String getOrderVoByUid(int page, int limit,String uid){
        PageHelper.startPage(page, limit);
        Map<String, Object> map = orderService.getOrderVoByUid(uid);
        return JsonTool.objectToJson(map);
    }
    @RequestMapping("/getMiaoshaState")
    public String getMiaoshaState(String nickName,String miaosha_id){
        return orderService.getMiaoshaState(nickName,miaosha_id);

    }


}
