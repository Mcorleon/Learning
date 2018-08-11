package com.tqh.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private int state;
    private List<Observer> observerList=new ArrayList<>();
    public void attach(Observer observer){
        observerList.add(observer);
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObserver();
    }

    public void notifyAllObserver(){
        for(Observer observer:observerList){
            observer.update();
        }
    }
}
