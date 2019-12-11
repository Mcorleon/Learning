package com.example.demo.netty;


import com.example.demo.model.ChatMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @Author Mcorleon
 * @Date 2019/12/5 17:09
 */
public class ChatClient {
    private final int port=8080;
    private final String host="localhost";
    private String id;

    public ChatClient(String id) {
        this.id = id;
    }

    private static ObjectMapper om=new ObjectMapper();
    public void run(){
        EventLoopGroup group=new NioEventLoopGroup();
        try{
            Bootstrap bootstrap=new Bootstrap()
                    .group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ChatClientInitializer());

            Channel channel=bootstrap.connect(host,port).sync().channel();
            ChatMessage m1=new ChatMessage(id,
                    "server",id,"rigister");
            channel.writeAndFlush(m1);
            BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
            while (true){
                ChatMessage chatMessage=new ChatMessage(id,
                        null,in.readLine(),"message");
                channel.writeAndFlush(chatMessage);
            }

        }catch(Exception e){
            e.printStackTrace();
        }finally {
            group.shutdownGracefully();
        }
    }

}
