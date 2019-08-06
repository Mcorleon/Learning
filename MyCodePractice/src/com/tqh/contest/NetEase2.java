package com.tqh.contest;

import java.util.Scanner;

/**
 * @Author Mcorleon
 * @Date 2019/8/3 14:40
 */
public class NetEase2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int k = sc.nextInt();
            long[] num = new long[k];
            for (int j = 0; j < k; j++) {
                num[j] = sc.nextLong();
            }
            boolean flag = true;
            for (int j = 0; j < k; j++) {
                if (num[j] < (num[(j - 1 + k) % k] + num[(j + 1 + k) % k])) {
                    flag=true;
                }else {
                    flag=false;
                }
            }
            if(flag){
                System.out.println("YES");
            }else {

                System.out.println("NO");
            }
        }

    }

}
