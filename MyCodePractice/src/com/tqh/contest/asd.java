package com.tqh.contest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @Author Mcorleon
 * @Date 2019/9/10 20:27
 */
public class asd {
    static int res=0;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        HashMap<Integer,Character> map=new HashMap<>();
        char[] chs=s.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            if(chs[i]=='?'){
                chs[i]="0".charAt(0);
            }else {
                map.put(i,chs[i]);
            }
        }
        int min=Integer.valueOf(new String(chs));
        char[] chs2=s.toCharArray();
        for (int i = 0; i < chs2.length; i++) {
            if(chs2[i]=='?'){
                chs2[i]="9".charAt(0);
            }
        }
        int max=Integer.valueOf(new String(chs2));
        int a=min/13;
        int n=a*13+5;
        while (n>=min&&n<=max){
            n=a*13+5;
            String temp=String.valueOf(n);
            if(temp.length()<s.length()){
                int m=s.length()-temp.length();
                for (int i = 0; i < m; i++) {
                    temp="0"+temp;
                }
            }
            boolean flag=true;
            for (int i = 0; i <temp.length() ; i++) {
                if(map.containsKey(i)){
                    if(map.get(i)!=temp.charAt(i)){
                        flag=false;
                        break;
                    }
                }
            }
            if(flag){
                    res++;
            }
            a++;


        }
        System.out.println(res%1000000007);
    }


}
