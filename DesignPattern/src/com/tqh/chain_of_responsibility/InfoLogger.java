package com.tqh.chain_of_responsibility;

/**
 * @Author: Mcorleon
 * @Date: 18-8-8 10:58
 */
public class InfoLogger extends AbstractLogger {
    @Override
    public void write(String mes) {
        System.out.println();
    }
}
