package com.tqh.thread;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
    public static void main(String[] args){
        CountDownLatch countDownLatch=new CountDownLatch(3);
        AAA a1=new AAA(countDownLatch);
        AAA a2=new AAA(countDownLatch);
        AAA a3=new AAA(countDownLatch);
        Thread thread1=new Thread(a1);
        Thread thread2=new Thread(a2);
        Thread thread3=new Thread(a3);
        System.out.println("主线程开始执行");
        thread1.start();
        thread2.start();
        thread3.start();
        try {
            System.out.println("主线程开始等待");
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("主线程继续执行");

    }

}

class AAA implements Runnable{

    private CountDownLatch countDownLatch;
    public AAA(CountDownLatch countDownLatch){
        this.countDownLatch=countDownLatch;
    }
    @Override
    public void run() {
        System.out.println("线程"+Thread.currentThread().getName()+"正在执行");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程"+Thread.currentThread().getName()+"执行完毕");
        countDownLatch.countDown();
    }
}
