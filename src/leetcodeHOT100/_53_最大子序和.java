package leetcodeHOT100;
//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
//         
//
//        示例 1：
//
//        输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//        输出：6
//        解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
//        示例 2：
//
//        输入：nums = [1]
//        输出：1
//        示例 3：
//
//        输入：nums = [0]
//        输出：0
//        示例 4：
//
//        输入：nums = [-1]
//        输出：-1
//        示例 5：
//
//        输入：nums = [-100000]
//        输出：-100000
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/maximum-subarray
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class _53_最大子序和 {
    //1.动态规划
    public int maxSubArrayDP(int[] nums) {
        if (nums.length==1){
            return nums[0];
        }
        //dp[i]表示以第i个元素作为子连续数组最后一个元素，所能组成的最大和
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        int max=nums[0];
        for (int i=1;i<dp.length;i++){
            dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);
            max=Math.max(max,dp[i]);
        }
        return max;
    }

    //2.代码优化，这道题dp数组可以只用一个变量来替换
    public int maxSubArrayBetter(int[] nums) {
        if (nums.length==1){
            return nums[0];
        }
        int ant=nums[0];
        int max=nums[0];
        for (int i=1;i<nums.length;i++){
            ant=Math.max(ant+nums[i],nums[i]);
            max=Math.max(max,ant);
        }
        return max;
    }
}
