package com.tqh.chain_of_responsibility;

/**
 * @Author: Mcorleon
 * @Date: 18-8-8 10:55
 */
public class ErrorLogger extends AbstractLogger {
    public ErrorLogger(int level){
        this.level=level;
    }
    @Override
    public void write(String mes) {
        System.out.println("Error:"+mes);
    }
}
