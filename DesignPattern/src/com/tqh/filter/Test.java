package com.tqh.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Mcorleon
 * @Date: 18-8-5 11:24
 */
public class Test {
    public static void main(String[] args){
         Dog dog1=new Dog("hoho",3,"white");
         Dog dog2=new Dog("momo",13,"black");
         Dog dog3=new Dog("lili",5,"black");
         Dog dog4=new Dog("shake",7,"black");
         Dog dog5=new Dog("swang",6,"white");
         Dog dog6=new Dog("pp",6,"white");
        List<Dog> dogs=new ArrayList<>();
        dogs.add(dog1);
        dogs.add(dog2);
        dogs.add(dog3);
        dogs.add(dog4);
        dogs.add(dog5);
        dogs.add(dog6);
        AgeCriteria ageCriteria=new AgeCriteria();
        ColorCriteria colorCriteria=new ColorCriteria();
        AndCriteria andCriteria=new AndCriteria(ageCriteria,colorCriteria);
        System.out.println("black dogs:"+colorCriteria.meetCriteria(dogs));
        System.out.println("age<10 dogs:"+ageCriteria.meetCriteria(dogs));
        System.out.println("both:"+ andCriteria.meetCriteria(dogs));

    }
}