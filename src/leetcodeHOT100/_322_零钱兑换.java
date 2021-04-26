package leetcodeHOT100;

import java.util.Arrays;

//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
//
//        你可以认为每种硬币的数量是无限的。
//
//         
//
//        示例 1：
//
//        输入：coins = [1, 2, 5], amount = 11
//        输出：3
//        解释：11 = 5 + 5 + 1
//        示例 2：
//
//        输入：coins = [2], amount = 3
//        输出：-1
//        示例 3：
//
//        输入：coins = [1], amount = 0
//        输出：0
//        示例 4：
//
//        输入：coins = [1], amount = 1
//        输出：1
//        示例 5：
//
//        输入：coins = [1], amount = 2
//        输出：2
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/coin-change
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class _322_零钱兑换 {
    //动态递归法
    public  int coinChange(int[] coins, int amount) {
        if (amount==0){
            return 0;
        }
        return dfs(coins,amount,new int[amount+1]);
    }
    /**
     * 自上而下的动态递归
     * coins:硬币面额
     * rem:余额
     * count:存储中间计算结果，空间换时间，count[n]表示n金额可以组成的最少硬币数
     */
    public int dfs(int[] coins, int rem,int[] count){
        //表示此路不通
        if (rem<0){
            return -1;
        }
        //余额为0.这条路可以走
        if (rem==0){
            return 0;
        }
        //如果之前已经计算过了，就直接返回结果
        if (count[rem]!=0){
            return count[rem];
        }
        //最小值变量，用于存储金额为rem时所能组成的最少硬币数
        int min=Integer.MAX_VALUE;
        //这个for循环就是要找出金额为rem所能组成的最少硬币数
        for (int coin : coins) {
            int res = dfs(coins, rem - coin, count);
            //当res！=-1表示路可以走通，res<min表示，走通这条路所需的硬币数小于上一次的最少硬币数
            if (res!=-1&&res<min){
                //+1表示加上当前这个硬币
                min=res+1;
            }
        }
        int result=min==Integer.MAX_VALUE?-1:min;
        coins[rem]=result;
        return result;
    }

    //动态规划,自底向上
    //状态转移方程:if n>=coin(coin代表硬币的面额)，dp[n]=Math.min(dp[n],dp[n-coin]+1)
    public  int coinChangeBest(int[] coins, int amount) {
        if (amount==0){
            return 0;
        }
        //dp[n]表示n金额时，组成金额的最少硬币数
        int[] dp=new int[amount+1];
        Arrays.fill(dp,amount+1);
        //当金额为0时，硬币数为0
        dp[0]=0;
        //这两层循环的含义是，从金额1开始，计算组成每个金额的最少硬币数
        for (int i=1;i<=amount;i++){
            for (int coin : coins) {
                //当金额大于硬币面额时，才能进行判断
                if (i>=coin){
                    dp[i]=Math.min(dp[i],dp[i-coin]+1);
                }
            }
        }
        //如果dp[amout]等于初始值，说明没有硬币组合能组成amount
        return dp[amount]==amount+1?-1:dp[amount];
    }

}
