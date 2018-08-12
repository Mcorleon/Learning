package com.tqh.observer;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Test {
    public static void main(String[] args){
        Subject subject=new Subject();
        new BinaryObserver(subject);
        new HexObserver(subject);
        subject.setState(2);
        subject.setState(43);
        subject.setState(12);

    }
}
