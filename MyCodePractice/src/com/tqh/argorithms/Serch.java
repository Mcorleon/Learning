package com.tqh.argorithms;

public class Serch {
    public static void main(String[] args){
        SerchArgorithms serchArgorithms=new SerchArgorithms();
        int[] array={1,2,3,4,5,6,7,8,9,10};
        int res=serchArgorithms.binarySerch(array,0,array.length-1,99);
        System.out.println(res);

    }
}

class SerchArgorithms{
    public int binarySerch(int[] array,int left,int right,int target){
        if (left>=right){
            return -1;
        }
        int mid=(left+right)/2;
        if(array[mid]>target){
            return binarySerch(array,left,mid-1,target);
        }else if(array[mid]<target){
            return binarySerch(array,mid+1,right,target);
        }else {
            return mid;
        }
    }
}