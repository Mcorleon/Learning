package com.tqh.contest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @Author Mcorleon
 * @Date 2019/4/10 19:21
 */
public class PDD1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s= sc.nextLine();
        String[] ss=s.split(" ");
        HashMap<Character,Integer> map=new HashMap<>();
        for (int i = 0; i <ss.length ; i++) {
            String temp=ss[i];
            char start=temp.charAt(0);
            char end=temp.charAt(temp.length()-1);
            if(map.containsKey(start)){
                int count=map.get(start);
                map.put(start,count+1);
            }else {
                map.put(start,1);
            }
            if(map.containsKey(end)){
                int count=map.get(end);
                map.put(end,count+1);
            }else {
                map.put(end,1);
            }
        }
        for(char c:map.keySet()){
            if(map.get(c)%2!=0){
                System.out.println(false);
                return;
            }
        }
        System.out.println(true);

    }


}
