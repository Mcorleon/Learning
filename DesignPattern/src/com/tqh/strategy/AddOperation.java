package com.tqh.strategy;

/**
 * @Author: Mcorleon
 * @Date: 18-8-12 14:09
 */
public class AddOperation implements Strategy {
    @Override
    public int doOperation(int a, int b) {
        return a+b;
    }
}
