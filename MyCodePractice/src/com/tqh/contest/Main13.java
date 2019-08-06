package com.tqh.contest;

import java.util.Scanner;

/**
 * @Author Mcorleon
 * @Date 2019/7/7 18:01
 */
public class Main13 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T=sc.nextInt();
        for (int i = 0; i <T ; i++) {
            int n=sc.nextInt();
            int[] gold=new int[n];
            for (int j = 0; j <n ; j++) {
                gold[j]=sc.nextInt();
            }
            cal(gold,n,i+1);
        }
    }

    private static void cal(int[] gold,int n,int k) {
        int[][] dp=new int[n+1][n+1];
        int[] sum=new int[n+1];
        for (int i = 1; i <=n ; i++) {
            dp[i][i]=gold[i-1];
            sum[i]=sum[i-1]+gold[i-1];
        }
        for (int i = n-1; i >0 ; i--) {
            for (int j = i; j <=n ; j++) {
                dp[i][j]=sum[j]-sum[i-1]-Math.min(dp[i+1][j],dp[i][j-1]);
            }
        }
        System.out.println(String.format("Case #%d: %d %d", k, dp[1][n], (sum[n]-dp[1][n])));
    }
}
