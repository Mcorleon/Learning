package com.tqh.demo.mapper;

import com.tqh.demo.model.Permission;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @Author: Mcorleon
 * @Date: 18-7-26 16:49
 */
@Repository
public interface PermissionMapper {
    @Select("select * from u_role_permission where rid=#{id}")
    String[] findPermissionsByRole(String id);

    @Select("select * from u_permission where id=#{id}")
    Permission findPermissionByID(String id);
}
