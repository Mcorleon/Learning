package com.tqh.generic;

import com.tqh.thinkinginjava.AAA;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class GenericMethods {
    public <T,U>void f(T x,U y,AAA z){
        System.out.println(x.getClass().getName());
        System.out.println(y.getClass().getName());
        System.out.println(z.getClass().getName());
    }

    public static <T>Object create(Class<T> t){

        try {
            Constructor constructor=  t.getDeclaredConstructors()[1];
            return constructor.newInstance(1);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args){
//        GenericMethods g=new GenericMethods();
//        String s="111";
//        int a=1;
//        double b=2.3d;
//        g.f(s,a,new AAA());
        System.out.println(create(X.class));
    }
}

class X{

    int age;
    X(){}
    X(int i){
        this.age=i;
    }
}