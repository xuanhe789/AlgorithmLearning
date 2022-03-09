package 动态规划从0开始;
/*给定一个二维矩阵 matrix，以下类型的多个请求：

        计算其子矩形范围内元素的总和，该子矩阵的 左上角 为 (row1, col1) ，右下角 为 (row2, col2) 。
        实现 NumMatrix 类：

        NumMatrix(int[][] matrix) 给定整数矩阵 matrix 进行初始化
        int sumRegion(int row1, int col1, int row2, int col2) 返回 左上角 (row1, col1) 、右下角 (row2, col2) 所描述的子矩阵的元素 总和 。
         

        示例 1：



        输入:
        ["NumMatrix","sumRegion","sumRegion","sumRegion"]
        [[[[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]]],[2,1,4,3],[1,1,2,2],[1,2,2,4]]
        输出:
        [null, 8, 11, 12]

        解释:
        NumMatrix numMatrix = new NumMatrix([[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]]);
        numMatrix.sumRegion(2, 1, 4, 3); // return 8 (红色矩形框的元素总和)
        numMatrix.sumRegion(1, 1, 2, 2); // return 11 (绿色矩形框的元素总和)
        numMatrix.sumRegion(1, 2, 2, 4); // return 12 (蓝色矩形框的元素总和)*/
public class _30_二维区域和检索_矩阵不可变 {
}


/*
*
* */
class NumMatrix {
    int[][] dp;

    public NumMatrix(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        dp=new int[n+1][m+1];
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                dp[i+1][j+1]=dp[i][j+1]+dp[i+1][j]+matrix[i][j]-dp[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int x1 = row1+1;
        int y1 = col1+1;
        int x2 = row2+1;
        int y2 = col2+1;
        return dp[x2][y2]-dp[x2][y1-1]-dp[x1-1][y2]+dp[x1-1][y1-1];
    }
}
