package 动态规划从0开始;
/*给你一个整数 n ，请你找出并返回第 n 个 丑数 。

        丑数 就是只包含质因数 2、3 和/或 5 的正整数。

         

        示例 1：

        输入：n = 10
        输出：12
        解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
        示例 2：

        输入：n = 1
        输出：1
        解释：1 通常被视为丑数。*/

public class _23_丑数II {
    /*
    * 动态规划，下一个丑数必然是由【前面的丑数】*2、*3或者*5得到
    * */
    public int nthUglyNumber(int n) {
        if (n==1){
            return 1;
        }
        int[] dp = new int[n];
        dp[0]=1;
        int dp2=0, dp3=0, dp5=0;
        for (int i = 1; i < n; i++) {
            int min = Math.min(dp[dp2]*2,Math.min(dp[dp3]*3,dp[dp5]*5));
            dp[i]=min;
            if (min==dp[dp2]*2){
                dp2++;
            }
            if (min==dp[dp3]*3){
                dp3++;
            }
            if (min==dp[dp5]*5){
                dp5++;
            }
        }
        return dp[n-1];
    }
}
