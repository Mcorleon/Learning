package com.tqh.singleton;

/**
 * 双重校验锁方式优化懒汉式
 * lazy初始化，并在多线程下保证高性能
 * volatile防止new重排序，导致INSTANCE先分配了地址而未初始化，防止第二个线程得到不为null却未初始化的INSTANCE
 */
public class Singleton4 {
    private  volatile static Singleton4 INSTANCE;
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
