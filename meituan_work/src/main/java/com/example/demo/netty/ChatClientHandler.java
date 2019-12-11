package com.example.demo.netty;


import com.example.demo.model.ChatMessage;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @Author Mcorleon
 * @Date 2019/12/5 17:05
 */
public class ChatClientHandler extends SimpleChannelInboundHandler<ChatMessage> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, ChatMessage chatMessage) throws Exception {

        System.out.println(chatMessage.getContent());
    }
}
