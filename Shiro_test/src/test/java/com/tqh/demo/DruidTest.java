package com.tqh.demo;

import com.alibaba.druid.filter.config.ConfigTools;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.junit.Test;

/**
 * @Author: Mcorleon
 * @Date: 18-7-28 10:48
 */
public class DruidTest {
    @Test
    public void passwordGen(){
        String hashAlgorithmName = "MD5";
        String credentials = "123456";
        int hashIterations = 1024;
        ByteSource credentialsSalt = ByteSource.Util.bytes("admin");
        Object obj = new SimpleHash(hashAlgorithmName, credentials, credentialsSalt, hashIterations);
        System.out.println(obj);
    }
}
