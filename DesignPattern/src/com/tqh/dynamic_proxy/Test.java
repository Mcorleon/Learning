package com.tqh.dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @Author Mcorleon
 * @Date 2019/7/5 16:44
 */
public class Test {
    public static void main(String[] args){
        InvocationHandler managerProxy=new DynamicProxy(new RealManager());
        //加上这句将会产生一个$Proxy0.class文件，这个文件即为动态生成的代理类文件
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
        Manager manager=(Manager)( Proxy.newProxyInstance(managerProxy.getClass().getClassLoader(),
                new Class[]{Manager.class},managerProxy));
        manager.dealBusiness();
    }
}
