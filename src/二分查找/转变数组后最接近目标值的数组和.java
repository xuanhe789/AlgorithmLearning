package 二分查找;

import java.util.Arrays;
import java.util.Date;
//给你一个整数数组 arr 和一个目标值 target ，请你返回一个整数 value ，使得将数组中所有大于 value 的值变成 value 后，数组的和最接近  target （最接近表示两者之差的绝对值最小）。
//
//        如果有多种使得和最接近 target 的方案，请你返回这些整数中的最小值。
//
//        请注意，答案不一定是 arr 中的数字。
//
//         
//
//        示例 1：
//
//        输入：arr = [4,9,3], target = 10
//        输出：3
//        解释：当选择 value 为 3 时，数组会变成 [3, 3, 3]，和为 9 ，这是最接近 target 的方案。
//        示例 2：
//
//        输入：arr = [2,3,5], target = 10
//        输出：5
//        示例 3：
//
//        输入：arr = [60864,25176,27249,21296,20204], target = 56803
//        输出：11361
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/sum-of-mutated-array-closest-to-target
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class 转变数组后最接近目标值的数组和 {
    //第一种，暴力法，遍历,从target值/数组长度 开始，发现规律只要下一个整数的sum-target开始持平或者递增，
    //就可以得出当前节点为sum-target最低的节点，当前节点为结果值
    //思路，从target值/数组长度开始，只要当前整数的|sum-target|小于上个整数的|sum-target|，整数++，否则，返回上个整数，利用了这个题的单调不减性
    public int findBestValue(int[] arr, int target) {
        int length=arr.length;
        int avg=target/length;
        int max=0;
        for (int i:arr){
            if (i>max){
                max=i;
            }
        }
        if (max<=avg){
            return max;
        }
        int min=Integer.MAX_VALUE;
        for (int i=avg;;i++){
            int sum=0;
            for (int value:arr){
                if (i<=value){
                    sum+=i;
                }
                else {
                    sum+=value;
                }
            }
            //判断是否是最低点
            if (Math.abs(target-sum)>=min){
                return i-1;
            }
            else {
                min=Math.abs(target-sum);
            }
        }
    }

    //二分查找,开始右边界为数组中最大的数，左边界为0，
    //思路1：找到第一个sum比target大的整数，这时结果整数就是当前整数或者上一个整数
    //思路2：找到最后一个sum比target小的整数，这时结果整数就是当前整数或者下一个整数
    public int findBestValue2(int[] arr, int target) {
        int left=0;
        int right=0;
        int min=Integer.MAX_VALUE;
        for (int i:arr){
            if (i>right){
                right=i;
            }
        }
        while (left<right){
            int mid=left+(right-left)/2;
            int sum = caculateSum(arr, mid);
            if (sum-target<0){
                left=mid+1;
            }
            else {
                right=mid;
            }
        }
        int rightValue=caculateSum(arr,left);
        int leftValue = caculateSum(arr, left - 1);
        if (rightValue-target>=target-leftValue){
            return left-1;
        }
        else {
            return left;
        }
    }

    public int findBestValue3(int[] arr, int target) {
        int left=0;
        int right=0;
        int min=Integer.MAX_VALUE;
        for (int i:arr){
            if (i>right){
                right=i;
            }
        }
        while (left<right){
            int mid=left+(right-left+1)/2;
            int sum = caculateSum(arr, mid);
            if (sum-target>=0){
                right=mid-1;
            }
            else {
                left=mid;
            }
        }
        int leftValue=caculateSum(arr,left);
        int rightValue = caculateSum(arr, left + 1);
        if (Math.abs(rightValue-target)>=Math.abs(target-leftValue)){
            return left;
        }
        else {
            return left+1;
        }
    }

    public int caculateSum(int[] arr,int val){
        int sum=0;
        for (int i:arr){
            if (i<val){
                sum+=i;
            }
            else {
                sum+=val;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr=new int[]{2,3,5};
        int target=11;
        转变数组后最接近目标值的数组和 a = new 转变数组后最接近目标值的数组和();
        a.findBestValue3(arr,target);
    }
}
