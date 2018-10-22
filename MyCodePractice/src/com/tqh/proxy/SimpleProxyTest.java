package com.tqh.proxy;

public class SimpleProxyTest {
    public static void main(String [] args){
       consume(new HelloIml());
        System.out.println("----------------------------------");
       consume(new SimpleProxy(new HelloIml()));
    }

    private static void consume(Hello hello){
        hello.showHello();
        hello.getMyName("tqh");
    }
}
