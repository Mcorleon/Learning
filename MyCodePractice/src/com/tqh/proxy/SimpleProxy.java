package com.tqh.proxy;

public class SimpleProxy implements Hello {
    private Hello proxied;//被代理对象
    public SimpleProxy(Hello proxied){
        this.proxied=proxied;

    }
    @Override
    public void showHello() {
        System.out.println("proxy showHello");
        proxied.showHello();
    }

    @Override
    public void getMyName(String name) {
        System.out.println("proxy getMyName");
        proxied.getMyName(name);
    }
}
