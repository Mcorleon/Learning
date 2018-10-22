package com.tqh.thinkinginjava;

import java.lang.reflect.Constructor;

public class Test3 {
    public static void main(String[] args){
    Class c=Dog.class;
        Constructor[] constructors=c.getConstructors();
        System.out.println(constructors[1]);
        try {

            constructors[1].newInstance(2);
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}

class Dog{
    public Dog(){
        System.out.println("A Dog Created");
    }
    public Dog(int age){System.out.println("hi");};
    static {
        System.out.println("Initializing..");
    }
}