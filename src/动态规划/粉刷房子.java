package 动态规划;
//假如有一排房子，共 n 个，每个房子可以被粉刷成红色、蓝色或者绿色这三种颜色中的一种，你需要粉刷所有的房子并且使其相邻的两个房子颜色不能相同。
//
//        当然，因为市场上不同颜色油漆的价格不同，所以房子粉刷成不同颜色的花费成本也是不同的。每个房子粉刷成不同颜色的花费是以一个 n x 3 的矩阵来表示的。
//
//        例如，costs[0][0]表示第 0 号房子粉刷成红色的成本花费；costs[1][2]表示第 1 号房子粉刷成绿色的花费，以此类推。请你计算出粉刷完所有房子最少的花费成本。
//
//        注意：
//
//        所有花费均为正整数。
//
//        示例：
//
//        输入: [[17,2,17],[16,16,5],[14,3,19]]
//        输出: 10
//        解释: 将 0 号房子粉刷成蓝色，1 号房子粉刷成绿色，2 号房子粉刷成蓝色。
//        最少花费: 2 + 5 + 3 = 10。
public class 粉刷房子 {
    //动态规划
    //1.状态定义：
    //dp[i][j]代表前i+1个房子粉刷了某种颜色的最低价格
    //2.状态转移方程
    //dp[i][0]=Math.min(dp[i-1][1],dp[i-1][2])+bills[i][0];
    //dp[i][1]=Math.min(dp[i-1][0],dp[i-1][2])+bills[i][1];
    //dp[i][2]=Math.min(dp[i-1][1],dp[i-1][0])+bills[i][2];
    public int minCost(int[][] bills){
        if (bills.length==1){
            return Math.min(bills[0][0],Math.min(bills[0][1],bills[0][2]));
        }
        int[][] dp=new int[bills.length][3];
        //初始化
        dp[0][0]=bills[0][0];
        dp[0][1]=bills[0][1];
        dp[0][2]=bills[0][2];
        for (int i=1;i<dp.length;i++){
            for (int j=0;j<3;j++){
                if (j==0){
                    dp[i][j]=Math.min(dp[i-1][j+1],dp[i-1][j+2])+bills[i][j];
                }
                else if (j==1){
                    dp[i][j]=Math.min(dp[i-1][j+1],dp[i-1][j-1])+bills[i][j];
                }
                else {
                    dp[i][j]=Math.min(dp[i-1][j-1],dp[i-1][j-2])+bills[i][j];
                }
            }
        }
        int length=dp.length-1;
        return Math.min(dp[length][0],Math.min(dp[length][1],dp[length][2]));
    }
}
