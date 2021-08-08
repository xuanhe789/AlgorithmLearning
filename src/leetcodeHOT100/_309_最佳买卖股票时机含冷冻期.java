package leetcodeHOT100;
//知耻而后勇，知弱而图强
//给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
//
//        设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
//
//        你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
//        卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
//        示例:
//
//        输入: [1,2,3,0,2]
//        输出: 3
//        解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class _309_最佳买卖股票时机含冷冻期 {
    //动态规划，3个维度，0表示未持有股票，1表示持有股票，2表示冷冻期
    //dp[i][0]表示第i天不持有股票的最大收益，不持有股票的情况包括本来就不持有，或者昨天股票卖出去，今天处于冷冻期
    //dp[i][1]表示第i天持有股票的最大收益
    //dp[i][2]表示第i天是昨天天持有股票并且今天卖出的最大收益，冷冻期只能从昨天
    public int maxProfit(int[] prices) {
        int[][] dp=new int[prices.length][3];
        dp[0][0]=0;
        dp[0][1]=0-prices[0];
        dp[0][2]=0;
        for (int i=1;i<prices.length;i++){
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][2]);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
            dp[i][2]=dp[i-1][1]+prices[i];
        }
        return Math.max(dp[prices.length-1][0],dp[prices.length-1][2]);
    }
}
