package com.tqh.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

public class Test1 {
    public static void main(String[] args){
      Class c=Hero.class;
      Method[] methods=c.getDeclaredMethods();
      for(Method method:methods){
          MyDescribe myDescribe=method.getAnnotation(MyDescribe.class);
          if(myDescribe!=null) {
              System.out.println(method.getName() + "," + myDescribe.version() + "," + myDescribe.id());
          }
      }
    }
}

class Hero{
    String name;
    int age;

    @MyDescribe(version = "1.2",id = 3)
    public void fight(){}
    @MyDescribe
    public void move(){}

}