package com.tqh.contest;

/**
 * @Author Mcorleon
 * @Date 2019/7/9 13:43
 * 有N件物品和一个容量为V的背包。第i件物品的体积是cost[i]，价值是value[i]。求解将哪些物品装入背包可使价值总和最大
 */
public class BackPack {

    public int solve(int v,int[] cost,int value[]){
        int n=cost.length;
        //dp[n][v]代表背包大小v的情况下，取前n物品能获得的最大收益，
        int[][] dp=new int[n+1][v+1];
        for(int i=1;i<=n;i++){
            for (int j = 1; j <=v ; j++) {
                if(cost[i-1]>j){
                    //背包装不下这个，最大收益等于前i-1件物品的最大收益
                    dp[i][j]=dp[i-1][j];
                }else {
                    //背包装得下，选择取或者不取
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-cost[i-1]]+value[i-1]);
                }
            }
        }
        return dp[n][v];
    }
}
