package com.tqh.contest;

import java.util.Scanner;

/**
 * @Author Mcorleon
 * @Date 2019/8/6 19:20
 */
public class DFCF2 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] prices=new int[n];
        for (int i = 0; i <n ; i++) {
            prices[i]=sc.nextInt();
        }
        int buy1=Integer.MIN_VALUE;
        int sell1=0;
        int buy2=Integer.MIN_VALUE;
        int sell2=0;
        for (int price:prices){
            buy1=Math.max(buy1,0-price);
            sell1=Math.max(sell1,price+buy1);
            buy2=Math.max(buy2,sell1-price);
            sell2=Math.max(sell2,price+buy2);
        }
        System.out.println(sell2);

    }
}
