package com.tqh.decorator;

/**
 * @Author: Mcorleon
 * @Date: 18-8-7 10:12
 */
public abstract class DrinkDecorator implements Drink {

    protected Drink drink;
    public DrinkDecorator(Drink drink){
        this.drink=drink;
    }
    @Override
    public void description() {
        drink.description();
    }
}
