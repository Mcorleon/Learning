package com.tqh.contest;

import java.util.Scanner;

/**
 * @Author Mcorleon
 * @Date 2019/8/6 19:20
 */
public class DFCF1 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        String[] ss=s.split(" ");
        boolean res=helper(ss[0],ss[1],ss[2]);
        if(res){

            System.out.println("TRUE");
        }else {
            System.out.println("FALSE");
        }


    }

    public static boolean helper(String a,String b,String c){
        if (c.length()==0){
            return true;
        }
        boolean flag=false;
        for (int i = 0; i <c.length() ; i++) {
            char ch=c.charAt(i);
            if(!a.isEmpty()&&ch==a.charAt(0)){
                flag=helper(a.substring(1),b,c.substring(1));
                if (flag){
                    break;
                }
            }
            if(!b.isEmpty()&&ch==b.charAt(0)){
                flag=helper(a,b.substring(1),c.substring(1));
                if (flag){
                    break;
                }
            }
        }
        return flag;
    }
}
