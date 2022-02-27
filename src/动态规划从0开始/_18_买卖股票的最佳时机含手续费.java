package 动态规划从0开始;
/*给定一个整数数组 prices，其中 prices[i]表示第 i 天的股票价格 ；整数 fee 代表了交易股票的手续费用。

        你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。

        返回获得利润的最大值。

        注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。

         

        示例 1：

        输入：prices = [1, 3, 2, 8, 4, 9], fee = 2
        输出：8
        解释：能够达到的最大利润:
        在此处买入 prices[0] = 1
        在此处卖出 prices[3] = 8
        在此处买入 prices[4] = 4
        在此处卖出 prices[5] = 9
        总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8
        示例 2：

        输入：prices = [1,3,7,5,10,3], fee = 3
        输出：6*/
public class _18_买卖股票的最佳时机含手续费 {
    /*
    * 动态规划，这道题个股票问题II差不多，唯一的差别就在于需要支付手续费
    * 可以选择在买入的时候支付手续费，也可以选择在卖出的时候支付手续费
    * 本题我选择买入的时候支付手续费
    * */
    public int maxProfit(int[] prices, int fee) {
        if (prices.length==1){
            return 0;
        }
        int[][] dp=new int[prices.length][2];
        dp[0][0]=0;
        //买入的收取手续费
        dp[0][1]=-prices[0]-fee;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i]-fee);
        }
        return  dp[prices.length-1][0];
    }

    /*
    * 空间优化
    * */
    public int maxProfitBest(int[] prices, int fee) {
        if (prices.length==1){
            return 0;
        }
        int profit1=0;
        //买入的收取手续费
        int profit2=-prices[0]-fee;
        for (int i = 1; i < prices.length; i++) {
            int temp=profit1;
            profit1=Math.max(profit1,profit2+prices[i]);
            profit2=Math.max(profit2,profit1-prices[i]-fee);
        }
        return  profit1;
    }
}
