package com.tqh.observer;

public class BinaryObserver extends Observer {
    public BinaryObserver(Subject subject){
        this.subject=subject;
        subject.attach(this);
    }
    @Override
    public void update() {
        System.out.println("binary:"+Integer.toBinaryString(subject.getState()));
    }
}
