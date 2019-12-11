package com.example.demo.netty;

import com.example.demo.model.ChatMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.MessageToByteEncoder;

import java.util.List;

/**
 * @Author Mcorleon
 * @Date 2019/12/9 20:01
 */

public class ChatMessageDecoder extends ByteToMessageDecoder {
    private static ObjectMapper om=new ObjectMapper();

    public static final int HEAD_LENGTH = 4;

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        if (byteBuf.readableBytes() < HEAD_LENGTH) {
            //这个HEAD_LENGTH是我们用于表示头长度的字节数。  由于Encoder中我们传的是一个int类型的值，所以这里HEAD_LENGTH的值为4.
            return;
        }
        byteBuf.markReaderIndex();                  //我们标记一下当前的readIndex的位置
        int dataLength = byteBuf.readInt();       // 读取传送过来的消息的长度。ByteBuf 的readInt()方法会让他的readIndex增加4
        if (dataLength < 0) { // 我们读到的消息体长度为0，这是不应该出现的情况，这里出现这情况，关闭连接。
            channelHandlerContext.close();
        }

        if (byteBuf.readableBytes() < dataLength) { //读到的消息体长度如果小于我们传送过来的消息长度，则resetReaderIndex. 这个配合markReaderIndex使用的。把readIndex重置到mark的地方
            byteBuf.resetReaderIndex();
            return;
        }

        byte[] body = new byte[dataLength];  //传输正常
        byteBuf.readBytes(body);
        Object o =  om.readValue(body,ChatMessage.class);  //将byte数据转化为我们需要的对象

        list.add(o);
    }
}
