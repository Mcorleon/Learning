package com.tqh.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 测试map容器的线程安全
 */
public class Test5 {
    public static void main(String[] args) throws InterruptedException {
        HashMap hashMap=new HashMap();
        ConcurrentHashMap concurrentHashMap=new ConcurrentHashMap();
        Con3 con3=new Con3(concurrentHashMap);
        Con4 con4=new Con4(concurrentHashMap);
        Thread thread1=new Thread(con3);
        Thread thread2=new Thread(con4);
        thread1.start();
        thread2.start();
        TimeUnit.SECONDS.sleep(2);
        for (int i = 0; i <1000 ; i++) {
            System.out.println(concurrentHashMap.get(i));
        }
    }

}

class Con3 implements Runnable{
    ExecutorService executorServic= Executors.newCachedThreadPool();
    private Map map;
    public  Con3(Map map){
        this.map=map;
    }
    @Override
    public void run() {
        for(int i=0,j=0;i<500 ;i++,j+=2){
            map.put(i,j);
            try {
                TimeUnit.MILLISECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Con4 implements Runnable{

    private Map map;
    public  Con4(Map map){
        this.map=map;
    }
    @Override
    public void run() {
//        for (int i = 0; i <map.size() ; i++) {
//            System.out.println(map.get(i));
//        }
        for(int i=500,j=1000;i<1000 ;i++,j+=2){
            map.put(i,j);
            try {
                TimeUnit.MILLISECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}