package com.tqh.prototype;


public class Circle extends Shape {
    public Circle(){
        this.type="circle";
    }
    @Override
    public void draw() {
        System.out.println("i am circle");
    }
}
