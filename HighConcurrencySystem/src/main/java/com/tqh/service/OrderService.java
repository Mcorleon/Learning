package com.tqh.service;

import com.tqh.model.Result;

import java.util.Map;

/**
 * @Author Mcorleon
 * @Date 2019/2/23 14:27
 */
public interface OrderService {
     Result generateOrder(String miaosha_id, String nickName, int goods_num, String address_id);

    Map<String, Object> getOrderVoByUid(String uid);
}
