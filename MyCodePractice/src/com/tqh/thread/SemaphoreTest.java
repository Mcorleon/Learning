package com.tqh.thread;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {
    public static void main(String[] args){
        Semaphore semaphore=new Semaphore(2);
        Worker worker1=new Worker(semaphore);
        Worker worker2=new Worker(semaphore);
        Worker worker3=new Worker(semaphore);
        Worker worker4=new Worker(semaphore);
        Worker worker5=new Worker(semaphore);
        new Thread(worker1).start();
        new Thread(worker2).start();
        new Thread(worker3).start();
        new Thread(worker4).start();
        new Thread(worker5).start();
    }
}

class Worker implements Runnable{

    private Semaphore semaphore;
    public Worker(Semaphore semaphore){
        this.semaphore=semaphore;
    }
    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.println("工人"+Thread.currentThread().getName()+"正在用钳子工作");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("工人"+Thread.currentThread().getName()+"放下了钳子");
        semaphore.release();
    }
}