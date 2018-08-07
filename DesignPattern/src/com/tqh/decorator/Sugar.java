package com.tqh.decorator;

/**
 * @Author: Mcorleon
 * @Date: 18-8-7 10:18
 */
public class Sugar extends DrinkDecorator {
    public Sugar(Drink drink) {
        super(drink);
    }

    @Override
    public void description() {
        super.description();
        System.out.println("sugar");
    }
}
