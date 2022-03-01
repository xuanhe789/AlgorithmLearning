package 动态规划;

import java.util.Arrays;

//给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
//
//        子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
//
//         
//        示例 1：
//
//        输入：nums = [10,9,2,5,3,7,101,18]
//        输出：4
//        解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
//        示例 2：
//
//        输入：nums = [0,1,0,3,2,3]
//        输出：4
//        示例 3：
//
//        输入：nums = [7,7,7,7,7,7,7]
//        输出：1
//         
//
//        提示：
//
//        1 <= nums.length <= 2500
//        -104 <= nums[i] <= 104
//         
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class 最长递增子序列 {
    public int lengthOfLIS(int[] nums) {
        if (nums.length==1){
            return 1;
        }
        int[] dp=new int[nums.length];
        //初始化
        int max=1;
        Arrays.fill(dp,1);
        for (int i=1;i<dp.length;i++){
            for (int j=0;j<i;j++){
                if (nums[i]>nums[j]){
                    dp[i]=Math.max(dp[j]+1,dp[i]);
                    max=Math.max(dp[i],max);
                }
            }
        }
        return max;
    }

    /*
    * 回溯解法，超时
    * */
    public int lengthOfLISDFS(int[] nums) {
        if (nums.length==1){
            return 1;
        }
        dfs(nums,0,Integer.MIN_VALUE,0);
        return result;
    }

    int result=0;

    public void dfs(int[] nums, int index, int value,int length){
        if (result<length){
            result=length;
        }
        for (int i=index;i<nums.length;i++){
            if (nums[i]>value){
                dfs(nums,i,nums[i],length+1);
            }
        }
    }
}
