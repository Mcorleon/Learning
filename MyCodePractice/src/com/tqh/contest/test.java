package com.tqh.contest;

/**
 * @Author Mcorleon
 * @Date 2019/8/1 15:17
 */
class test {
    public static void main(String[] args){
        test t=new test();
        int[] nums=new int[]{5,7,7,8,8,10};
        int[] res=t.searchRange(nums,8);
        System.out.println(res[0]+","+res[1]);

    }
    public int[] searchRange(int[] nums, int target) {
        int index=search(nums,0,nums.length-1,target);
        int[] res=new int[2];
        res[0]=-1;
        res[1]=-1;
        int start=index,end=index;
        while(start!=-1){
            res[0]=start;
            start=search(nums,0,start-1,target);
        }
        while(end!=-1){
            res[1]=end;
            end=search(nums,end+1,nums.length-1,target);
        }
        return res;
    }

    public int search(int[] nums,int l,int r,int target){
        while(l<=r){
            int mid=l+(r-l)/2;
            if(nums[mid]<target){
                l=mid+1;
            }else if(nums[mid]>target){
                r=mid-1;
            }else{
                return mid;
            }
        }
        return -1;
    }

}
