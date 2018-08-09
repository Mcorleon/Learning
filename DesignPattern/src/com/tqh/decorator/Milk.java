package com.tqh.decorator;

/**
 * @Author: Mcorleon
 * @Date: 18-8-7 10:11
 */
public class Milk implements Drink {
    @Override
    public void description() {
        System.out.println("milk");
    }
}
