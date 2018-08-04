package com.tqh.singleton;

/**
 * 饿汉式
 * 非Lazy初始化，线程安全，效率高，
 * 一般情况下推荐使用
 */
public class Singleton1 {
    private static Singleton1 SINGLETON=new Singleton1();
    private Singleton1(){}
    public static Singleton1 getInstance(){
        return SINGLETON;
    }
}
