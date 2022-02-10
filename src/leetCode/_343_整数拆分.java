package leetCode;
/*给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。

        返回 你可以获得的最大乘积 。

         

        示例 1:

        输入: n = 2
        输出: 1
        解释: 2 = 1 + 1, 1 × 1 = 1。
        示例 2:

        输入: n = 10
        输出: 36
        解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/integer-break
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class _343_整数拆分 {
    /*
    * 动态规划
    * dp[i]表示i经过分解所能获得的最大乘积
    * 假如i分解成j和i-j两部分，那么最大值可由两种情况产生
    * 1.不继续分解i-j，所获得的乘积为i * (i-j)
    * 2.继续分解i-j，所获得的乘积为 i * dp[i-j]
    * */
    public int integerBreak(int n) {
        if (n<4){
            return n-1;
        }
        int[] dp = new int[n+1];
        dp[1]=1;
        for (int i=2;i<dp.length;i++){
            int max=0;
            for (int j=1;j<i;j++){
                max=Math.max(max,Math.max(j * i-j, j * dp[i-j]));
            }
            dp[i]=max;
        }
        return dp[n+1];
    }
}
