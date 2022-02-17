package 动态规划从0开始;

public class _10_最大子数组和 {
    /*
    * 动态规划，这道题比较简单
    * */
    public int maxSubArray(int[] nums) {
        if (nums.length==1){
            return nums[0];
        }
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        int max=nums[0];
        for (int i=1;i<dp.length;i++){
            dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);
            max=Math.max(max,dp[i]);
        }
        return max;
    }

    /*
    * 空间优化
    * */
    public int maxSubArrayBest(int[] nums) {
        if (nums.length==1){
            return nums[0];
        }
        int curMax=nums[0];
        int max=nums[0];
        for (int i=1;i<nums.length;i++){
            curMax=Math.max(curMax+nums[i],nums[i]);
            max=Math.max(max,curMax);
        }
        return max;
    }
}
