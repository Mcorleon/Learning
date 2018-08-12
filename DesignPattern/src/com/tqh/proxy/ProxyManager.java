package com.tqh.proxy;

/**
 * @Author: Mcorleon
 * @Date: 18-8-8 09:44
 */
public class ProxyManager implements Manager {
    private RealManager realManager;
    @Override
    public void dealBusiness() {
        if(realManager==null){
            realManager=new RealManager();
        }
        System.out.print("help to deal------");
        realManager.dealBusiness();
    }
}
