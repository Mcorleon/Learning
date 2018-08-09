package com.tqh.flyweight;

/**
 * @Author: Mcorleon
 * @Date: 18-8-7 10:44
 */
public class Pen implements Tool {
    private String name;
    public Pen(String name){
        this.name=name;
    }
    @Override
    public void use() {
        System.out.println("use "+name);
    }
}
