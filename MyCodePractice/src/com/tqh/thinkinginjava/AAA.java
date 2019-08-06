package com.tqh.thinkinginjava;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class AAA {
    public static void main(String[] args){
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>(5);
        priorityQueue.add(1);
        priorityQueue.add(2);
        priorityQueue.add(3);
        priorityQueue.add(4);
        priorityQueue.add(5);
        priorityQueue.add(6);
       for(int i=0;i<5 ;i++){
            priorityQueue.poll();
       }
    }

}