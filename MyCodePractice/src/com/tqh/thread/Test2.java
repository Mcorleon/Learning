package com.tqh.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Test2 {
    public static void main(String[] args) {
        Dog dog=new Dog();
        Thread thread1=new Thread(dog,"aaa");
        Thread thread2=new Thread(dog,"B");
        thread1.start();
        thread2.start();



    }
}

class Dog implements Runnable {

    private int num = 0;

    public  void add() {
        num++;
        System.out.println(Thread.currentThread().getName()+" "+num);
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Override
    public synchronized void run() {
        for (int i = 0; i <10 ; i++) {

            add();
        }

    }
}

