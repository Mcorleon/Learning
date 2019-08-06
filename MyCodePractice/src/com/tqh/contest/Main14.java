package com.tqh.contest;

/**
 * @Author Mcorleon
 * @Date 2019/8/5 13:11
 */
public class Main14 {

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        System.out.println(exist(board, word));

    }

    public static boolean exist(char[][] board, String word) {
        char[] target = word.toCharArray();
        boolean[][] vis = new boolean[board.length][board[0].length];
        boolean flag = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == target[0]) {
                    flag = helper(board, vis, i, j, target, 0);
                    if (flag) {
                        return true;
                    }
                }
            }
        }
        return flag;

    }

    public static   boolean helper(char[][] board, boolean[][] vis, int i, int j, char[] target, int index) {
        if (index == target.length) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }
        boolean flag = false;
        if (!vis[i][j] && board[i][j] == target[index]) {
            System.out.println(board[i][j]);

            vis[i][j] = true;
            flag = helper(board, vis, i, j + 1, target, index + 1) || helper(board, vis, i + 1, j, target, index + 1)
                    || helper(board, vis, i - 1, j, target, index + 1) || helper(board, vis, i, j - 1, target, index + 1);
            vis[i][j] = false;

        }
        return flag;
    }

}
