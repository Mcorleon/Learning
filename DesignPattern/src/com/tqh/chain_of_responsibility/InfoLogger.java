package com.tqh.chain_of_responsibility;

/**
 * @Author: Mcorleon
 * @Date: 18-8-8 10:58
 */
public class InfoLogger extends AbstractLogger {
    public InfoLogger(int level){
        this.level=level;
    }
    @Override
    public void write(String mes) {
        System.out.println("Info:"+mes);
    }
}
