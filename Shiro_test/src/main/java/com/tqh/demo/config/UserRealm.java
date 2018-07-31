package com.tqh.demo.config;

import com.tqh.demo.model.Permission;
import com.tqh.demo.model.Role;
import com.tqh.demo.model.User;
import com.tqh.demo.service.PermissionService;
import com.tqh.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Mcorleon
 * @Date:   18-7-26 11:48
 */
@Component
public class UserRealm  extends  AbstractUserRealm{

    @Autowired
    RoleService roleService;
    @Autowired
    PermissionService permissionService;
    @Override
    public UserRolesAndPermissions doGetGroupAuthorizationInfo(User userInfo) {
        Set<String> userRoles = new HashSet<>();
        Set<String> userPermissions = new HashSet<>();
        //获取当前用户下拥有的所有角色及权限
        String[] roleIDs=roleService.findRolesByUser(userInfo.getId());
        for(String id:roleIDs){
            Role role=roleService.findRolebyID(id);
            if(null!=role){
                userRoles.add(role.getName());
                //取出每个角色的所有权限
                String[] permisionIDs =permissionService.findPermissionsByRole(role.getId());
                for(String pid:permisionIDs){
                    Permission permission=permissionService.findPermissionByID(pid);
                    if(null!=permission){
                        if(!userPermissions.contains(permission.getName())){
                            userPermissions.add(permission.getName());
                        }
                    }
                }
            }
        }
        return new UserRolesAndPermissions(userRoles, userPermissions);
    }

    @Override
    public UserRolesAndPermissions doGetRoleAuthorizationInfo(User userInfo) {
        return doGetGroupAuthorizationInfo(userInfo);
    }
}
