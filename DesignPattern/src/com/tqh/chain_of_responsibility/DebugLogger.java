package com.tqh.chain_of_responsibility;

/**
 * @Author: Mcorleon
 * @Date: 18-8-8 10:57
 */
public class DebugLogger extends AbstractLogger {
    public DebugLogger(int level){
        this.level=level;
    }
    @Override
    public void write(String mes) {
        System.out.println("Debug:"+mes);
    }
}
