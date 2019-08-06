package com.tqh.dynamic_proxy;



/**
 * @Author: Mcorleon
 * @Date: 18-8-8 09:43
 */
public class RealManager implements Manager {
    @Override
    public void dealBusiness() {
        System.out.println("deal");
    }
}
