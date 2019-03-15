package com.tqh.singleton;


/**
 * 枚举方式
 * 最简单，非lazy，线程安全
 * 推荐使用这个方式，调用方法：Singleton5.INSTANCE.whateverMethod()
 */
public enum Singleton5 {
    INSTANCE;
    public void whateverMethod(){}
}
