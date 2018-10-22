package com.tqh.work;

import java.io.*;

public class RelativeSort {
    public static void main(String[] args){
        File file=new File("F:/材料/实验室/database.txt");
        File out=new File("F:/材料/实验室/relative1.txt");
        try {
            FileReader fileReader=new FileReader(file);
            BufferedReader bufferedReader=new BufferedReader(fileReader);
            FileWriter fileWriter=new FileWriter(out,false);
            BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
            String line=bufferedReader.readLine();
            while (line!=null){
                //每行的String数组转换成Float数据
                String[] lineData=line.split(" ");
                Float[] floatLineData=new Float[5];
                for (int i = 1,j=0; i <6 ; i++,j++) {
                    floatLineData[j]=Float.parseFloat(lineData[i]);
                }
                String count=lineData[6];
                //找每行的最大值
                float lineMax=-1000f;
                for (int i = 0; i <floatLineData.length ; i++) {
                    if(floatLineData[i]>lineMax&&floatLineData[i]!=0){
                        lineMax=floatLineData[i];
                    }
                }
                //写相对值
                Float[] relativeData=new Float[5];
                for (int i = 0; i <floatLineData.length ; i++) {
                    relativeData[i]=floatLineData[i]/lineMax;
                }
                for (int i = 0; i <relativeData.length ; i++) {
                    bufferedWriter.write(relativeData[i].toString()+" ");
                }
                bufferedWriter.write(count+"\r\n");

                line=bufferedReader.readLine();
            }
            bufferedWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
