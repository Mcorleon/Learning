package com.tqh.deep_learing_data_sort;

import com.tqh.work.ViData;

import java.io.*;
import java.util.ArrayList;

/**
 * @Author Mcorleon
 * @Date 2019/4/22 14:17
 */
public class deal_VI {
    public static void main(String[] args){
        File file=new File("src/deep_learning_data/data1_vi1.csv");

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();

            int count=1;
            ArrayList<ViData> list=new ArrayList<>();
            while (line != null) {
                if(count%10==1||count%10==0){
                    String[] dara=line.split(",");
                    float t_x=Float.parseFloat(dara[2]);
                    float t_y=Float.parseFloat(dara[3]);
                    float r_x=Float.parseFloat(dara[5]);
                    float r_y=Float.parseFloat(dara[6]);
                    float r_z=Float.parseFloat(dara[7]);
                    float r_w=Float.parseFloat(dara[8]);
                    ViData viData=new ViData(t_x,t_y,r_x,r_y,r_z,r_w);
                    list.add(viData);
                }
                count++;
                line=bufferedReader.readLine();
            }
            bufferedReader.close();
            //true在末尾继续写，false覆盖
            File output=new File("src/deep_learning_output/data1_degree_vi.csv");
            FileWriter fileWriter = new FileWriter(output, false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);


            for (int i = 0; i <list.size() ; i+=2) {
                if(i+1>=list.size()){
                    break;
                }
                ViData data1=list.get(i);
                ViData data2=list.get(i+1);
                LAndDegree lAndDegree=calculate(data1,data2);
//                bufferedWriter.write(lAndDegree.getL()+"\r\n");
                bufferedWriter.write(lAndDegree.getDegree()+"\r\n");
            }
            bufferedWriter.flush();
            bufferedWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static LAndDegree calculate(ViData data1, ViData data2) {
        double L_temp=Math.pow(data1.getT_x()-data2.getT_x(),2)+Math.pow(data1.getT_y()-data2.getT_y(),2);
        double L=Math.sqrt(L_temp);
        double data1_degree=cal_degree(data1.getR_x(),data1.getR_y(),data1.getR_z(),data1.getR_w());
        double data2_degree=cal_degree(data2.getR_x(),data2.getR_y(),data2.getR_z(),data2.getR_w());
        double degree=data2_degree-data1_degree;
        if(degree>180){
            degree=degree-360;
        }
        if(degree<-180){
            degree=degree+360;
        }

        return new LAndDegree(L,degree);
    }


    private static double cal_degree(float x, float y, float z, float w) {
        //四元数转欧拉角
        double elur_x=Math.atan2(2*(w*x+y*z),1-2*(Math.pow(x,2)+Math.pow(y,2)));
        double elur_y=Math.asin(2*(w*y-x*z));
        double elur_z=Math.atan2(2*(w*z+y*x),1-2*(Math.pow(y,2)+Math.pow(z,2)));
        //弧度转度数
        return elur_z*180/Math.PI;
    }
}
