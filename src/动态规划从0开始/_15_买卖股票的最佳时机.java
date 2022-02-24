package 动态规划从0开始;

public class _15_买卖股票的最佳时机 {
    /*
    * 动态规划，就是记录前i天的股票的最低价格，然后每天尝试卖出，计算出最高的利润
    * 还可以空间优化，懒得优化了
    * */
    public int maxProfit(int[] prices) {
        if(prices.length==0){
            return 0;
        }
        //dp[i]存储前i天的最低价
        int[] dp=new int[prices.length];
        dp[0]=prices[0];
        int max=0;
        for (int i=1;i<prices.length;i++){
            dp[i]=Math.min(dp[i-1],prices[i]);
            if (max<prices[i]-dp[i]){
                max=prices[i]-dp[i];
            }
        }
        return max;
    }
}
