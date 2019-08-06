package com.tqh.contest;

import java.util.Scanner;

/**
 * @Author Mcorleon
 * @Date 2019/7/27 19:32
 *
 * 长度为n的圆环 从0走k步回0的解数
 */
public class Circle {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        System.out.println(solve(k,n));
    }
    public static int solve(int n,int k){
        if(n==0||n==1){
            return n;
        }
        //走k步回到n的方法数
        int[][] dp=new int[k+1][n];
        for (int i = 0; i <n&&i<=k ; i++) {
            dp[i][i]=1;
        }
        for (int i = 1; i <=k ; i++) {
            for (int j = 0; j <n ; j++) {
                dp[i][j]=dp[i-1][(j-1+n)%n]+dp[i-1][(j+1)%n];
            }
        }
        return dp[k][0];
    }
}
