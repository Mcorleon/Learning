package com.tqh.thinkinginjava;

import java.lang.reflect.Array;
import java.util.*;

public class GenerateMovie {
    public static  void main(String[] args){
        Generator generator=new Generator();
//        String[] string=new String[]{generator.next(),generator.next(),generator.next(),generator.next()};
//        System.out.println(Arrays.toString(string));
//        ArrayList arrayList=new ArrayList();
//        for(int i=0;i<4;i++){
//            arrayList.add(generator.next());
//        }
//        System.out.println(arrayList);
//        LinkedList linkedList=new LinkedList();
//        for(int i=0;i<4;i++){
//            linkedList.add(generator.next());
//        }
//        System.out.println(linkedList);
//        HashSet hashSet=new HashSet();
//        for(int i=0;i<4;i++){
//            hashSet.add(generator.next());
//        }
//        System.out.println(hashSet);
//        LinkedHashSet linkedHashSet=new LinkedHashSet();
//        for(int i=0;i<4;i++){
//            linkedHashSet.add(generator.next());
//        }
//        System.out.println(linkedHashSet);
        TreeSet treeSet=new TreeSet();
        for(int i=0;i<4;i++){
           treeSet.add(generator.next());
        }
        Iterator iterator=treeSet.iterator();
        while (iterator.hasNext())
        System.out.println(iterator.next());
    }
}
class Generator{
    static int count=0;
    public String next(){
        count++;
        String[] movies=new String[]{"fighter club","inception","BladeRunner","GodFather"};
        if(count>movies.length)
            count=1;
        return movies[count-1];

    }
}