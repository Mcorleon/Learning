package com.tqh.contest;
import java.util.Scanner;

/**
 * 最近一款吃鸡类型的游戏火爆全球。在组队模式下，你可以邀请自己的好友组建自己的小队，并选择是否填充（是否同意和非好友游玩），
 * 然后加入游戏。现在有A个单人队伍，B个双人队伍，C个三人队伍，D个四人队伍，并且全都同意填充，请问最多能组成多少个四人队伍。

 输入
 第一行一个正整数T，表示数据组数。（1≤T≤100）

 接下来T行，每行四个非负整数，A，B，C，D。（0≤A, B, C, D≤150）
 */
public class Main5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        for (int i = 0; i <n ; i++) {
            int A=sc.nextInt();
            int B=sc.nextInt();
            int C=sc.nextInt();
            int D=sc.nextInt();
            int res=D;
            int B_temp=B;
            int A_temp=A;
            for (int j = 0; j <C ; j++) {
                if(A>0){
                    A--;
                    res++;
                }
            }
            for (int j = 0; j <B ; j++) {
                if(A>1){
                    A-=2;
                    B--;
                    res++;
                    continue;
                }
                if(B>1){
                    B-=2;
                    res++;
                }
            }
            for (int j = 0; j <A ; j++) {
                if(A>3) {
                    A -= 4;
                    res++;
                }
            }
            System.out.println(res);
        }
    }
}
