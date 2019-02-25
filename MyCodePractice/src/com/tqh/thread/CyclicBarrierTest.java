package com.tqh.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {
    public static void main(String[] args){
        CyclicBarrier cyclicBarrier=new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                System.out.println("栅栏开啦,该Runable执行线程为"+Thread.currentThread().getName());
            }
        });
        BBB b1=new BBB(cyclicBarrier,3000);
        BBB b2=new BBB(cyclicBarrier,5000);
        BBB b3=new BBB(cyclicBarrier,7000);
        new Thread(b1).start();
        new Thread(b2).start();
        new Thread(b3).start();

    }
}

class BBB implements Runnable{

    private CyclicBarrier cyclicBarrier;
    private int sleepTime;
    public BBB(CyclicBarrier cyclicBarrier,int sleepTime){
        this.cyclicBarrier=cyclicBarrier;
        this.sleepTime=sleepTime;
    }
    @Override
    public void run() {
        System.out.println("线程"+Thread.currentThread().getName()+"正在执行");
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("线程"+Thread.currentThread().getName()+"开始等待");
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println("线程"+Thread.currentThread().getName()+"继续执行");

    }
}