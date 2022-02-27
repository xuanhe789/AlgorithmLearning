package 动态规划从0开始;
/*给定一个整数数组prices，其中第  prices[i] 表示第 i 天的股票价格 。​

        设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:

        卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
        注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

         

        示例 1:

        输入: prices = [1,2,3,0,2]
        输出: 3
        解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]

        示例 2:
        输入: prices = [1]
        输出: 0
*/
public class _17_最佳买卖股票时机含冷冻期 {
    public int maxProfit(int[] prices) {
        if (prices.length==1){
            return 0;
        }
        // 0代表没有持有股票，1代表持有股票
        int[][] dp = new int[prices.length][2];
        dp[0][0]=0;
        dp[0][1]=-prices[0];
        dp[1][0]=Math.max(dp[0][0], dp[0][1]+prices[1]);
        dp[1][1]=Math.max(-prices[0],-prices[1]);
        for (int i = 2; i < prices.length; i++) {
            //第i天未持有股票的最大利润：【不操作】或者【今天卖出股票】，计算得来
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i]);
            //由于有冷却时间，因此第i-1天不能卖出股票，因此第i天持有股票的选择：【不操作】或者【第i-2天不持有股票，第i天买入股票】
            dp[i][1] = Math.max(dp[i-1][1], dp[i-2][0]-prices[i]);
        }
        return dp[prices.length-1][0];
    }

    /*
    * 空间优化
    * */
    public int maxProfitBest(int[] prices) {
        if (prices.length==1){
            return 0;
        }
        // 0代表没有持有股票，1代表持有股票
        int profit1=0;
        int profit2=-prices[0];
        // profit代表dp[i-2][0]
        int profit=0;
        profit1=Math.max(profit1, profit2+prices[1]);
        profit2=Math.max(-prices[0],-prices[1]);
        for (int i = 2; i < prices.length; i++) {
            int temp=profit1;
            //第i天未持有股票的最大利润：【不操作】或者【今天卖出股票】，计算得来
            profit1 = Math.max(profit1, profit2+prices[i]);
            //由于有冷却时间，因此第i-1天不能卖出股票，因此第i天持有股票的选择：【不操作】或者【第i-2天不持有股票，第i天买入股票】
            profit2 = Math.max(profit2, profit-prices[i]);
            profit=temp;
        }
        return profit1;
    }
}
