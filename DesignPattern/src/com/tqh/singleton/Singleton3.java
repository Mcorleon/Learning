package com.tqh.singleton;

/**
 * 双重校验锁方式
 * lazy初始化，并在多线程下保证高性能
 * volatile禁止语义重排序优化
 */
public class Singleton3 {
    private volatile static Singleton3 INSTANCE;
    private Singleton3(){}
    private static Singleton3 getInstance(){
        if(INSTANCE==null){
            synchronized (Singleton3.class){
                if(INSTANCE==null){
                    INSTANCE=new Singleton3();
                }
            }
        }
        return INSTANCE;
    }
}