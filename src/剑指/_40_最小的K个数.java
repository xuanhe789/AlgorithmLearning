package 剑指;

import java.util.Arrays;

//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
//
//         
//
//        示例 1：
//
//        输入：arr = [3,2,1], k = 2
//        输出：[1,2] 或者 [2,1]
//        示例 2：
//
//        输入：arr = [0,1,2,1], k = 1
//        输出：[0]
//         
//
//        限制：
//
//        0 <= k <= arr.length <= 10000
//        0 <= arr[i] <= 10000
public class _40_最小的K个数 {
    //基于快速排序的数组划分
    //只要排序的基数排序后刚好在第k个位置，那么左边k-1的数+基数就是结果
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr.length<=k){
            return arr;
        }
        return quickSort(arr,k,0,arr.length-1);
    }

    public int[] quickSort(int[] arr,int k,int low,int high){
        int i=low;
        int j=high;
        int privot=arr[low];
        while (i<j){
            while (i<j&&arr[j]>=privot){
                j--;
            }
            while (i<j&&arr[i]<=privot){
                i++;
            }
            if (i<j){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        arr[low]=arr[i];
        arr[i]=privot;
        //如果基数在数组的位置大于k，则往左搜索
        if (i>k){
            return quickSort(arr,k,low,i-1);
        }
        //如果基数在数组的位置小于k，则往右搜索
        if (i<k){
            return quickSort(arr,k,i+1,high);
        }
        return Arrays.copyOf(arr,k);
    }
}
