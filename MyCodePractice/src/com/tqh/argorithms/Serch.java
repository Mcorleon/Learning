package com.tqh.argorithms;

public class Serch {
    public static void main(String[] args){
        SerchArgorithms serchArgorithms=new SerchArgorithms();
        int[] array={0,2,4,43,412};
        int res=serchArgorithms.binarySerch(array,0,array.length-1,412);
        System.out.println(res);

    }
}

class SerchArgorithms{
    public int binarySerch(int[] array,int left,int right,int target){
        while (left<=right){
            int mid=left+(right-left)/2;
            if (array[mid]>target){
                right=mid-1;
            }else if(array[mid]<target){
                left=mid+1;
            }else {
                return mid;
            }
        }
        return -1;
    }
}