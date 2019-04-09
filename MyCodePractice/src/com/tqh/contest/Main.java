package com.tqh.contest;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        ArrayList<String> list=new ArrayList<>();
        while (sc.hasNext()){
            list.add(sc.next());
            if(list.size()==3){
                StringBuilder line1=new StringBuilder(list.get(0));
                String line3=list.get(2);
                if(line1.reverse().toString().equals(line3)){
                    System.out.println("YES");
                }else {
                    System.out.println("NO");
                }
                list.clear();
            }
        }
    }
}
