package com.tqh.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import com.tqh.Person;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class TestMybatis {
    @Test
    public void ceshi() throws IOException {
        /**
         *  1、获得 SqlSessionFactory
         *  2、获得 SqlSession
         *  3、调用在 mapper 文件中配置的 SQL 语句
         */
        String resource = "sqlMapConfig.xml";           // 定位核心配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);    // 创建 SqlSessionFactory

        SqlSession sqlSession = sqlSessionFactory.openSession();    // 获取到 SqlSession

        // 调用 mapper 中的方法：命名空间 + id
        List<Person> personList = sqlSession.selectList("com.tqh/mapper.UserMapper.findAll");

        for (Person p : personList) {
            System.out.println(p);
        }
    }

    @Test
    public void testInsert() throws Exception {
        String resource = "sqlMapConfig.xml";           // 定位核心配置文件
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);    // 创建 SqlSessionFactory

        SqlSession sqlSession = sqlSessionFactory.openSession();    // 获取到 SqlSession
        //获取到 SqlSession

        Person p = new Person();
        p.setId(5);
        p.setName("gavin");
        p.setAge(12);

        sqlSession.insert("com.tqh/mapper.UserMapper.insert", p);
        sqlSession.commit();            //默认是不自动提交，必须手工提交
    }

    @Test
    public void testUpdate(){
        String resource = "sqlMapConfig.xml";           //定位核心配置文件
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);        // 创建 SqlSessionFactory

        SqlSession sqlSession = sqlSessionFactory.openSession();            // 获取到 SqlSession

        Person p = sqlSession.selectOne("com.tqh/mapper.UserMapper.get", 2);   // 获得 id=2 的记录
        p.setName("jane");
        p.setAge(16);

        // sqlSession.insert("yeepay.payplus.mapper.UserMapper.update", p);
        sqlSession.update("com.tqh/mapper.UserMapper.update", p);
        sqlSession.commit();            //默认是不自动提交，必须手工提交
    }

    @Test
    public void testDelete(){
        String resource = "sqlMapConfig.xml";           //定位核心配置文件
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);        // 创建 SqlSessionFactory

        SqlSession sqlSession = sqlSessionFactory.openSession();            // 获取到 SqlSession


        sqlSession.delete("com.tqh/mapper.UserMapper.delete",5);
        sqlSession.commit();            //默认是不自动提交，必须手工提交
    }
}