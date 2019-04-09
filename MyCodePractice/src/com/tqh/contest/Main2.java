package com.tqh.contest;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Author Mcorleon
 * @Date 2019/4/1 21:04
 */
public class Main2 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int M=sc.nextInt();
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<N ;i++){
            //任务列表
            list.add(sc.nextInt());
        }
        for(int i=0;i<M ;i++){
            //临时任务
            int temp=sc.nextInt();
            int last=list.get(list.size()-1);
            int time=last+1;
            if(temp>last){
                System.out.println(temp);
            }else {
                for (int j = 0; j < list.size()-1; j++) {
                    if(list.get(j+1)-list.get(j)>1){
                        if(temp<=list.get(j)){
                            time=list.get(j)+1;
                            break;
                        }else if(temp>list.get(j)&&temp<list.get(j+1)){
                            time=temp;
                            break;
                        }
                    }
                }
                System.out.println(time);
            }

        }
    }
}
