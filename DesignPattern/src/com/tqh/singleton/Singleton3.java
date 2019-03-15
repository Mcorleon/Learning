package com.tqh.singleton;



/**
 * 懒汉式，需要时再加载
 * 线程不安全
 */
public class Singleton3 {
    private static Singleton3 INSTANCE;
    private Singleton3(){}
    private static Singleton3 getInstance(){
        if(INSTANCE==null){
            INSTANCE=new Singleton3();
        }
        return INSTANCE;
    }
}