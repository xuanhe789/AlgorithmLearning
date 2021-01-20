package 剑指;

public class 剪绳子 {
    //动态规划
    public int cuttingRope(int n) {
        if(n<4){
            return n-1;
        }
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        dp[3]=3;
        for (int i=4;i<=n;i++){
            for (int j=1;j<i;j++){
                dp[i]=Math.max(dp[i],dp[j]*dp[i-j]);
            }
        }
        return dp[n];
    }
}
