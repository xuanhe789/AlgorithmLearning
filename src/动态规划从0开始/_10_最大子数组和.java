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

    public int getMaxLen(int[] nums) {
        if (nums.length==1){
            return nums[0]>0?1:0;
        }
        int curMin=nums[0];
        int curMinLength=1;
        int curMax=nums[0];
        int curMaxLength=1;
        int max=nums[0];
        int maxLength=max>0?1:0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]<0){
                int temp=curMin;
                curMin=curMax;
                curMax=temp;
                temp=curMinLength;
                curMinLength=curMaxLength;
                curMaxLength=temp;
            }
            if (curMax*nums[i]>=nums[i]){
                curMax=curMax*nums[i];
                curMaxLength=curMaxLength+1;
            }else {
                curMaxLength=1;
                curMax=nums[i];
            }

            if (curMin*nums[i]<=nums[i]){
                curMin=curMin*nums[i];
                curMinLength=curMinLength+1;
            }else {
                curMinLength=1;
                curMax=nums[i];
            }
            if (max>=curMax){
                max=curMax;
                if (max>0){
                    maxLength=Math.max(curMaxLength,maxLength);
                }
            }
        }
        return curMaxLength;
    }
}
