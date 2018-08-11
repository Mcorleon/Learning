package com.tqh.memento;

public class Test {
    public static void main(String[] args){
        Originator originator=new Originator();
        CareTaker careTaker=new CareTaker();
        originator.setState("HP:100,MPl:100");
        careTaker.add(originator.saveStateToMemento());
        originator.setState("HP:93,MPl:87");
        careTaker.add(originator.saveStateToMemento());
        originator.setState("HP:23,MPl:57");
        careTaker.add(originator.saveStateToMemento());
        System.out.println("now:"+originator.getState());
        originator.getStateFromMemento(careTaker.get(1));
        System.out.println("roll back once:"+originator.getState());
        originator.getStateFromMemento(careTaker.get(0));
        System.out.println("roll back again:"+originator.getState());
    }
}
