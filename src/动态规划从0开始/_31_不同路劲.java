package 动态规划从0开始;

import java.util.Arrays;

public class _31_不同路劲 {
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
        //初始条件
        dp[0][0]=1;
        for (int i=0;i<dp.length;i++){
            dp[i][0]=1;
        }
        for (int i=0;i<dp[0].length;i++){
            dp[0][i]=1;
        }
        for (int i=1;i<dp.length;i++){
            for (int j=1;j<dp[0].length;j++){
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }

        //返回右下角元素
        return dp[m-1][n-1];
    }

    /*
    * 空间优化
    * */
    public int uniquePathsBest(int m, int n) {
        int[] dp=new int[n];

        Arrays.fill(dp,1);

        for (int i=1;i<m;i++){
            for (int j=1;j<n;j++){
                dp[j]=dp[j]+dp[j-1];
            }
        }

        //返回右下角元素
        return dp[n-1];
    }
}
