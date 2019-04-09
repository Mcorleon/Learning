package com.tqh.argorithms;

/**
 * @Author Mcorleon
 * @Date 2019/3/23 10:46
 */
public class BigNumberAddition {
    public static void main(String[] args) {
        String num1 = "34534586748657834758347582345";
        String num2 = "56464564534534534534534534";
        String res = stringAdd(num1, num2);
        System.out.println(num1 + "+" + num2 + "=" + res);
    }

    private static String stringAdd(String num1, String num2) {
        if (num1.length() == 0 || num1 == null) {
            if (num2.length() == 0 || num2 == null) {
                return "error";
            }
            return num2;
        }
        if (num2.length() == 0 || num2 == null) {
            return num1;
        }
        int num1_index = num1.length() - 1;
        int num2_index = num2.length() - 1;
        int num1_temp;
        int num2_temp;
        int add_temp;
        int flag = 0;
        String res ="";
        while (num1_index >= 0 && num2_index >= 0) {
            num1_temp = num1.charAt(num1_index)-'0';
            num2_temp = num2.charAt(num2_index)-'0';
            //临时储存每位相加的结果,加上次的进位（0或者1）
            add_temp = num1_temp + num2_temp + flag;
            //分离出该位结果和进位
            res = (add_temp % 10) + res;
            flag = add_temp / 10;
            //继续
            num1_index--;
            num2_index--;
        }
        while (num2_index >= 0) {
            num2_temp =num2.charAt(num2_index)-'0';
            add_temp = num2_temp + flag;
            res = (add_temp % 10) + res;
            flag = add_temp / 10;
            num2_index--;
        }
        while (num1_index >= 0) {
            num1_temp = num1.charAt(num1_index)-'0';
            add_temp = num1_temp + flag;
            res = (add_temp % 10) + res;
            flag = add_temp / 10;
            num1_index--;
        }
        return res;

    }
}
