package com.tqh.socket;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Author Mcorleon
 * @Date 2019/3/29 21:36
 */
public class ClientKeyBoardListener implements Runnable {
    Socket clientSocket;
    public ClientKeyBoardListener(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }
    @Override
    public void run() {
        BufferedWriter bufferedWriter=null;
        PrintWriter writer=null;
        Scanner scanner=new Scanner(System.in);
        try {
            bufferedWriter=new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream(),"UTF-8"));
            writer=new PrintWriter(bufferedWriter,true);
            //写入键盘数据
            while (true){
                writer.println(scanner.nextLine());
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if(writer!=null){
                    writer.close();
                }
                clientSocket.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }
}
