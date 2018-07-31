package com.tqh.demo.mapper;

import com.tqh.demo.model.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @Author: Mcorleon
 * @Date: 18-7-27 09:58
 */
@Repository
public interface UserMapper {
    @Select("select * from u_user where nickname=#{name}")
    User findByLoginName(String name);
}
