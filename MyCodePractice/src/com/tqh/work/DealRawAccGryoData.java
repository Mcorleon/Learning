package com.tqh.work;

import java.io.*;

public class DealRawAccGryoData {
    public static void main(String[] args){
        File file=new File("src/data/rawData_acc_gryo.txt");
        File output=new File("src/data/acc_gryo.txt");
        try {
            FileReader fileReader=new FileReader(file);
            BufferedReader bufferedReader=new BufferedReader(fileReader);
            String line=bufferedReader.readLine();
            //true在末尾继续写，false覆盖
            FileWriter fileWriter=new FileWriter(output,false);
            BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
            int count=0;
            StringBuilder newLine=new StringBuilder();
            while (line!=null){
                if(line.length()!=0) {
                    String[] strings=line.split(",");
                    for (int i = 0; i <strings.length ; i++) {
                        newLine.append(strings[i]+" ");
                    }
                    count++;
                }
                if(count==200){
                    bufferedWriter.write(newLine.toString()+"\r\n");
                    count=0;
                    newLine=new StringBuilder();
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
