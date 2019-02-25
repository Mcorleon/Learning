package com.tqh.service;

import com.tqh.model.Goods;
import com.tqh.model.MiaoshaGoodsVo;

import java.util.List;
import java.util.Map;

/**
 * @Author Mcorleon
 * @Date 2019/2/21 20:16
 */
public interface GoodsService {
    Map<String, Object> getGoodsList();

    String getMiaoshaGoodsList(String goods_id);

    MiaoshaGoodsVo getMiaoshaGoodByID(String id);

    void decreaseStock(String goods_id);
}
