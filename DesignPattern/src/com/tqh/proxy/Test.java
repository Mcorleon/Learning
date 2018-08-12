package com.tqh.proxy;

/**
 * @Author: Mcorleon
 * @Date: 18-8-8 09:46
 */
public class Test {
    public static void main(String[] args){
        RealManager manager=new RealManager();
        manager.dealBusiness();
        ProxyManager proxyManager=new ProxyManager();
        proxyManager.dealBusiness();
    }
}
