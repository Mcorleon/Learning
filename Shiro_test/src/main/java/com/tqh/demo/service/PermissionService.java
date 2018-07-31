package com.tqh.demo.service;

import com.tqh.demo.mapper.PermissionMapper;
import com.tqh.demo.model.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Mcorleon
 * @Date: 18-7-26 16:52
 */
@Service
public class PermissionService {
    @Autowired
    PermissionMapper permissionMapper;
    public String[] findPermissionsByRole(String id){
        return   permissionMapper.findPermissionsByRole(id);
    }

    public Permission findPermissionByID(String id){
        return permissionMapper.findPermissionByID(id);
    }
}
