package com.tqh.contest;


import sun.misc.Unsafe;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        PriorityQueue<Integer> queue=new PriorityQueue(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        //默认正数
        boolean flag = true;
        //最后返回的有效数字
        String res = "";
        if (s.length() == 1) {
            char c = s.charAt(0);
            if (c - '0' >= 0 && c - '0' <= 9) {
                //是数字
                System.out.println(c - '0');
                return;
            }
        }
        //长度大于1
        int start = 0;
        if (s.charAt(0) == '-' || s.charAt(0) == '+') {
            if (s.charAt(0) == '-') {
                flag = false;
            }
            start = 1;
        }
        //找第一个不是0的位置
        int begin = s.length();
        for (int i = start; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != '0') {
                begin = i;
                break;
            }
        }
        boolean point = false;
        for (int i = begin; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '.' && point == false) {
                point = true;
                continue;
            }
            if (c - '0' >= 0 && c - '9' <= 0) {
                //是数字
                if (point == false) {
                    res += c;
                }
            } else {
                System.out.println(0);
                return;
            }
        }
        if (res.length() == 0) {
            System.out.println(0);
            return;
        }
        if (!flag) {
            System.out.println("-" + res);
        } else {
            System.out.println(res);
        }
    }

}
