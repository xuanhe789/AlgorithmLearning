package 动态规划;

public class 分割等和子集 {
    //动态规划，0-1背包问题，最终方案
    public boolean canPartitionBest(int[] nums) {
        if (nums.length==0){
            return false;
        }
        int sum=0;
        for (int i:nums){
            sum+=i;
        }
        if (sum%2!=0){
            return false;
        }
        int avg=sum/2;
        boolean[] dp=new boolean[avg+1];
        dp[0]=true;
        for (int i=0;i<nums.length;i++){
            for (int j=avg;j>=0;j--){
                if (nums[i]==j){
                    dp[j]=true;
                    continue;
                }
                if(nums[i]<=j) {
                    dp[j]=dp[j]||dp[j-nums[i]];
                }
            }
        }
        return dp[avg];
    }

    public boolean canPartitionBetter(int[] nums) {
        if (nums.length==0){
            return false;
        }
        int sum=0;
        for (int i:nums){
            sum+=i;
        }
        if (sum%2!=0){
            return false;
        }
        int avg=sum/2;
        boolean[][] dp=new boolean[nums.length][avg+1];
        dp[0][0]=true;
        if (nums[0]<=avg){
            dp[0][nums[0]]=true;
        }
        for (int i=1;i<dp.length;i++){
            for (int j=0;j<=avg;j++){
                dp[i][j] = dp[i - 1][j];
                if (nums[i]<=j){
                    dp[i][j]=dp[i-1][j] || dp[i-1][j-nums[i]];
                }
            }
            if (dp[i][avg]){
                return true;
            }
        }
        return dp[nums.length-1][avg];
    }
}
