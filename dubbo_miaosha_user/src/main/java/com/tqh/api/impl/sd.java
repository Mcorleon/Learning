package com.tqh.api.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.tqh.api.UserSerive;
import com.tqh.model.Address;
import com.tqh.model.Result;
import com.tqh.model.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author Mcorleon
 * @Date 2019/6/30 14:57
 */
@Service
public class sd implements UserSerive{
    @Override
    public User findUserByName(String name) {
        return null;
    }

    @Override
    public Result userLogin(String id, String psw, HttpServletRequest request) {
        return null;
    }

    @Override
    public User getCurrentUser() {
        return null;
    }

    @Override
    public List<Address> getAddressByNickName(String nickName) {
        return null;
    }

    @Override
    public Address getAddressByAddressID(String address_id) {
        return null;
    }
}
