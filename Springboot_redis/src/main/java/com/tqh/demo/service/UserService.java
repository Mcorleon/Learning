package com.tqh.demo.service;

import com.tqh.demo.mapper.UserMapper;
import com.tqh.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
//
//@Cacheable将查询结果缓存到redis中，（key="#p0"）指定传入的第一个参数作为redis的key。
//
//@CachePut，指定key，将更新的结果同步到redis中
//
//@CacheEvict，指定key，删除缓存数据，allEntries=true,方法调用后将立即清除缓存
@Service
@CacheConfig(cacheNames = "users")
public class UserService {
    @Autowired
    UserMapper userMapper;

    @Cacheable(key ="#p0")
    public User selectUser(String id){
        System.out.println("select");
        return userMapper.findById(id);
    }

    @CachePut(key = "#p0")
    public void updataById(String id, String name){
        System.out.println("update");
        userMapper.updataById(id,name);
    }

    //如果指定为 true，则方法调用后将立即清空所有缓存
    @CacheEvict(key ="#p0",allEntries=true)
    public void deleteById(String id){
        System.out.println("delete");
        userMapper.deleteById(id);
    }
}
