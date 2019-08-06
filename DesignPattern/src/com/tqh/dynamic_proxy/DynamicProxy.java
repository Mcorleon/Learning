package com.tqh.dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author Mcorleon
 * @Date 2019/7/5 16:40
 */
public class DynamicProxy implements InvocationHandler {
    private Object obj;

    public DynamicProxy(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("help to deal");
        Object res=method.invoke(obj,args);
        System.out.println("after deal");
        return res;
    }
}
