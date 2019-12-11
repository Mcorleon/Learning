package com.tqh.io;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class Nio {
    public static void main(String[] args){
        File file=new File("src/data/data.txt");
        try {
            //nio read
            FileInputStream inputStream=new FileInputStream(file);
            FileChannel inFileChannel=inputStream.getChannel();
            ByteBuffer byteBuffer=ByteBuffer.allocate(1024);
            int eof=inFileChannel.read(byteBuffer);
            System.out.println(byteBuffer);
            while (eof!=-1){
                byteBuffer.asCharBuffer();

                byteBuffer.flip();
                while (byteBuffer.hasRemaining()){
                    System.out.println(Charset.forName("UTF-8").decode(byteBuffer));
                }
                byteBuffer.compact();


                 eof=inFileChannel.read(byteBuffer);

            }
            //nio write
//            FileOutputStream fileOutputStream=new FileOutputStream(file);
//            FileChannel outFileChannel=fileOutputStream.getChannel();
//            ByteBuffer byteBuffer= ByteBuffer.allocate(1024);
//            //utf-16编码,普通io按系统编码
//            byteBuffer.asCharBuffer().put("滴滴滴");
//            outFileChannel.write(byteBuffer);
//            outFileChannel.close();
//
//            outFileChannel=new FileInputStream(file).getChannel();
//            byteBuffer.clear();
//            outFileChannel.read(byteBuffer);
//            byteBuffer.flip();
//            System.out.println(byteBuffer.asCharBuffer());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
