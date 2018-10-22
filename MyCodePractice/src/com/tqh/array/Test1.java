package com.tqh.array;

import java.util.Random;

public class Test1 {
    public Double[][] createArray(double x1, double x2, int i, int j) {
        Random random = new Random(47);
        Double[][] doubles = new Double[i][j];
        for (int ii = 0; ii < doubles.length; ii++) {
            for (int jj = 0; jj < doubles[ii].length; jj++) {
                double temp=0d;
                while (!(temp<x2&&temp>x1)){
                    temp=random.nextDouble()*x2;
                }
                doubles[ii][jj]=temp;
            }
        }
        return doubles;

    }
    public void printArray(Double[][] doubles){
        for (int i = 0; i <doubles.length ; i++) {
            for (int j = 0; j <doubles[i].length ; j++) {
                System.out.println(doubles[i][j]);
            }
        }
    }
    public static void main(String[] args){
      Test1 test1=new Test1();
      Double[][] doubles=test1.createArray(1d,32d,3,3);
      test1.printArray(doubles);
    }
}