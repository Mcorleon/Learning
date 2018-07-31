package com.tqh.demo.mapper;

import com.tqh.demo.model.Role;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @Author: Mcorleon
 * @Date: 18-7-26 16:28
 */
@Repository
public interface RoleMapper {
    @Select("select * from u_user_role where uid=#{id}")
    String[] findRolebyUser(String id);

    @Select("select * from u_role where id=#{id}")
    Role findRolebyID(String id);

}
