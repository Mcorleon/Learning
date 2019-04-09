package com.tqh.socket;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Author Mcorleon
 * @Date 2019/3/29 21:41
 */
public class ClientMessageLisener implements Runnable {
    Socket clientSocket;
    public ClientMessageLisener(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }
    @Override
    public void run() {
        BufferedReader reader=null;
        try {
            reader=new BufferedReader(new InputStreamReader(clientSocket.getInputStream(),"UTF-8"));
            //读取
            while (true){
                System.out.println(reader.readLine());
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if(reader!=null){
                    reader.close();
                }
                clientSocket.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }
}
