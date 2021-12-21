package 动态规划;

public class _518_零钱兑换2_medium {
    //超时
    int result;
    public int change(int amount, int[] coins) {
        if (amount==0){
            return 0;
        }
        dfs(amount,coins,0);
        return result;
    }

    public void dfs(int total,int[] coins,int begin){
        if (total==0){
            result++;
            return;
        }
        if (total<0){
            return;
        }
        for (int i = begin; i < coins.length; i++) {
            dfs(total-coins[i],coins,i);
        }
    }

    /*
    * 动态规划版，完全背包问题
    * */
    public int changeDP(int amount, int[] coins) {
        if (amount==0){
            return 1;
        }
        //状态定义：dp[i][j]表示有前i种硬币可做选择搭配时，能组成amount元的硬币组合数量
        int[][] dp=new int[coins.length][amount+1];
        dp[0][0]=1;
        //dp[i][0]永远都等于1.初始化状态
        //初始化，第一种硬币，在0到amount之间，标记出能被组成的金额，值为1
        for (int i = 1; i <= amount; i++) {
            if (coins[0]<=i){
                dp[0][i]=dp[0][i-coins[0]];
            }
        }
        //从第二个硬币开始遍历
        for (int i = 1; i < coins.length; i++) {
            dp[i][0]=1;
            for (int j=1;j<=amount;j++){
                //默认值为不选择当前种类硬币，所能组成amount元的硬币组合数量
                dp[i][j]=dp[i-1][j];
                //选择当前种类硬币
                if (j>=coins[i]){
                    dp[i][j]+=dp[i][j-coins[i]];
                }
            }
        }
        return dp[coins.length-1][amount];
    }

    /*
    * dp空间优化
    * */
    public int changeDPBetter(int amount, int[] coins) {
        if (amount==0){
            return 1;
        }
        int[] dp=new int[amount+1];
        dp[0]=1;
        for (int i = 1; i <= amount; i++) {
            if (coins[0]<=i){
                dp[i]=dp[i-coins[0]];
            }
        }

        for (int i = 1; i < coins.length; i++) {
            for (int j=1;j<=amount;j++){
                if (j>=coins[i]){
                    dp[j]+=dp[j-coins[i]];
                }
            }
        }
        return dp[amount];
    }
}
