package com.tqh.prototype;


public class Triangle extends Shape {
    public Triangle(){
        this.type="triangle";
    }
    @Override
    public void draw() {
        System.out.println("i am triangle");
    }
}
