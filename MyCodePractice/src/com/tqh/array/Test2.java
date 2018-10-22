package com.tqh.array;

import java.util.Arrays;
import java.util.List;

/**
 * @author Tang
 */
public class Test2 {
    public static void main(String[] args){
        int[] a=new int[10];
        Arrays.fill(a,1);
        List list=Arrays.asList(a);
        for (int i = 0; i <a.length ; i++) {

            System.out.println(a[i]);
        }
    }
}
