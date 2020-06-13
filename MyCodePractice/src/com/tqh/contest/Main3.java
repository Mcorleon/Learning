package com.tqh.contest;

import java.util.Scanner;

/**
 * @Author Mcorleon
 * @Date 2019/4/2 10:30
 */
public class Main3 {
    public static void main(String[] args) {
      myAtoi("-2147483649");
    }

    public static int myAtoi(String str) {
        int start=0;
        boolean flag=true;
        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);
            if(c==' '){
                continue;
            }else if(c=='+'){
                start=i+1;
                break;
            }else if(c=='-'){
                start=i+1;
                flag=false;
                break;
            }
            if(c-'0'>=0&&c-'0'<=9){
                start=i;
                break;
            }else{
                return 0;
            }
        }
        int ans=0;
        if(flag){
            for(int i=start;i<str.length();i++){
                char c=str.charAt(i);
                int val=c-'0';
                if(val<0||val>9){
                    break;
                }
                if(ans>Integer.MAX_VALUE/10||(ans==Integer.MAX_VALUE/10&&val>Integer.MAX_VALUE%10)){
                    return Integer.MAX_VALUE;
                }
                ans=10*ans+val;
            }
        }else{
            for(int i=start;i<str.length();i++){
                char c=str.charAt(i);
                int val=c-'0';
                if(val<0||val>9){
                    break;
                }
                if(ans<Integer.MIN_VALUE/10||(ans==Integer.MIN_VALUE/10&&val>Integer.MIN_VALUE%10)){
                    return Integer.MIN_VALUE;
                }
                ans=10*ans-val;
            }
        }
        return ans;
    }

}
