package com.tqh.generic;

public class Test2 {
    public static <T extends A>void methodA(T a){
        a.sayHello();
    }
    public static <T extends B>void methodB(T b){
        b.sayBye();
    }
    public static void main(String[] args){
      Imp imp=new Imp();
      methodA(imp);
      methodB(imp);
    }
}

interface A{
   void sayHello();
}
interface B{
    void sayBye();
}

class Imp implements A,B{

    @Override
    public void sayHello() {
        System.out.println("hello");
    }

    @Override
    public void sayBye() {
        System.out.println("Bye");
    }

}