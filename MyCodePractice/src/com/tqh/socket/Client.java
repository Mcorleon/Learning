package com.tqh.socket;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author Mcorleon
 * @Date 2019/3/29 20:11
 */
public class Client {
    private static ExecutorService CUS_SERVICE= Executors.newFixedThreadPool(10);
    public static void main(String[] args){
        try {
            Socket socket=new Socket("localhost",9999);
            System.out.println("客户端已经启动");
            CUS_SERVICE.execute(new ClientKeyBoardListener(socket));
            CUS_SERVICE.execute(new ClientMessageLisener(socket));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
