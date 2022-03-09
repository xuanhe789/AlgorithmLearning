package 动态规划从0开始;
/*给你一个 n x n 的 方形 整数数组 matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。

        下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。
        在下一行选择的元素和当前行所选元素最多相隔一列（即位于正下方或者沿对角线向左或者向右的第一个元素）。
        具体来说，位置 (row, col) 的
        下一个元素应当是 (row + 1, col - 1)、(row + 1, col) 或者 (row + 1, col + 1) 。*/

public class _27_下降路径最小和 {
    /*
    * 动态规划，dp[i][j]由dp[i-1][j-1]、dp[i-1][j]、dp[i-1][j+1]中的最小值计算得来
    * */
    public int minFallingPathSum(int[][] matrix) {
        if (matrix.length==1){
            return matrix[0][0];
        }
        for (int i=1;i<matrix.length;i++){
            for (int j=0;j<matrix.length;j++){
                if (j==0){
                    matrix[i][j]=matrix[i][j]+Math.min(matrix[i-1][j],matrix[i-1][j+1]);
                    continue;
                }
                if (j==1){
                    matrix[i][j]=matrix[i][j]+Math.min(matrix[i-1][j],matrix[i-1][j-1]);
                    continue;
                }
                matrix[i][j]=matrix[i][j]+Math.min(matrix[i-1][j+1],Math.min(matrix[i-1][j],matrix[i-1][j-1]));
            }
        }
        int result=Integer.MAX_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            result=Math.min(result,matrix[matrix.length-1][i]);
        }
        return result;
    }
}
