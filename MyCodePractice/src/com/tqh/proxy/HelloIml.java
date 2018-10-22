package com.tqh.proxy;

import com.tqh.thinkinginjava.AAA;
import com.tqh.thinkinginjava.Holder;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HelloIml implements Hello {
    @Override
    public void showHello() {
        System.out.println("hi!");
    }

    @Override
    public void getMyName(String name) {
        System.out.println("my name is "+name);
    }

    public static void main(String[] args){
        try {
            AAA a=new AAA();
            Class c=Class.forName("com.tqh.thinkinginjava.AAA");
            Method method=c.getDeclaredMethod("f");
            method.setAccessible(true);
            method.invoke(a);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        Holder<AAA> aaaHolder=new Holder<>(new AAA(),new AAA(),new AAA());
        System.out.println(aaaHolder.getA());
        System.out.println(aaaHolder.getB());
        System.out.println(aaaHolder.getC());
        Holder<Integer> intHolder=new Holder<Integer>(1,2,3);
        System.out.println(intHolder.getA());
        System.out.println(intHolder.getB());
        System.out.println(intHolder.getC());

    }
}
