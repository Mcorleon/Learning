package com.tqh.thinkinginjava;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

public class ExceptionTest {
    static int count=0;
    static int i=0;
    public static void main(String[] args) {


        try {

            A a=new A();
        }catch (Exception3 e){
            e.printStackTrace();
        }

    }

}

class A{
    public void f() throws Exception{
        try {
            g();
        }catch (Exception1 e){
            e.printStackTrace();
            throw new RuntimeException(e);

        }
    }
    public  void g() throws Exception1 {
        throw new Exception1();
    }
    public A() throws Exception3{
        throw new Exception3();
    }

    public void dispose(){
        System.out.println("A disposed");
    }


}
class B extends A{
    public B() throws Exception3 {
    }

    @Override
    public void g() throws Exception1 {

    }
}
class Exception1 extends Exception{

}
class Exception2 extends Exception{

}
class Exception3 extends Exception{

}