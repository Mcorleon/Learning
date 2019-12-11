package com.tqh.contest;

import java.util.Scanner;

/**
 * @Author Mcorleon
 * @Date 2019/9/15 22:13
 */
public class dfs {
    static  int count=0;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        char[] chars=s.toCharArray();
        int Q=0;
        for(char i:chars){
            if(i=='?'){
                Q++;
            }
        }
        DFS(chars,Q);
        System.out.println(count);
    }

    private static void DFS(char[] chars, int q) {
        if(q==0){
            if(getresult(chars)%13==5){
                count++;
            }
            return;
        }
        for (int i = 0; i <chars.length ; i++) {
            if(chars[i]=='?'){
                int P=q-1;
                for (int j = 0; j <=9 ; j++) {
                    chars[i]=(char) (j+'0');
                    char[] chars1=new char[chars.length];
                    for (int k = 0; k <chars.length ; k++) {
                        chars1[k]=chars[k];
                    }
                    DFS(chars1,P);
                }
            }
        }
    }

    private static int getresult(char[] chars) {
        int result=0;
        int i=0;
        while (chars[i]=='0'){
            i++;
        }
        for (int j = i; j <chars.length ; j++) {
            result=result*10+(chars[j]-'0');
        }
        return result;
    }
}
