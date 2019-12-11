    package com.tqh.contest;

    import java.util.*;

    /**
     * @Author Mcorleon
     * @Date 2019/8/10 16:53
     */
    public class dianxin {

        public static void main(String[] args){
            Scanner sc=new Scanner(System.in);
            int n=sc.nextInt();
            int[] num={1000,900,500,400,100,90,50,40,10,9,5,4,1};
            String[] romans={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
            StringBuilder sb=new StringBuilder();
            int index=0;
            while (index<13){
                while (n>=num[index]){
                    sb.append(romans[index]);
                    n-=num[index];
                }
                index++;
            }
            System.out.println(sb.toString());

        }


    }
