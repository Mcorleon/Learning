package com.tqh.demo.service;

import com.tqh.demo.mapper.RoleMapper;
import com.tqh.demo.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Mcorleon
 * @Date: 18-7-26 16:30
 */
@Service
public class RoleService {
    @Autowired
    RoleMapper roleMapper;

    public String[] findRolesByUser(String id){
        return  roleMapper.findRolebyUser(id);
    }

    public Role findRolebyID(String id){
        return roleMapper.findRolebyID(id);
    }
}
