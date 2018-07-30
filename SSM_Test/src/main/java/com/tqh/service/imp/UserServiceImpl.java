package com.tqh.service.imp;

import com.tqh.dao.UserDao;
import com.tqh.model.Person;
import com.tqh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public Person selectUser(int userId) {
        return this.userDao.selectUser(userId);
    }


}
