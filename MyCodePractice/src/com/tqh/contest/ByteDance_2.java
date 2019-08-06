package com.tqh.contest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @Author Mcorleon
 * @Date 2019/7/17 18:48
 */
public class ByteDance_2 {
    static int res=0;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[] height=new int[n];
        for (int i = 0; i <n ; i++) {
            height[i]=sc.nextInt();
        }
        int[] flag=new int[n];
        //固定0是起点
        DFS(height,0,1,m,flag);
        System.out.println(res);

    }

    private static void DFS(int[] height, int cur,int k, int m,int[] flag) {
        if(k==height.length){

            if(Math.abs(height[cur]-height[0])<=m){
                res++;
            }
            return;
        }
        for (int i = 0; i <height.length ; i++) {
            if(flag[i]==0&&Math.abs(height[cur]-height[i])<=m){
                flag[i]=1;
                DFS(height,i,k+1,m,flag);
                flag[i]=0;
            }
        }
    }
}


