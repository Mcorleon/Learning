package com.tqh.contest;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.SimpleFormatter;

/**
 * @Author Mcorleon
 * @Date 2019/8/3 14:40
 */
public class NetEase1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int[] score=new int[n];
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i <n ; i++) {
            int val=sc.nextInt();
            score[i]=val;
            map.put(i+1,val);
        }
        int q=sc.nextInt();
        Arrays.sort(score);
        for (int i = 0; i <q ; i++) {
            int target=map.get(sc.nextInt());
            cal(score,target);
        }
    }

    private static void cal(int[] score, int target) {
        double count=0;
        for (int i = 0; i <score.length ; i++) {
            if(score[i]<=target){
                count++;
            }else {
                break;
            }
        }
        DecimalFormat df = new DecimalFormat("##0.000000");
        double p=(count-1)/(double) score.length*100.0;
        System.out.println(df.format(p));

    }
}
