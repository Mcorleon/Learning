package com.tqh.prototype;

public class Test {
    public static void main(String[] args){
        ShapCache.loadCache();
        Shape clonedShape=ShapCache.getShape("1");
        System.out.println(clonedShape.getType());
    }
}
