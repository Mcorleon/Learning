package com.tqh.contest;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Main11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n ;i++){
            int num=sc.nextInt();
            if(!map.containsKey(num)){
                map.put(num,1);
            }else {
                int count=map.get(num);
                map.put(num,count+1);
            }
        }
        Iterator<Integer> iterator=map.keySet().iterator();
        ArrayList<Integer> list=new ArrayList<>();
        int max=-1;
        while (iterator.hasNext()){
            int temp=iterator.next();
            list.add(map.get(temp));
            if(map.get(temp)>max){
                max=map.get(temp);
            }
        }
        int x=-1;
        for (int i = 2; i <=max ; i++) {
            int pass_count=0;
            for (int j = 0; j <list.size() ; j++) {
                if(list.get(j)%i ==0){
                    pass_count++;
                }else {
                    break;
                }
            }
            if(pass_count==list.size()){
                x=i;
                break;
            }
        }
        if(x==-1){
            System.out.println(0);
            return;
        }
        int sum=0;
        for (int i = 0; i <list.size() ; i++) {
            sum+=list.get(i)/x;
        }
        System.out.println(sum);

    }

}
