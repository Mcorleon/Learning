package com.tqh.contest;

import java.util.Scanner;

/**
 * @Author Mcorleon
 * @Date 2019/4/10 19:21
 */
public class Main8 {
    public static int count=0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt();
        int M= sc.nextInt();
        int[][] arr=new int[N][M];
        for (int i = 0; i <N ; i++) {
            for (int j = 0; j <M ; j++) {
                arr[i][j]=sc.nextInt();
            }
        }
        int x=sc.nextInt();
        int y=sc.nextInt();
        int z=sc.nextInt();
        int w=sc.nextInt();

        findPath(x,y,z,w,N,M,arr);
        System.out.println(count);


    }

    private static void findPath(int x, int y, int z, int w,int N,int M,int[][] arr) {
        if(x==z&&y==w){
            count++;
            return;
        }
        int val=arr[x][y];

        if(y>0&&arr[x][y-1]>val){
            findPath(x,y-1,z,w,N,M,arr);
        }
        if(y<M-1&&arr[x][y+1]>val){
            findPath(x,y+1,z,w,N,M,arr);
        }
        if(x>0&&arr[x-1][y]>val){
            findPath(x-1,y,z,w,N,M,arr);
        }
        if(x<N-1&&arr[x+1][y]>val){
            findPath(x+1,y,z,w,N,M,arr);
        }
    }
}
