package com.example.demo.netty;

import com.example.demo.model.ChatMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @Author Mcorleon
 * @Date 2019/12/9 20:01
 */

public class ChatMessageEncoder extends MessageToByteEncoder<ChatMessage> {
    private static ObjectMapper om = new ObjectMapper();

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, ChatMessage chatMessage, ByteBuf byteBuf) throws Exception {
        byte[] body = om.writeValueAsBytes(chatMessage);  //将对象转换为byte
        int dataLength = body.length;  //读取消息的长度
        byteBuf.writeInt(dataLength);  //先将消息长度写入，也就是消息头
        byteBuf.writeBytes(body);  //消息体中包含我们要发送的数据
    }


}
