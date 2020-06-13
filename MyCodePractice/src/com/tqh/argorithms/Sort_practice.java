package com.tqh.argorithms;

import java.util.*;

/**
 * @Author Mcorleon
 * @Date 2019/7/1 20:50
 */
public class Sort_practice {
    public static void main(String[] args) {
        Sort_practice sort = new Sort_practice();
        int[] arr = new int[]{3, 85, 2, 4, 5, 34, 21, 32, 2, 2, 6, 33, 7, 1, -1, -1};
        int[] temp = new int[arr.length];
        sort.heapSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
    }

    public void mergeSort(int[] arr,int[] temp,int l,int r){
        if(l<r){
            int mid=l+(r-l)/2;
            mergeSort(arr,temp,l,mid);
            mergeSort(arr,temp,mid+1,r);
            merge(arr,temp,l,mid+1,r);
        }
    }

    private void merge(int[] arr, int[] temp, int l, int mid, int r) {
       int cur=l,l_end=mid-1,len=r-l+1;
       while (l<=l_end&&mid<=r){
           if(arr[l]<arr[mid]){
               temp[cur++]=arr[l++];
           }else {
               temp[cur++]=arr[mid++];
           }
       }
       while (l<=l_end){
           temp[cur++]=arr[l++];
        }
       while (mid<=r){
           temp[cur++]=arr[mid++];
       }
        for (int i = 0; i <len ; i++) {
            arr[r]=temp[r];
            r--;
        }
    }

    public void quickSort(int[] arr,int l,int r){
        if(l<r){
            int pivot=partition(arr,l,r);
            quickSort(arr,l,pivot-1);
            quickSort(arr,pivot+1,r);
        }
    }

    private int partition(int[] arr, int l, int r) {
        int val=arr[l];
        while (l<r){
            while (l<r&&arr[r]>val){
                r--;
            }
            if(l<r){
                arr[l]=arr[r];
            }
            while (l<r&&arr[l]<=val){
                l++;
            }
            if(l<r){
                arr[r]=arr[l];
            }
        }
        arr[l]=val;
        return l;
    }
    public void heapSort(int[] arr){
        for (int i = arr.length/2; i >0 ; i--) {
            heapAdjust(arr,i,arr.length);
        }
        for (int i = arr.length-1; i >0 ; i--) {
            int temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;
            heapAdjust(arr,1,i);

        }
    }

    private void heapAdjust(int[] arr, int s, int len) {
        int val=arr[s-1],largest=0;
        for (int i = 2*s; i <=len ; i*=2) {
            if(i<len&&arr[i-1]<arr[i]){
                largest=i++;
            }else {
                largest=i-1;
            }
            if(val>=arr[largest]){
                break;
            }else {
                arr[s-1]=arr[largest];
                s=largest+1;
            }
        }
        arr[s-1]=val;

    }


}

