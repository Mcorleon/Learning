package com.tqh.thinkinginjava;

import java.util.ArrayList;

public class Holder<T> {
    private T a;
    private T b;
    private T c;

    public Holder(T a,T b,T c){
        this.a=a;
        this.b=b;
        this.c=c;
    }
    public T getA() {
        return a;
    }

    public void setA(T a) {
        this.a = a;
    }

    public T getB() {
        return b;
    }

    public void setB(T b) {
        this.b = b;
    }

    public T getC() {
        return c;
    }

    public void setC(T c) {
        this.c = c;
    }
}
