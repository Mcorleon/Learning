package com.tqh.generic;

public class Test3 {
    static void test(Generic1<? super Apple> generic1){
        generic1.method(new Apple());
    }
    static void test2(Generic2<? extends Fruit> generic2){
        generic2.method(new Apple());
    }
    public static void main(String[] args){
    }
}
class Generic1<T>{
    public void method(T t){
        System.out.println(t.toString());
    }
}

class Generic2<T>{

    public T method(Object x){

        return (T) x;
    }
}

class Fruit{

}
class Apple extends Fruit{

}