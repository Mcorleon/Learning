package com.tqh.contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author Mcorleon
 * @Date 2019/4/3 19:57
 * 第一行包含两个整数N和M，1≤N，M≤105。
 * 第二行包含N个空格隔开的整数A1到AN，1≤Ai≤109。
 * 接下来M行，每行包含两个整数t和x，0≤t≤1，1≤x≤N。若t=0，则表示对A1到Ax进行升序排列；若t=1，则表示对A1到Ax进行降序排列。操作执行顺序与输入顺序一致。
 */
public class Main6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<int[]> oper = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            arr.add(sc.nextInt());
        }
        for (int i = 0; i < M; i++) {
            int[] temp = new int[2];
            temp[0] = sc.nextInt();
            temp[1] = sc.nextInt();
            oper.add(temp);
        }

        for (int i = 0; i < oper.size(); i++) {
            int[] operation = oper.get(i);
            int x = operation[1];
            int[] a = new int[x];

            for (int j = 0; j < x; j++) {
                a[j] = arr.get(j);
            }
            Arrays.sort(a);

            if (operation[0] == 0) {
                //升序
                for (int j = 0; j < x; j++) {
                    arr.set(j, a[j]);
                }
            } else if (operation[0] == 1) {
                //降序
                for (int j = 0; j < x; j++) {
                    arr.set(j, a[x - 1 - j]);
                }
            }
        }
        for (int i = 0; i < arr.size(); i++) {
            if (i == arr.size() - 1) {
                System.out.print(arr.get(i));
            } else {
                System.out.print(arr.get(i) + " ");
            }
        }
    }
}
