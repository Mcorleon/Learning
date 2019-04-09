package com.tqh.socket;

import java.io.*;
import java.net.Socket;

import static com.tqh.socket.Server.map;

/**
 * @Author Mcorleon
 * @Date 2019/3/29 21:12
 */
public class MessageHandler implements Runnable {
    Socket clientSocket;

    public MessageHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        BufferedReader reader=null;
        BufferedWriter bufferedWriter=null;
        PrintWriter writer=null;
        try {
            reader=new BufferedReader(new InputStreamReader(clientSocket.getInputStream(),"UTF-8"));

            //从InputStream当中读取客户端所发送的数据,交给对话的目标
            while (true){
                String data=reader.readLine();
                if(data!=null){
                    String[] strings=data.split(",");
                    String target=strings[0];
                    String msg=null;
                    if(strings.length>1){
                        msg=strings[1];
                        System.out.println(msg);
                    }
                    Socket socket=map.get(target);
                    if(socket==null){
                        bufferedWriter=new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream(),"UTF-8"));
                        writer=new PrintWriter(bufferedWriter,true);
                        writer.println("发送失败");
                    }else {
                        bufferedWriter=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"));
                        writer=new PrintWriter(bufferedWriter,true);
                        writer.println(socket.getRemoteSocketAddress()+":"+msg);
                    }
                }
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
