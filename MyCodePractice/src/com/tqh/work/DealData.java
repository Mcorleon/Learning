package com.tqh.work;

import java.io.*;

public class DealData {
    public static void main(String[] args){
        File file=new File("src/data/rawdata.txt");
        File output=new File("src/data/rawData_acc_gryo.txt");
        float[][] data=new float[3][12];
        int acc_col=0;
        int gyro_col=1;
        try {
            FileReader fileReader=new FileReader(file);
            BufferedReader bufferedReader=new BufferedReader(fileReader);
            String line=bufferedReader.readLine();
            //true在末尾继续写，false覆盖
            FileWriter fileWriter=new FileWriter(output,false);
            BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
            int count=0;
            while (line!=null){

                if(line.length()!=0) {
                    char fristChar = line.charAt(0);
                    if (fristChar == 'A') {
                        //这一行是加速度计数据
                        String temp=line.substring(4);
                        bufferedWriter.write(temp+"\r\n");
                    }
                    if (fristChar == 'G') {
                        //这一行是陀螺仪数据
                        String temp=line.substring(5);
                        bufferedWriter.write(temp+"\r\n");
                    }
                }
                line=bufferedReader.readLine();
            }
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
