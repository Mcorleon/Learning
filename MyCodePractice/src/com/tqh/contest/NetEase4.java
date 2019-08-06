package com.tqh.contest;

import java.text.DecimalFormat;
import java.util.*;

/**
 * @Author Mcorleon
 * @Date 2019/8/3 14:40
 */
public class NetEase4 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int q= sc.nextInt();
        LinkedHashMap<Integer,Integer> map=new LinkedHashMap<>();
        for (int i = 0; i <n ; i++) {
            int val=sc.nextInt();
            if(map.containsKey(val)){
                map.put(val,map.get(val)+1);
            }else {
                map.put(val,1);
            }
        }
        for (int i = 0; i <q ; i++) {
            int k=sc.nextInt();
            helper(map,k);
        }


    }

    private static void helper(LinkedHashMap<Integer, Integer> map, int k) {
        ArrayList<Integer> list=new ArrayList<>();
        for(int n:map.keySet()){
            if(n>=k){
                list.add(n);
            }
        }
        int count=0;
        for(int n:list){
            int m=map.get(n);
            count+=m;
            map.remove(n);
            if(map.containsKey(n-1)){
                map.put(n-1,map.get(n-1)+m);
            }else {
                map.put(n-1,m);

            }
        }
        System.out.println(count);
    }


}
