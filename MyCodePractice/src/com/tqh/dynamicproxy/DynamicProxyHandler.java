package com.tqh.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

public class DynamicProxyHandler implements InvocationHandler {
    private Object proxied;//因为是动态代理所以被代理接口声明为基类Object
    public DynamicProxyHandler(Object proxied){
        System.out.println("dynamic proxy handler constructor:"+proxied.getClass());
        this.proxied=proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("dynamic proxy name: " + proxy.getClass());
        System.out.println("method: " + method.getName());
        System.out.println("args: " + Arrays.toString(args));
        //调用方法
        Object invokeObject= method.invoke(proxied,args);
        return invokeObject;
    }
}
