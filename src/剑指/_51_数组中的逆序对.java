package 剑指;

import java.util.concurrent.locks.ReentrantLock;

//在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
//
//         
//
//        示例 1:
//
//        输入: [7,5,6,4]
//        输出: 5
//         
//
//        限制：
//
//        0 <= 数组长度 <= 50000
public class _51_数组中的逆序对 {
    int result=0;
    //思路：归并排序，在排序的过程判断左边部分的值是否大于右边，执行对应的
    public int reversePairs(int[] nums) {
        if (nums.length<2){
            return 0;
        }
        mergeSort(nums,0,nums.length-1);
        return result;
    }
    /*
    * 分割数组
    * */
    public void mergeSort(int[] nums,int left,int right){
        if (left==right){
            return;
        }
        int mid=left+(right-left)/2;
        //递归分割左子数组，直到不能分割为止
        mergeSort(nums,left,mid);
        //递归分割右子数组，直到不能分割为止
        mergeSort(nums,mid+1,right);
        //分割完毕后将左子数组和右子数组排序合并
        merge(nums,left,right);
    }
    public void merge(int[] nums,int left,int right){

        int mid=left+(right-left)/2;
        int[] leftArray=new int[mid-left+1];
        int[] rightArray=new int[right-mid];
        for (int i=left;i<mid+1;i++){
            leftArray[i-left]=nums[i];
        }
        for (int i=mid+1;i<=right;i++){
            rightArray[i-(mid+1)]=nums[i];
        }
        new ReentrantLock().unlock();
        int l=leftArray.length-1,r=rightArray.length-1,k=right;
        while (l>=0&&r>=0){
            if (leftArray[l]>rightArray[r]){
                result+=r+1;
                nums[k]=leftArray[l];
                l--;
            }else{
                nums[k]=rightArray[r];
                r--;
            }
            k--;
        }
        while (l>=0){
            nums[k]=leftArray[l];
            k--;
            l--;
        }
        while (r>=0){
            nums[k]=leftArray[r];
            r--;
            k--;
        }
    }
}
