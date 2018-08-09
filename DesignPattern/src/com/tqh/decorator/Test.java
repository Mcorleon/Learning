package com.tqh.decorator;

/**
 * @Author: Mcorleon
 * @Date: 18-8-7 10:21
 */
public class Test {
    public static void main(String[] args){
        Cola cola=new Cola();
        Milk milk=new Milk();
        Sugar sugarMilk =new Sugar(milk);
        Sugar sugarCola =new Sugar(cola);
        cola.description();
        milk.description();
        sugarCola.description();
        sugarMilk.description();
    }
}
