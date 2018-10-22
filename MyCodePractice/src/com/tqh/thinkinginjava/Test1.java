package com.tqh.thinkinginjava;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author tqh
 * @version 1.0
 * */
public class Test1 {
    public static void main(String[] args) throws Exception{
//           Class aa =Class.forName("com.tqh.thinkinginjava.Amphibian");
//           Object oj=aa.newInstance();
//          Method[] fs=aa.getDeclaredMethods();
//           for(Method field:fs)
//           System.out.println(field);
        f(1,2,3);

    }

    public static void f(int...ints){
        System.out.println(ints[0]);
    }



}
class Amphibian{

    public int a;
    private int b;
    int c;
    public int sub(int a, int b){
        return a-b;
    }

}

class Frog extends Amphibian{


    public  void move(){
        System.out.println("move Frog");
    }
}