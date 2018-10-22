package com.tqh.argorithms;


import java.util.ArrayList;
import java.util.List;

public class EightQueen {
    public static void main(String[] args) {
        MyAnser myAnser=new MyAnser();
        myAnser.anser(0);
        System.out.println(myAnser.count);
    }

}

class MyAnser {

    List<Queen> queenList = new ArrayList<Queen>();

    public void Solution() {
        int count = 0;
        //第一行
        for (int i = 0; i < 8; i++) {
            Queen queen1 = new Queen(i, 0);
            if (queenList.size() == 1) {
                queenList.remove(0);
            }
            queenList.add(queen1);
            //第二行
            for (int j = 0; j < 8; j++) {
                Queen queen2 = new Queen(j, 1);
                if (queenList.size() == 2) {
                    queenList.remove(1);
                }
                if (!queen2.checkAttacked(queenList)) {
                    queenList.add(queen2);
                } else {
                    if (j == 7) {
                        queenList.remove(0);
                    }
                    continue;
                }
                //第三行
                for (int k = 0; k < 8; k++) {
                    Queen queen3 = new Queen(k, 2);
                    if (queenList.size() == 3) {
                        queenList.remove(2);
                    }
                    if (!queen3.checkAttacked(queenList)) {
                        queenList.add(queen3);
                    } else {
                        if (k == 7) {
                            queenList.remove(1);
                        }
                        continue;
                    }
                    //第四行
                    for (int l = 0; l < 8; l++) {
                        Queen queen4 = new Queen(l, 3);
                        if (queenList.size() == 4) {
                            queenList.remove(3);
                        }
                        if (!queen4.checkAttacked(queenList)) {
                            queenList.add(queen4);
                        } else {
                            if (l == 7) {
                                queenList.remove(2);
                            }
                            continue;
                        }
                        //第五行
                        for (int m = 0; m < 8; m++) {
                            Queen queen5 = new Queen(m, 4);
                            if (queenList.size() == 5) {
                                queenList.remove(4);
                            }
                            if (!queen5.checkAttacked(queenList)) {
                                queenList.add(queen5);
                            } else {
                                if (m == 7) {
                                    queenList.remove(3);
                                }
                                continue;
                            }
                            //第六行
                            for (int n = 0; n < 8; n++) {
                                Queen queen6 = new Queen(n, 5);
                                if (queenList.size() == 6) {
                                    queenList.remove(5);
                                }
                                if (!queen6.checkAttacked(queenList)) {
                                    queenList.add(queen6);
                                } else {
                                    if (n == 7) {
                                        queenList.remove(4);
                                    }
                                    continue;
                                }
                                //第七行
                                for (int o = 0; o < 8; o++) {
                                    Queen queen7 = new Queen(o, 6);
                                    if (queenList.size() == 7) {
                                        queenList.remove(6);
                                    }
                                    if (!queen7.checkAttacked(queenList)) {
                                        queenList.add(queen7);
                                    } else {
                                        if (o == 7) {
                                            queenList.remove(5);
                                        }
                                        continue;
                                    }
                                    //第八行
                                    for (int p = 0; p < 8; p++) {
                                        Queen queen8 = new Queen(p, 7);
                                        if (!queen8.checkAttacked(queenList)) {
                                            count++;
                                        } else {
                                            if (p == 7) {
                                                queenList.remove(6);
                                            }
                                            continue;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println("八皇后问题的解法有" + count + "种^_^");
    }

    public int count=0;
    public int[][] chess=new int[8][8];
    public void anser(int level) {
        if(level>7){
            //解
            count++;
            return;
        }
        for(int m=0;m<8;m++){
            if(checkAttacked(chess,level,m)){
                chess[level][m]=1;
                anser(level+1);
                chess[level][m]=0;
            }
        }

    }
    public boolean checkAttacked(int[][] array,int k,int j){
        //行列冲突
        for (int i = 0; i < 8; i++) {
            if(array[i][j]==1){
                return false;
            }
        }
        //左对角
        for (int i = k-1,m=j-1;i>=0&&m>=0; i--,m--) {
            if(array[i][m]==1){
                return false;
            }
        }
        //右对角
        for (int i = k-1,m=j+1;i>=0&&m<=7; i--,m++) {
            if(array[i][m]==1){
                return false;
            }
        }
        return true;
    }

}

class Queen {
    int x;
    int y;

    public Queen(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * 对已经加入list里的每个queen测试是否能被攻击
     * 返回false则这个位置是安全的，可以添加
     */
    public boolean checkAttacked(List<Queen> queenList) {
        for (int i = 0; i < queenList.size(); i++) {
            Queen queen = queenList.get(i);
            if (this.x == queen.x || (Math.abs(queen.x - this.x) == Math.abs(queen.y - this.y))) {
                return true;
            }
        }
        return false;
    }
}