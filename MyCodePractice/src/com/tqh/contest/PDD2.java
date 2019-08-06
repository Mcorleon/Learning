package com.tqh.contest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @Author Mcorleon
 * @Date 2019/7/28 15:18
 */
public class PDD2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s= sc.nextLine();
        String[] ss=s.split(" ");
        int A[]=new int[ss.length];
        int i=0;
        for(String num:ss){
            A[i++]=Integer.valueOf(num);
        }
        s= sc.nextLine();
        ss=s.split(" ");
        int B[]=new int[ss.length];
        int j=0;
        for(String num:ss){
            B[j++]=Integer.valueOf(num);
        }
        int index=0;
        for (int k=0;k<A.length-1;k++){
            if(A[k]>=A[k+1]){
                index=k;
                break;
            }
        }
        Arrays.sort(B);
        for (int k = B.length-1; k >=0 ; k--) {
            int val=B[k];
            int l=Integer.MIN_VALUE;
            if(index!=0){
                l=index-1;
            }
            if(l<val&&val<A[index+1]){
                A[index]=val;
                for (int m = 0; m <A.length ; m++) {
                    System.out.print(A[m]+" ");
                }
                return;
            }
            int r=Integer.MAX_VALUE;
            if(index+1!=A.length-1){
                r=index+2;
            }
            if(A[index]<val&&val<A[r]){
                A[index+1]=val;
                for (int m = 0; m <A.length ; m++) {
                    System.out.print(A[m]+" ");
                }
                return;
            }

        }
        System.out.println("NO");
        HashMap map=new HashMap();
    }
}
