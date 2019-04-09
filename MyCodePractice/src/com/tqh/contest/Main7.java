package com.tqh.contest;

import java.util.Scanner;

/**
 * @Author Mcorleon
 * @Date 2019/4/3 20:31
 * 给定一个1到N的排列A1到AN，每次可以将排列的第一个数移到排列的末尾，假设经过若干次移动后得到排列B1到BN，
 * 那么|B1-1|+|B2-2|+|B3-3|+...+|BN-N|的最小值是多少？

样例解释

经过两次移动后得到排列{1 5 2 4 3}，此时|B1-1|+|B2-2|+|B3-3|+|B4-4|+|B5-5|取得最小值。

输入
第一行包含一个整数N，1≤N≤105。

第二行包含N个空格隔开的整数A1到AN。
 */
public class Main7 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        //n次移动的最优解
        int[] dp=new int[n+1];
        int temp_min=0;
        for (int i = 0; i <n ; i++) {
            arr[i]=sc.nextInt();
        }
        for (int i = 0; i <arr.length ; i++) {
            temp_min+=Math.abs(arr[i]-i-1);
        }
        dp[0]=temp_min;
        for (int i = 1; i <=n ; i++) {
            int[] temp=new int[n];

            for (int j = 0; j <n-1 ; j++) {
                temp[j]=arr[j+1];
            }
            temp[n-1]=arr[0];
            temp_min=0;
            for (int j = 0; j <temp.length ; j++) {
                temp_min+=Math.abs(temp[j]-j-1);
            }
            arr=temp;
            dp[i]=Math.min(dp[i-1],temp_min);
        }
        int res=Integer.MAX_VALUE;
        for(int i=0;i<dp.length ;i++){
            if(dp[i]<res){
                res=dp[i];
            }
        }
        System.out.println(res);
    }


}
