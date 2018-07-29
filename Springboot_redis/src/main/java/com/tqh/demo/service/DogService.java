package com.tqh.demo.service;

import com.tqh.demo.mapper.DogMapper;
import com.tqh.demo.model.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "dogs")
public class DogService {
    @Autowired
    DogMapper dogMapper;

    @Cacheable(key ="'dog'+#p0")
    public Dog selectDog(String id){
        System.out.println("select");
        return dogMapper.findById(id);
    }
}
