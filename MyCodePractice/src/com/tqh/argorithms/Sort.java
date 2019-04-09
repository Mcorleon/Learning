package com.tqh.argorithms;

import java.util.ArrayList;
import java.util.Arrays;

public class Sort {
    public static void main(String[] args){
        SortArgorithms sortArgorithms=new SortArgorithms();
        int[] array={1,22,78,23,12,12,52,2,14,33,123,45,66,66,66,54,36,87};
        int[] temp=new int[array.length];
        sortArgorithms.quickSort(array,0,array.length-1);
        for(int i=0;i<array.length ;i++){
            System.out.print(array[i]+" ");
        }
    }
}

class  SortArgorithms{
    /**
     * 冒泡排序
     */
    public void bubbleSort(int[] array){
        int temp=0;
        for(int i=array.length-1;i>0 ;i--){
            for(int j=0;j<i ;j++){
                if(array[j]>array[j+1]){
                    temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
        }
    }
    /**
     * 选择排序
     * 和冒泡不同之处在于：冒泡每一轮比较相邻的，一轮结束后最大值被换到最后。
     * 选择排序是用当前值逐一与后面的比较，交换，选出最小。
     */
    public void selectionSort(int[] array){
        int temp=0;
        for(int i=0;i<array.length-1;i++){
            for (int j = i+1; j <array.length ; j++) {
                if(array[i]>array[j]){
                    temp=array[j];
                    array[j]=array[i];
                    array[i]=temp;
                }
            }
        }
    }
    /**
     * 插入排序
     * 接近有序时效率最高
     */
    public void insertionSort(int[] array){
        int temp;
        for(int i=0;i<array.length-1 ;i++){
            for(int j=i+1;j>0 ;j--){
                if(array[j]<array[j-1]){
                    temp=array[j];
                    array[j]=array[j-1];
                    array[j-1]=temp;
                }else {
                    //前面都是从小到大排好的，符合就不必继续比较了
                    break;
                }
            }
        }
    }
    /**
     * 希尔排序
     */
    public void shellSort(int[] array){
        for(int gap=array.length/2;gap>0;gap/=2){
            for(int i=gap;i<array.length ;i++){
               if(array[i]<array[i-gap]){
                   int j=i-gap;
                   int temp=array[i];
                   while (j>=0&&array[j]>temp){
                       array[j+gap]=array[j];
                       j-=gap;
                   }
                   array[j+gap]=temp;
               }
            }
        }
    }
    /**
     * 归并排序
     */
    public void mergeSort(int[] array,int[] temp,int left,int right){
        int mid;
        if(left<right){
            mid=(left+right)/2;
            mergeSort(array,temp,left,mid);
            mergeSort(array,temp,mid+1,right);
            merge(array,temp,left,mid+1,right);
        }
    }
    public void merge(int[] array,int[] temp,int left,int mid,int right){
        int left_end=mid-1;
        int temp_pos=left;
        int size=right-left+1;
        //左右两组都是已排序的，再排序整合成新的一组
        while (left<=left_end&&mid<=right){
            if(array[left]<array[mid]){
                temp[temp_pos++]=array[left++];
            }else {
                temp[temp_pos++]=array[mid++];
            }
        }
        //以下两个while只有一个会执行，目的是把那一组剩下的元素全部加到temp后面去
        while (left<=left_end){
            temp[temp_pos++]=array[left++];
        }
        while (mid<=right){
            temp[temp_pos++]=array[mid++];
        }
        //把排好的temp写回原数组去
        for(int i=0;i<size ;i++){
            array[right]=temp[right];
            right--;
        }

    }
    /**
     * 快速排序
     * 越接近无序效率越高
     */
    public void quickSort(int[] array,int left,int right){
        int pivot;
        if(left<right){
            pivot=partition(array,left,right);
            quickSort(array,left,pivot-1);
            quickSort(array,pivot+1,right);
        }
    }

    public int partition(int[] array,int left,int right){
        //基准值默认是第一个坑位
        int pivot_val=array[left];
        while (left<right){
            //从右往左找小于基准值的值
            while (array[right]>pivot_val&&left<right){
                right--;
            }
            //找到了，填上左边的坑，右边出新坑
            if(left<right){
                array[left]=array[right];
            }
            //从左往右找大于基准值的值（两个while需要有一个有=号）
            while (array[left]<=pivot_val&&left<right){
                left++;
            }
            //找到了，填上右边的坑，左边又出现坑
            if(left<right){
                array[right]=array[left];
            }
        }
        //这时left=right，退出循环。最后这个坑的位置就是枢轴，这里左边都小于pivot_val右边都大于pivot_val
        array[left]=pivot_val;
        return left;
    }

    /**
     * 堆排序
     */
    public void heapSort(int[] array){
        //堆是满二叉树，n/2+1~n的元素都是叶子节点,根据前面n/2个元素进行向下渗透构建即可
        for(int i=array.length/2;i>0;i--){
            //构建成大顶锥
            heapAdjust(array,i,array.length);
        }

        for(int i=array.length-1;i>0;i--){
            //把最大的元素换到最后
            int temp;
            temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            //重新调整为大顶堆
            heapAdjust(array,1,i);
        }
    }

    public void heapAdjust(int[] a,int s,int len){
        int temp,i,largest; //largest中存关键字较大的记录下标
        //节点s表示为a[s-1]，左右孩子应为a[2s-1],a[2s]
        temp = a[s-1];
        for(i=2*s;i<=len;i*=2){
            //取较大孩子的下标
            if(i<len && a[i-1]<a[i]){
                largest = i;
                i++;
            }else{
                largest = i-1;
            }
            //判断是否继续向下渗透
            if(temp>=a[largest]){
                break;
            }else {
                a[s-1] = a[largest];
                s = largest+1;
            }
        }
        a[s-1] = temp;
    }

}