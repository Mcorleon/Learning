package com.tqh.work;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashMap;

public class Test {
    static volatile int num=0;
    public static void main(String[] args) {
        new Thread(new Add()
        ).start();
        new Thread(new Add()
        ).start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(num);
    }


}

class Add implements Runnable{

    @Override
    public void run() {
        for(int i=0;i<500;i++){
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Test.num++;
        }
    }
}