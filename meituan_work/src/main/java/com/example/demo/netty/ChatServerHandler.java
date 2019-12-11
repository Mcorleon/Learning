package com.example.demo.netty;


import com.example.demo.model.ChatMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author Mcorleon
 * @Date 2019/12/5 16:47
 */
public class ChatServerHandler extends SimpleChannelInboundHandler<ChatMessage> {
     private static ObjectMapper om=new ObjectMapper();
     private static ConcurrentHashMap<String,Channel> channelMap=new ConcurrentHashMap<>();
    public static ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);



    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {  // 收到新连接时
        Channel incoming = ctx.channel();
        ChatMessage m1=new ChatMessage("server",null,"[SERVER] - " + incoming.remoteAddress() + " 加入","message");
        for (Channel channel : channels) {
            channel.writeAndFlush(m1);
        }
        channels.add(ctx.channel());
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {  // 连接断开时
        Channel incoming = ctx.channel();
        ChatMessage m1=new ChatMessage("server",null,"[SERVER] - " + incoming.remoteAddress() + " 离开","message");
        for (Channel channel : channels) {
            channel.writeAndFlush(m1);
        }
        channels.remove(ctx.channel());
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ChatMessage chatMessage) throws Exception { // 读取客户端消息
        Channel incoming = ctx.channel();
        switch (chatMessage.getType()){
            case "rigister":{
                channelMap.put(chatMessage.getContent(),ctx.channel());
                ChatMessage m1=new ChatMessage("server",chatMessage.getFrom(),"[系统消息]" +"您已上线","message");
                incoming.writeAndFlush(m1);
                break;
            }
            case "message":{
                ChatMessage m1=new ChatMessage("server",chatMessage.getTo(),
                        "[" + chatMessage.getFrom() + "]"+chatMessage.getContent(),"message");
                if(chatMessage.getTo()!=null){

                    channelMap.get(chatMessage.getTo()).writeAndFlush(m1);

                }else {

                    for (Channel channel : channels) {
                        if (channel != incoming) {

                            channel.writeAndFlush(m1);
                        }
                    }
                }
                ChatMessage m2=new ChatMessage("server",chatMessage.getFrom(),
                        "[你]" +chatMessage.getContent(),"message");
                incoming.writeAndFlush(m2);
                break;
            }
            default: break;
        }

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception { // 客户端活动
        Channel incoming = ctx.channel();
        System.out.println("ChatClient:" + incoming.remoteAddress() + "在线");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception { // 客户端失活
        Channel incoming = ctx.channel();
        System.out.println("ChatClient:" + incoming.remoteAddress() + "掉线");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) { // 客户端异常
        Channel incoming = ctx.channel();
        System.out.println("ChatClient:" + incoming.remoteAddress() + "异常");
        // 当出现异常就关闭连接
        cause.printStackTrace();
        ctx.close();
    }
}
