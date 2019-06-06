package com.tqh.deep_learing_data_sort;

import java.io.*;

/**
 * @Author Mcorleon
 * @Date 2019/4/22 14:17
 */
public class deal_IMU {
    public static void main(String[] args){
        File file=new File("src/deep_learning_data/run_data1_imu1.csv");
        File output=new File("src/deep_learning_output/run_data1_acc.csv");
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            //true在末尾继续写，false覆盖
            FileWriter fileWriter = new FileWriter(output, false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            while (line != null) {
                String[] dara=line.split(",");
                bufferedWriter.write(dara[10]+","+dara[11]+","+dara[12]+"\r\n");
                line=bufferedReader.readLine();
            }
            bufferedWriter.flush();
            bufferedWriter.close();
            bufferedReader.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
