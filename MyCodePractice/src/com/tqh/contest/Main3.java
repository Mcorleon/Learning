package com.tqh.contest;

import java.util.Scanner;

/**
 * @Author Mcorleon
 * @Date 2019/4/2 10:30
 */
public class Main3 {
    public static void main() {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int count = 0;
        char last = '*';
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != last) {
                count++;
                last = c;
            } else {
                if (count > max) {
                    max = count;
                }
                last = c;
                count = 1;
            }
        }
        System.out.println(max);
    }

}
