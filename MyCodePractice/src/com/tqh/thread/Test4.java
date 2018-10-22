package com.tqh.thread;

import java.util.*;
import java.util.concurrent.*;

/**
测试collection容器的线程安全
 */
public class Test4 {
    public static void main(String[] args) throws InterruptedException {
        ArrayList arrayList=new ArrayList();
        Vector vector=new Vector();
        CopyOnWriteArrayList copyOnWriteArrayList=new CopyOnWriteArrayList();
        List synchronizedList= Collections.synchronizedList(new ArrayList());

        Con1 con1=new Con1(arrayList);
        Con2 con2=new Con2(arrayList);
        Thread thread1=new Thread(con1);

        Thread thread2=new Thread(con2);
        thread1.start();
        thread2.start();
//        TimeUnit.SECONDS.sleep(2);
//        for (int i = 0; i <1000 ; i++) {
//            System.out.println(copyOnWriteArrayList.get(i));
//        }
    }

}

class Con1 implements Runnable{

    private Collection collection;
    public Con1(Collection collection){
        this.collection=collection;
    }

    @Override
    public void run() {
            for (int i = 0; i < 500; i++) {
                collection.add(i);
//                try {
//                    Thread.sleep(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
    }
}
class Con2 implements Runnable{

    private Collection collection;
    public Con2(Collection collection){
        this.collection=collection;
    }
    @Override
    public void run() {
           Iterator iterator=collection.iterator();
           while (iterator.hasNext()){
               System.out.println(iterator.next());
           }

//        for (int i = 500; i < 1000; i++) {
//            collection.add(i);
//            try {
//                Thread.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
    }

}