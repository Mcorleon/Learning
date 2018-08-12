package com.tqh.flyweight;

/**
 * @Author: Mcorleon
 * @Date: 18-8-7 10:57
 */
public class Test {
    public static void main(String[] args){
        Pen pen1=(Pen) PenFactory.getPen("blue pen");
        Pen pen2=(Pen) PenFactory.getPen("red pen");
        Pen pen3=(Pen) PenFactory.getPen("yellow pen");
        Pen pen4=(Pen) PenFactory.getPen("blue pen");
        Pen pen5=(Pen) PenFactory.getPen("red pen");
        pen1.use();
        pen2.use();
        pen3.use();
        pen4.use();
        pen5.use();

    }
}
