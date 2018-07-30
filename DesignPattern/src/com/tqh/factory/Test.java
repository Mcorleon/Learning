package com.tqh.factory;

public class Test {
    public static void main(String[] args){
        ShapeFactory shapeFactory=new ShapeFactory();
        Shape shape1=shapeFactory.getShape("triangle");
        Shape shape2=shapeFactory.getShape("rectangle");
        Shape shape3=shapeFactory.getShape("circle");
        shape1.draw();
        shape2.draw();
        shape3.draw();
    }
}
