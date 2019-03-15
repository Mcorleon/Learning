package com.tqh.singleton;

/**
 * 静态内部类对饿汉式改进，使之Lazy初始化(需要的时候再初始化)
 */
public class Singleton2 {
    private static class SingletonHolder{
        private static Singleton2 INSTANCE=new Singleton2();
    }
    private Singleton2(){}
    public static  Singleton2 getInstance(){
        return SingletonHolder.INSTANCE;
    }
}
