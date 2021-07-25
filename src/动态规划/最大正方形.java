package 动态规划;

public class 最大正方形 {
    //动态规划，自顶向下
    //要解这道题必须得画图出来，找规律
    //1.状态定义
    //dp[i][j]表示以当前位置作为正方形右下角的最大正方形的边长
    //2.状态转移方程（优化过的）
    //当i=0或者j=0时，dp[i][j]= matrix[i][j] == '1' ? 1 : 0;
    //当i>0&&j>0时&&matrix[i][j]=='1'，dp[i][j]=Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]))+1;
    //matrix[i][j]=='0',dp[i][j]=0
    public int maximalSquare(char[][] matrix) {
        if (matrix.length==1){
            for (char c:matrix[0]){
                if (c=='1'){
                    return 1;
                }
            }
            return 0;
        }
        int[][] dp=new int[matrix.length][matrix[0].length];
        //因为最大变量不一定在右下角，用max变量记录最大面积
        int max=0;
        //初始化状态
        for (int i=0;i<matrix.length;i++){
            dp[i][0]=matrix[i][0] == '1' ? 1 : 0;
            max=Math.max(max,dp[i][0]);
        }

        for (int i=1;i<matrix.length;i++){
            for (int j=1;j<matrix[0].length;j++){
                if (matrix[i][j]=='1'&&dp[i-1][j]==dp[i][j-1]&&dp[i-1][j]==dp[i-1][j-1]){
                    dp[i][j]=dp[i-1][j]+1;
                }
                else if (matrix[i][j]=='1'&&dp[i-1][j]>0&&dp[i][j-1]>0&&dp[i-1][j-1]>0){
                    dp[i][j]=Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]))+1;
                }
                else if (matrix[i][j]=='1'){
                    dp[i][j]=1;
                }
                else {
                    dp[i][j]=0;
                }
                max=Math.max(max,dp[i][j]*dp[i][j]);
            }
        }
        return max;
    }

    //优化
    public int maximalSquareBetter(char[][] matrix) {
        int[][] dp=new int[matrix.length][matrix[0].length];
        //因为最大变量不一定在右下角，用max变量记录最大面积
        int max=0;
        for (int i=0;i<matrix.length;i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i==0||j==0){
                    dp[i][j]= matrix[i][j] == '1' ? 1 : 0;
                }
                else if (matrix[i][j]=='1'){
                    dp[i][j]=Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]))+1;
                }
                else {
                    dp[i][j]=0;
                }
                max=Math.max(dp[i][j],max);
            }
        }
        return max*max;
    }
}
