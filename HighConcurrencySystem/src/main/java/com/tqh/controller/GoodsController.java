package com.tqh.controller;

import com.github.pagehelper.PageHelper;
import com.tqh.model.Goods;
import com.tqh.model.MiaoshaGoodsVo;
import com.tqh.service.impl.GoodsServiceImpl;
import com.tqh.service.impl.OrderServiceImpl;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Author Mcorleon
 * @Date 2019/2/21 20:15
 */
@RestController
@RequestMapping("/goods")
public class GoodsController implements InitializingBean{
    @Autowired
    GoodsServiceImpl goodsService;

    @RequestMapping("/getGoodsList")
    public Map getGoodsList(int page,int limit){
        PageHelper.startPage(page, limit);
        Map<String, Object> map = goodsService.getGoodsList();
        return map;
    }
    @RequestMapping("/getMiaoshaGoodsList/{goods_id}")
    public String getMiaoshaGoodsList(int page, int limit, @PathVariable String goods_id){
        PageHelper.startPage(page, limit);
        return   goodsService.getMiaoshaGoodsList(goods_id);

    }
    @RequestMapping("/getMiaoshaGoodByID")
    public MiaoshaGoodsVo getMiaoshaGoodByID(String id){
        return   goodsService.getMiaoshaGoodByID(id);

    }
    @RequestMapping("/reset")
    public String reset(String id){
        OrderServiceImpl.HAS_STOCK.clear();
        return "sucess";

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("将所有库存加入redis缓存");
    }
}
