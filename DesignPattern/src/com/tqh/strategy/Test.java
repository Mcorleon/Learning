package com.tqh.strategy;

/**
 * @Author: Mcorleon
 * @Date: 18-8-12 14:13
 */
public class Test {
    public static void main(String[] args){
        Context context=new Context(new AddOperation());
        System.out.println(context.executeStrategy(2,5));
        context=new Context(new MultiplyOperation());
        System.out.println(context.executeStrategy(2,5));
    }
}
