package 数组中等;

//给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
//
//         
//
//        示例:
//
//        输入: [1,2,3,4]
//        输出: [24,12,8,6]
//         
//
//        提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。
//
//        说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
//
//        进阶：
//        你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
//        链接：https://leetcode-cn.com/problems/product-of-array-except-self
public class 除自身以外数组的乘积 {
    //思路：用两个数组，L数组的i位置存储索引i左边的所有乘积，R数组的i位置存储索引i右边所有的乘积。
    public int[] productExceptSelf(int[] nums) {
        int[] leftArray=new int[nums.length];
        //因为第0个元素左边没有其他元素了，为了不影响乘积，设为1
        leftArray[0]=1;
        int[] rightArray=new int[nums.length];
        rightArray[nums.length-1]=1;
        for (int i=1;i<leftArray.length;i++){
            leftArray[i]=leftArray[i-1]*nums[i-1];
        }
        for (int i=rightArray.length-2;i>=0;i--){
            rightArray[i]=rightArray[i+1]*nums[i+1];
        }
        int[] output=new int[nums.length];
        for (int i=0;i<nums.length;i++){
            output[i]=leftArray[i]*rightArray[i];
        }
        return output;
    }

    //空间复杂度 O(1)的方法,思路：用output数组作为上面解法的leftArray数组
    //用一个变量来代替rightArray数组
    //每次遍历完就R=R*num[nums.length-1-i]
    public int[] productExceptSelf1(int[] nums) {
        int[] output=new int[nums.length];
        //因为第0个元素左边没有其他元素了，为了不影响乘积，设为1
        output[0]=1;
        int R=1;
        for (int i=1;i<output.length;i++){
            output[i]=output[i-1]*nums[i-1];
        }
        for (int i=output.length-1;i>=0;i--){
            output[i]=R*output[i];
            R=R*nums[i];
        }
        return output;
    }
}
