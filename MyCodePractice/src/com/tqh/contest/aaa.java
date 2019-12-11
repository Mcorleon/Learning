package com.tqh.contest;

import java.util.Scanner;

/**
 * @Author Mcorleon
 * @Date 2019/9/15 21:14
 */
public class aaa {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        char[] chars=s.toCharArray();
        int[] ints=new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            if(chars[i]=='R'){
                int count=0;
                int j=i;
                while (chars[j]=='R'){
                    j++;
                    count++;
                }
                if(count%2==0){
                    ints[j]++;
                }else {
                    ints[j-1]++;
                }
            }
            if(chars[i]=='L'){
                int count=0;
                int j=i;
                while (chars[j]=='L'){
                    j--;
                    count++;
                }
                if(count%2==0){
                    ints[j]++;
                }else {
                    ints[j+1]++;
                }
            }
        }
        for(int i:ints){
            System.out.print(i+" ");
        }
    }
}
