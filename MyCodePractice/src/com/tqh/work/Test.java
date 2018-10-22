package com.tqh.work;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashMap;

public class Test {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String s="I am 君山";
        byte[] bytes=s.getBytes("ISO-8859-1");
        char[] chars=s.toCharArray();
//        for(int i=0;i<bytes.length ;i++){
//
//            System.out.print(Integer.toHexString(bytes[i]));
//        }
        for(int i=0;i<chars.length ;i++){
            System.out.print(Integer.toHexString(chars[i]));
        }

    }


}