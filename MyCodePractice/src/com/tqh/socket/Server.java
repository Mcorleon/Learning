package com.tqh.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author Mcorleon
 * @Date 2019/3/29 20:20
 */
public class Server {
    private static ExecutorService SERVICE = Executors.newFixedThreadPool(1000);
    public static HashMap<String,Socket> map=new HashMap();
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(9999);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("服务端已经启动");
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                map.put(socket.getRemoteSocketAddress().toString(),socket);
                System.out.println("有客户端连接:" + socket.getRemoteSocketAddress());
                SERVICE.execute(new MessageHandler(socket));

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
