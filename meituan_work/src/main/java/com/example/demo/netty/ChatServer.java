package com.example.demo.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @Author Mcorleon
 * @Date 2019/12/5 16:58
 */
public class ChatServer {
    private  final int port=8080;
    public void run(){
        //用来处理I/O操作的多线程事件循环器，本质是线程池
        EventLoopGroup bossGroup=new NioEventLoopGroup();
        EventLoopGroup workerGroup=new NioEventLoopGroup();
        try{
//           NIO 服务的辅助启动类，初始化配置
            ServerBootstrap b=new ServerBootstrap();
            //boss接收请求，分配给worker线程处理
            // NIO：channal没有读写请求不占用线程，有读写事件再把对应channal上下文分配给线程处理
            b.group(bossGroup,workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChatServerInitializer())
                    .option(ChannelOption.SO_BACKLOG,128)
                    .childOption(ChannelOption.SO_KEEPALIVE,true);
            System.out.println("ChatServer启动了");

            ChannelFuture f=b.bind(port).sync();
            // 等待服务器  socket 关闭 。
            // 在这个例子中，这不会发生，但你可以优雅地关闭你的服务器。
            f.channel().closeFuture().sync();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
            System.out.println("ChatServer关闭");
        }
    }

    public static void main(String[] args){
        new ChatServer().run();
    }
}
