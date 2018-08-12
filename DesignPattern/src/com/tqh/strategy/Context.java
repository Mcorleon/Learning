package com.tqh.strategy;

/**
 * @Author: Mcorleon
 * @Date: 18-8-12 14:10
 */
public class Context {
    private Strategy strategy;
    public Context(Strategy strategy){
        this.strategy=strategy;
    }
    public int executeStrategy(int a,int b){
        return strategy.doOperation(a,b);
    }
}
