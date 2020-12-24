import java.util.concurrent.locks.ReentrantLock;

public class Test {
    public static void main(String[] args) {
        int[] prices={2,5,4,7,8,9};
        int i = maxProfit(prices);
        System.out.println(i);
    }
    //动态规划
    //dp[i]表示前i天股票最低价
    //prices[i-1]表示的是第i天的股票价格
    //maxProfit表示最大差价
    public static int maxProfit(int prices[]){
        if (prices.length==0){
            return 0;
        }
        int maxProfit=0;
        int[] dp=new int[prices.length+1];
        //di[0]就设置为第一天的股票价
        dp[0]=prices[0];
        for (int i=1;i<=prices.length;i++){
            dp[i]=Math.min(dp[i-1],prices[i-1]);
            if (prices[i-1]-dp[i-1]>maxProfit){
                maxProfit=prices[i-1]-dp[i-1];
            }
        }
        return maxProfit;
    }
}
