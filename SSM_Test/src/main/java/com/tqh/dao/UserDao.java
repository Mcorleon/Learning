package com.tqh.dao;

import com.tqh.model.Person;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

     Person selectUser(int id);

}