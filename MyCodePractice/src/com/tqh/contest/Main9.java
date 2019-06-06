package com.tqh.contest;

import java.util.Scanner;

/**
 * @Author Mcorleon
 * @Date 2019/4/10 19:48
 */
public class Main9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c - '0' > 9 || c - '0' < 0) {
                //非数字
                sb.append(c);
            } else {
                //数字
                int num = c - '0';
                String content = helper(num, s, i);
                for (int j = 0; j <num; j++) {
                    sb.append(content);
                }
            }
        }
        System.out.println(sb.reverse().toString());
    }

    private static String helper(int num, String s, int i) {
        //返回（）里的内容
        String temp = null;
        for (int j = i + 2; j < s.length(); j++) {
            char c = s.charAt(j);
            if (c - '0' > 9 || c - '0' < 0) {
                if (c == '(') {
                    continue;

                } else if (c == ')') {
                    //括号结束了
                    break;

                } else {
                    temp+=c;
                }
            } else {
                //数字
                int num1 = c - '0';

                String content = helper(num1, s, j);
                for (int k = 0; k <num1; k++) {
                    temp+=content;
                }
            }
        }
        return temp;
    }
}
