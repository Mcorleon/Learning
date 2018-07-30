package com.tqh.test;

import com.tqh.model.Person;
import com.tqh.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


// 加载spring配置文件
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class DaoTest {

        @Autowired
        private UserService userService;

        @Test
        public void testSelectUser() throws Exception {
            int id = 1;
            Person person = userService.selectUser(id);
            System.out.println(person.getName());
        }


}
