package com.tqh.contest;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Author Mcorleon
 * @Date 2019/4/10 20:44
 */
public class Main10 {
    private static String solution(String s) {
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer temp = new StringBuffer();
        Stack<Character> stack = new Stack<>();
        char a = ' ';
        int length = s.length();
        int i = length - 1;
        int right = 0;
        while (i >= 0) {
            a = s.charAt(i);
            if (a == ')') {
                stack.push(a);
                right++;
            } else if (a == '(') {
                right--;
//                while (stack.peek() != ')') {
//                    char c = stack.pop();
//                    temp.append(c);
//                }
                stack.pop();
                if (stringBuffer.length() > 0) {
                    temp = new StringBuffer(stringBuffer.append(temp));
                    stringBuffer.setLength(0);
                }
//            } else if (right > 0) {
//                stack.push(a);
            } else {
                stringBuffer.append(a);
            }
            i--;
            if (temp.length() > 0) {
                int n = Integer.valueOf(String.valueOf(s.charAt(i)));
                for (int j = 0; j < n; j++) {
                    stringBuffer.append(temp);
                }
                i--;
            }
            temp.setLength(0);
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(solution(s));
    }
}
