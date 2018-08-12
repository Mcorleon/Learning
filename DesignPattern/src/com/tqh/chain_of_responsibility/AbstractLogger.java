package com.tqh.chain_of_responsibility;

/**
 * @Author: Mcorleon
 * @Date: 18-8-8 10:35
 */
public abstract class AbstractLogger {
    protected static int ERROR=3;
    protected static int DEBUG=2;
    protected static int INFO=1;

    protected int level;
    protected AbstractLogger nextLgger;
    public void setNextLogger(AbstractLogger nextLgger){
        this.nextLgger=nextLgger;
    }

    public void logMessage(String mes,int level){
        //在自己level范围内的请求就处理，然后交给责任链的下一环
        //也可以改写成找到能够处理的类，处理完就终止
        if(this.level<=level){
            write(mes);
        }
        if(nextLgger!=null){
            nextLgger.logMessage(mes,level);
        }
    }

    abstract public void write(String mes);
}
