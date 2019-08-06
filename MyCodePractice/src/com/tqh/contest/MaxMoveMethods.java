package com.tqh.contest;

/**
 * @Author Mcorleon
 * @Date 2019/7/14 9:20
 */

public class MaxMoveMethods {
    private int n;

    public MaxMoveMethods(int n) {
        this.n = n;
    }

    public int getMaxMoveMethods() {
        if (n < 0)
            return 0;
        else if (n == 0)
            return 1;
        else {
            return dfs(0, 0);
        }
    }

    private int dfs(int depth, int pos) {
        int sum = 0;
        if (depth > n)
            return 0;
        if ((n - depth) < getMinDistance(pos))
            return 0;
        if (n == depth && pos == 0)
            return 1;
        //否则递归到下一层
        //顺时针
        sum += dfs(depth + 1, pos == 9 ? 0 : pos + 1);
        //逆时针
        sum += dfs(depth + 1, pos == 0 ? 9 : pos - 1);

        return sum;
    }

    private int getMinDistance(int pos) {
        if (pos <= 5)
            return pos;
        else
            return 10 - pos;
    }

    public static void main(String[] args) {
        MaxMoveMethods maxMoveMethods = new MaxMoveMethods(100);

        int ret = maxMoveMethods.getMaxMoveMethods();
        System.out.println(ret);

    }

}