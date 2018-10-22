package com.tqh.thread;


import java.util.concurrent.*;

public class Test3 {
    public static void main(String[] args) throws InterruptedException {
       // ExecutorService executorService=Executors.newCachedThreadPool();
        ExecutorService executorService= new ThreadPoolExecutor(2,2,1000L,TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(1024) ,new myThreadFactory(),new ThreadPoolExecutor.AbortPolicy());
        Rocket rocket1=new Rocket();
        Rocket rocket2=new Rocket();
        Rocket rocket3=new Rocket();
        Rocket rocket4=new Rocket();
        Rocket rocket5=new Rocket();
        executorService.execute(rocket1);
        System.out.println(Thread.currentThread().getName());
        executorService.execute(new Ship(rocket1));
        executorService.execute(rocket2);
        executorService.execute(new Ship(rocket2));
        executorService.execute(rocket3);
        executorService.execute(new Ship(rocket3));
        executorService.execute(rocket4);
        executorService.execute(new Ship(rocket4));
        executorService.execute(rocket5);
        executorService.execute(new Ship(rocket5));
        executorService.shutdown();
    }
}


class Rocket implements Runnable{

    public Boolean flag=false;
    @Override
    public synchronized void run() {
        try {
            System.out.println(Thread.currentThread().getName());
            while (!flag) {
                wait();
           }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("waken");
    }
}

class Ship implements Runnable{

    private Rocket rocket;
    public Ship(Rocket rocket){
        this.rocket=rocket;
    }
    @Override
    public  void run() {
        synchronized(rocket) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            rocket.flag = true;
            rocket.notifyAll();
        }
    }
}

class  myThreadFactory implements ThreadFactory{
    private static int num;

    @Override
    public Thread newThread(Runnable r) {
        num++;
        return new Thread(r,"myThead-no."+num);
    }
}