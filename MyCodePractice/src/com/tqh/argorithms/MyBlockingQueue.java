package com.tqh.argorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author Mcorleon
 * @Date 2019/8/2 15:29
 */
public class MyBlockingQueue<E> {
    private List<E> list = new ArrayList<E>();
    private int size;
    private Lock lock = new ReentrantLock();
    private Condition notFull = lock.newCondition();
    private Condition notEmpty = lock.newCondition();

    public MyBlockingQueue(int size) {
        this.size = size;
    }

    public boolean put(E node) {
        try {
            lock.lock();
            while (list.size() >= size) {
                notFull.await();
            }
            list.add(node);
            System.out.println("put:" + list);
            notEmpty.signal();
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            lock.unlock();
        }

    }

    public E poll() {
        try {
            lock.lock();
            while (list.isEmpty()) {
                notEmpty.await();
            }
            E node = list.remove(0);
            System.out.println("poll:" + list);
            notFull.signal();
            return node;
        } catch (Exception e) {
            return null;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        MyBlockingQueue<String> blockingQueue = new MyBlockingQueue<>(5);
        Productor productor = new Productor(blockingQueue);
        Consumer consumer = new Consumer(blockingQueue);
        Thread t1 = new Thread(productor);
        Thread t2 = new Thread(consumer);
        t1.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
    }
}

class Productor implements Runnable {

    private MyBlockingQueue<String> blockingQueue;

    public Productor(MyBlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    private int i;

    @Override
    public void run() {
        while (true) {
            blockingQueue.put(i++ + "");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable {

    private MyBlockingQueue<String> blockingQueue;

    public Consumer(MyBlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while (true) {
            blockingQueue.poll();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}