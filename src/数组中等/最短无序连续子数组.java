package 数组中等;
//给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
//
//        你找到的子数组应是最短的，请输出它的长度。
//
//        示例 1:
//
//        输入: [2, 6, 4, 8, 10, 9, 15]
//        输出: 5
//        解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
//        链接：https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray
public class 最短无序连续子数组 {
    public int findUnsortedSubarray(int[] nums) {
        int left=0,right=-1;
        int max=nums[0],min=nums[nums.length-1];
        for (int i=0;i<nums.length;i++){
            if (max>nums[i]){
                right=i;
            }
            else {
                max=nums[i];
            }
            if (min<nums[nums.length-i-1]){
                left=nums.length-i-1;
            }
            else {
                min=nums[nums.length-i-1];
            }
        }
        return right-left+1;
    }
}
