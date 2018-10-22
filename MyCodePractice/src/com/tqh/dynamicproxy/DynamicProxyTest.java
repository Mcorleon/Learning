package com.tqh.dynamicproxy;

import com.tqh.proxy.Hello;
import com.tqh.proxy.HelloIml;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;

public class DynamicProxyTest {
    public static void main(String[] args){
        consumer(new HelloIml());
        System.out.println("------------------");

        //动态代理 相比于SimpleProxy只代理了Hello接口，动态代理DynamicProxyHandler可以代理任何接口
        ClassLoader classLoader=Hello.class.getClassLoader();
        Class<?>[] interfaces=new Class[]{Hello.class};
        InvocationHandler invocationHandler=new DynamicProxyHandler(new HelloIml());
        Hello proxy= (Hello) Proxy.newProxyInstance(classLoader,interfaces,invocationHandler);
        System.out.println("in dynamic proxy:"+proxy.getClass());
        consumer(proxy);
    }
    private static void consumer(Hello hello){

        hello.showHello();
        hello.getMyName("tqh");
    }
}
