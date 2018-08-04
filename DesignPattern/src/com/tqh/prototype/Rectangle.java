package com.tqh.prototype;


public class Rectangle extends Shape {
    public Rectangle(){
        this.type="rectangle";
    }
    @Override
    public void draw() {
        System.out.println("i am rectangle");
    }
}
