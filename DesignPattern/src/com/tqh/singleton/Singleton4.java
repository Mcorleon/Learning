package com.tqh.singleton;

/**
 * 枚举方式
 * 最简单，非lazy，线程安全
 */
public enum Singleton4 {
    INSTANCE;
    public void whateverMethod(){}
}