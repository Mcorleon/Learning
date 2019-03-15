package com.tqh.singleton;

/**
 * 双重校验锁方式优化懒汉式
 * lazy初始化，并在多线程下保证高性能
 */
public class Singleton4 {
    private  static Singleton4 INSTANCE;
    private Singleton4(){}
    private static Singleton4 getInstance(){
        if(INSTANCE==null){
            synchronized (Singleton4.class){
                if(INSTANCE==null){
                    INSTANCE=new Singleton4();
                }
            }
        }
        return INSTANCE;
    }
}
