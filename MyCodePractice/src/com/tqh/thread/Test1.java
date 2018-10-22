package com.tqh.thread;

import java.util.Random;
import java.util.concurrent.*;

public class Test1 {
    public static void main(String[] args){
//        for (int i = 0; i <5 ; i++) {
//            Game game=new Game();
//            Thread thread=new Thread(game);
//            thread.start();
//        }
        ExecutorService executorService= Executors.newCachedThreadPool();
        for(int i=0;i<8 ;i++){
               executorService.execute(new Game());
        }
        executorService.shutdown();
//        Future<String> future=executorService.submit(new Battle());
//        try {
//            System.out.println(future.get());
//            System.out.println(future.isDone());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }

    }
}

class Game implements Runnable{

    private int countDown=10;
    public static int taskCount=0;
    private final int id=taskCount++;
    public void showStatus(){
        System.out.println(id+"-"+countDown--);
    }
    @Override
    public void run() {
//        while (countDown>=0){
//            showStatus();
//            Thread.yield();
//        }
        Random random=new Random();
        int sleepTime=random.nextInt(10);
        try {
            TimeUnit.SECONDS.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("No."+id+" sleep "+sleepTime+"s");
    }
}

class Battle implements Callable<String>{

    @Override
    public String call() throws Exception {
        return "tqh";
    }
}