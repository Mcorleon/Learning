package com.tqh.contest;

import java.util.Scanner;

/**
 * @Author Mcorleon
 * @Date 2019/4/3 15:10
 * 分金子问题 动态规划
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int n;
        int[] gold, sum;
        int[][] dp;
        for (int i = 1; i <= t; i++) {
            n = scanner.nextInt();
            gold = new int[n + 1];
            sum = new int[n + 1];
            //sum[n]是从0到第n座矿的累计收益
            sum[0] = 0;
            //dp[l·[r]表示挖l到r段金子的最优决策
            dp = new int[n + 1][n + 1];
            for (int j = 1; j <= n; j++) {
                gold[j] = scanner.nextInt();
                dp[j][j] = gold[j];
                sum[j] = sum[j - 1] + gold[j];
            }

            for (int j = n - 1; j >= 1; j--) {
                for (int k = j + 1; k <= n; k++) {
                    dp[j][k] = sum[k] - sum[j - 1] - Math.min(dp[j + 1][k], dp[j][k - 1]);
                }
            }
            System.out.printf("Case #%d: %d %d\n", i, dp[1][n], sum[n] - dp[1][n]);
        }
    }

}
