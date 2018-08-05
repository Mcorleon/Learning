package com.tqh.filter;

/**
 * @Author: Mcorleon
 * @Date: 18-8-5 11:12
 */
public class Dog {
    String name;
    int age;
    String color;
    public Dog(String name,int age,String color){
        setName(name);
        setAge(age);
        setColor(color);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString(){
        return getName()+" "+getAge()+" "+getColor();
    }
}
