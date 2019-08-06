package com.tqh.deep_learing_data_sort;

import com.tqh.work.ViData;

import java.io.*;
import java.util.ArrayList;

/**
 * @Author Mcorleon
 * @Date 2019/6/15 13:57
 */
public class Get_x_y {
    public static void main(String[] args) {
        File file = new File("src/deep_learning_data/data1_vi1.csv");
        try{

            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            File output = new File("src/deep_learning_output/data1_vi_x_y.csv");
            FileWriter fileWriter = new FileWriter(output, false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            int count=1;
            while (line != null) {
                if(count%10==0){
                    String[] data=line.split(",");
                    float t_x = Float.parseFloat(data[2]);
                    float t_y = Float.parseFloat(data[3]);
                    bufferedWriter.write(t_x+","+t_y+"\r\n");
                }
                count++;
                line = bufferedReader.readLine();
            }
            bufferedWriter.flush();
            bufferedWriter.close();
            bufferedReader.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}


