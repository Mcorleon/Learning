package com.tqh.demo.mapper;

import com.tqh.demo.model.Dog;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface DogMapper {
    @Select("select * from dog where id =#{id}")
    Dog findById(@Param("id") String id);
}
