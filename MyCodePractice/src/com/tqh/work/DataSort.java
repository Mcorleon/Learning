package com.tqh.work;

import java.io.*;

public class DataSort {
    public static void main(String[] args){
        File file=new File("src/data/data.txt");
        File output=new File("F:/材料/实验室/result.txt");
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
                    if (fristChar == 'a') {
                        //采集数据行,;分离
                        String[] lineDatas=line.split(";");
                        //3,4,6,7,8排序
                        Character[] characters=new Character[]{'3','4','6','7'};
                        for (int i = 0; i <characters.length ; i++) {
                            for (int j = 0; j <lineDatas.length ; j++) {
                                char abcNum = lineDatas[j].charAt(3);
                                if(abcNum==characters[i]) {
                                    bufferedWriter.write(lineDatas[j].substring(4));
                                    break;
                                }
                            }
                        }

                        for (int i = 0; i <lineDatas.length ; i++) {
                            char abcNum = lineDatas[i].charAt(3);
                            if(abcNum=='8') {
                                bufferedWriter.write(lineDatas[i].substring(4)+" "+count+"\r\n");
                                count++;
                                if(count>49){
                                    count=0;
                                }
                                break;
                            }

                        }
                    }
                }
                line=bufferedReader.readLine();
            }
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
