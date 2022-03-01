package 动态规划;
//题目：
//        有N种物品和一个容量为V的背包，每种物品都有无限件可用。
//        第i种物品的费用是c[i]，价值是w[i]。
//        求解将哪些物品装入背包可使这些物品的费用总和不超过背包容量，且价值总和最大。
public class _2_完全背包问题 {
    //动态规划，状态和状态转移方程和0-1背包问题稍有不同
    //状态转移方程为dp[i][j] = Math.max(dp[i - 1][j],dp[i][j-weight[i-1]]+values[i-1]);
    //解释一下状态转移方程：
    // 1.dp[i - 1][j]表示不存放第i种物品所获得的最大价值
    //2.dp[i][j-weight[i-1]]+values[i-1]表示最少存放一件第i种物品所获得的最大价值，因为物品的数量是无限的，可以存放多件，
    // 所以第一个数组的索引是i而不是i-1，i-1表示只能存放一件
    public static int packageProblem(int[] weight, int[] values,int typeNum,int capacity){
        if (weight.length==1&&weight[0]<capacity){
            return values[0];
        }
        //dp[i][j]表示中在前i种物品中，背包容量为j时，选取若干件物品，所能获得的最大价值
        int[][] dp=new int[typeNum+1][capacity+1];//都多加一个位置
        for (int i=1;i<dp.length;i++){
            for (int j=1;j<=capacity;j++){
                dp[i][j]=dp[i- 1][j];
                if (weight[i-1]<=j) {
                    dp[i][j] = Math.max(dp[i - 1][j],dp[i][j-weight[i-1]]+values[i-1] );
                }
            }
        }

        return dp[typeNum][capacity];
    }

    //空间优化，因为dp[i][j]只和dp[i - 1][j]和dp[i][j-weight[i-1]]有关系，所以可以通过从左往右遍历优化空间
    public static int packageProblemBetter(int[] weight, int[] values,int typeNum,int capacity){
        if (weight.length==1&&weight[0]<capacity){
            return values[0];
        }
        int[] dp=new int[capacity+1];//多加一个位置
        for (int i=0;i<typeNum;i++){
            //因为dp[j]默认等于上一次的结果，所以我们可以从weight[i]开始计算
            for (int j=weight[i];j<=capacity;j++){
                if (weight[i]<=j) {
                    dp[j] = Math.max(dp[j],dp[j-weight[i]]+values[i]);
                }
            }
        }

        return dp[capacity];
    }

    public int coinChange(int[] coins, int amount) {
        if(amount==0){
            return 0;
        }
        int dp[][]=new int[coins.length][amount+1];
        //初始化
        for (int i=1;i<=amount;i++){
            if (i>=coins[0]&&dp[0][i-coins[0]]!=-1){
                dp[0][i]=dp[0][i-coins[0]]+1;
            }else{
                dp[0][i]=-1;
            }
        }

        for(int i=1;i<coins.length;i++){
            for (int j=1;j<=amount;j++){
                //默认为不选的情况
                dp[i][j]=dp[i-1][j];
                if (coins[i]<=j){
                    //在选取当前硬币若干个，或者不选取当前硬币之间做抉择
                    if (dp[i-1][j]!=-1&&dp[i][j-coins[i]]!=-1) {
                        dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i]] + 1);
                    }else if (dp[i][j - coins[i]]!=-1){
                        dp[i][j]=dp[i][j - coins[i]] + 1;
                    }
                }
            }
        }
        return dp[coins.length-1][amount]==0?-1:dp[coins.length-1][amount];
    }

    /*
    * 空间优化
    * */
    public int coinChangeBetter(int[] coins, int amount) {
        if(amount==0){
            return 0;
        }
        int dp[]=new int[amount+1];
        //初始化
        for (int i=1;i<=amount;i++){
            if (i>=coins[0]&&dp[i-coins[0]]!=-1){
                dp[i]=dp[i-coins[0]]+1;
            }else {
                dp[i]=-1;
            }
        }

        for(int i=1;i<coins.length;i++){
            for (int j=1;j<=amount;j++){
                if (coins[i]<=j){
                    //在选取当前硬币若干个，或者不选取当前硬币之间做抉择
                    if (dp[j]!=-1&&dp[j-coins[i]]!=-1) {
                        dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                    }else if (dp[j - coins[i]]!=-1){
                        dp[j]=dp[j - coins[i]] + 1;
                    }
                }
            }
        }
        return dp[amount]==0?-1:dp[amount];
    }
}
