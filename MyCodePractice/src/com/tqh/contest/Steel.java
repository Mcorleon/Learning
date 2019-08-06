package com.tqh.contest;

/**
 * @Author Mcorleon
 * @Date 2019/7/11 21:19
 */
public class Steel {
    public int cut_steel(int price[], int n) {
        int[] dp = new int[n + 1];
        for (int j = 1; j <= n; j++) {
            int temp=-1;
            for (int i = 1; i <=j; i++) {
                temp=Math.max(temp,dp[j-i]+price[i]);
            }
            dp[j]=temp;
        }
        return dp[n];
    }
}
