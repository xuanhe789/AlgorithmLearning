package leetcodeHOT100;

public class _312_戳气球_hard {
    //动态规划
    //dp[i][j]表示砸破i到j开区间内的气球能获取到的最大价值金币
    public int maxCoins(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int n=nums.length;
        int[] newNums=new int[n+2];
        for (int i=1;i<newNums.length-1;i++){
            newNums[i]=nums[i-1];
        }
        newNums[0]=1;
        newNums[newNums.length-1]=1;
        int[][] dp=new int[n+2][n+2];
        for (int length=3;length<=n+2;length++){
            for (int i=0;i<=n+2-length;i++){
                for (int k=i+1;k<i+length-1;k++){
                    int left=dp[i][k];
                    int right=dp[k][i+length-1];
                    dp[i][i+length-1]=Math.max(left+right+newNums[i]*newNums[i+length-1]*newNums[k],dp[i][i+length-1]);
                }
            }
        }
        return dp[0][newNums.length-1];
    }
}
