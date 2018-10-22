package com.tqh.container;

import java.util.LinkedHashMap;
import java.util.PriorityQueue;
import java.util.Random;

public class Test3 {
    public static void main(String[] args){
        PriorityQueue<AAA> queue=new PriorityQueue<>();
        for (int i = 0; i <10 ; i++) {
            AAA aaa=new AAA();
            queue.add(aaa);
        }

        for (int i = 0; i <10 ; i++) {
            System.out.println(queue.poll().a);
        }

    }
}

class AAA implements Comparable<AAA>{
    Integer a;
    public AAA(){
        Random random=new Random();
        a=random.nextInt(100);
    }



    @Override
    public int compareTo(AAA o) {
        if(this.a>o.a){
            return 1;
        }
        if(this.a.equals(o.a)){
            return 0;
        }
            return -1;

    }
}