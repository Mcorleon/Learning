package com.tqh.work;

import java.io.*;

public class DealMagData {
    public static void main(String[] args) {
        float[][] mag_data=getMagData();
        File file = new File("src/data/DeepMSCNN.txt");
        File output = new File("src/data/RSSI_MAG.txt");
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            //true在末尾继续写，false覆盖
            FileWriter fileWriter = new FileWriter(output, false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            int row = 0;
            while (line != null) {

                if (line.length() != 0) {
                    String n=line.substring(line.length()-2,line.length());
                    String newLine=line.substring(0,line.length()-2)+mag_data[row][0]+" "+mag_data[row][1]+" "+mag_data[row][2]+" "+n+"\r\n";
                    bufferedWriter.write(newLine);
                }
                line=bufferedReader.readLine();
                row++;
            }
            bufferedWriter.flush();
            bufferedWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static float[][] getMagData() {
        File file = new File("src/data/mag_record.txt");
        float[][] data=new float[3000][3];
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            int row=0;
            while (line != null) {

                if (line.length() != 0) {
                    String[] strings=line.split(",");
                    for(int i=0;i<strings.length ;i++){
                        data[row][i]=Float.valueOf(strings[i]);
                    }
                }
                line=bufferedReader.readLine();
                row++;
            }
//            for(int i=0;i<data.length ;i++){
//                for (int j = 0; j <data[0].length ; j++) {
//                    System.out.print(data[i][j]+",");
//                }
//                System.out.println(" ");
//            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

}
