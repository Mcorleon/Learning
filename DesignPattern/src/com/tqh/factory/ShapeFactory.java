package com.tqh.factory;

public class ShapeFactory {
    public Shape getShape(String shape){
        if(shape==null){
            return null;
        }
        //忽略大小写比较
        if(shape.equalsIgnoreCase("circle")){
            return new Circle();
        }
        if(shape.equalsIgnoreCase("rectangle")){
            return new Rectangle();
        }
        if(shape.equalsIgnoreCase("triangle")){
            return new Triangle();
        }
        return null;
    }
}
