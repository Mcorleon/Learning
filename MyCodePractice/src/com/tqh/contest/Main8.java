package com.tqh.contest;

import java.util.Scanner;

/**
 * @Author Mcorleon
 * @Date 2019/4/10 19:21
 */
public class Main8 {
    public static int count=0;
    public static void main(String[] args) {
        String s="-1(3,2(0,-1))";


    }

    private static TreeNode helper( String s) {
        int val=0;
        TreeNode node=null;
        if(s.charAt(0)=='-'){
            val=-(s.charAt(1)-'0');
            node=new TreeNode(val);
            if(s.length()==2||s.charAt(2)!='('){
                return node;
            }
            if(s.charAt(2)=='('){

            }
        }else {
            val=s.charAt(0)-'0';
        }
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}