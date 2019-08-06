package com.tqh.contest;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author Mcorleon
 * @Date 2019/7/28 15:18
 */
public class PDD3 {
    static int max=0;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt();
        int[] L=new int[N];
        int[] W=new int[N];
        for (int i = 0; i <N ; i++) {
            L[i]=sc.nextInt();
        }
        for (int i = 0; i <N ; i++) {
            W[i]=sc.nextInt();
        }
        helper(L,W,0,1,0);
        System.out.println(max);


    }

    private static void helper(int[] L, int[] W, int k, int height,int weight) {
        if(weight>7*W[k]||k==L.length-1){
            max=Math.max(max,height);
            return;
        }
        weight+=W[k];
        for(int i=k+1;i<L.length;i++){
            helper(L,W,i,height+1,weight);
        }

    }
}
