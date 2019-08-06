package com.tqh.argorithms;

/**
 * @Author Mcorleon
 * @Date 2019/6/22 11:05
 */
public class ABC_Thread {
    public static void main(String[] args) throws Exception{
        Object a=new Object();
        Object b=new Object();
        Object c=new Object();
        Thread t1=new Thread(new PrintThread("A",a,c));
        Thread t2=new Thread(new PrintThread("B",b,a));
        Thread t3=new Thread(new PrintThread("C",c,b));
        t1.start();
        t2.start();
        t3.start();


    }
}

class PrintThread implements Runnable{
    int count=10;
    private String s;
    private Object self;
    private Object pre;
    public PrintThread(String s,Object self,Object pre){
        this.s=s;
        this.self=self;
        this.pre=pre;
    }
    @Override
    public void run() {
        int count=10;
        while (count>0){
            synchronized (pre){
                synchronized (self){
                    count--;
                    System.out.println(s);
                    self.notify();
                }
                try {
                    pre.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
