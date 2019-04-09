package com.tqh.contest;

import java.util.Scanner;

/**
 * @Author Mcorleon
 * @Date 2019/4/1 20:22
 */
public class Main1 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String N_to_M=sc.nextLine();
            String one=sc.nextLine();
            String two=sc.nextLine();
            StringBuffer M_to_N=new StringBuffer(N_to_M).reverse();
            boolean nm=helper(one+two,N_to_M);
            boolean mn=helper(one+two,M_to_N.toString());
            if(nm&&!mn){
                System.out.println("forward");
            }
            if(!nm&&mn){
                System.out.println("backward");
            }
            if(nm&&mn){
                System.out.println("both");
            }
            if(!nm&&!mn){
                System.out.println("invalid");
            }
        }
    }

    static boolean helper(String temp,String s){
        for (int i = 0,j=0; i <temp.length() ; i++) {
            char c=temp.charAt(i);
            for (; j <s.length() ; j++) {
                if(s.charAt(j)==c){
                    break;
                }
            }
            if(j>=s.length()){
                return false;
            }
        }
        return true;
    }
}
