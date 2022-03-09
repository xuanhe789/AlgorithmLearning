package 动态规划从0开始;
/*给你一个 m x n 的矩阵 mat 和一个整数 k ，请你返回一个矩阵 answer ，其中每个 answer[i][j] 是所有满足下述条件的元素 mat[r][c] 的和： 

        i - k <= r <= i + k,
        j - k <= c <= j + k 且
        (r, c) 在矩阵内。
         

        示例 1：

        输入：mat = [[1,2,3],[4,5,6],[7,8,9]], k = 1
        输出：[[12,21,16],[27,45,33],[24,39,28]]
        示例 2：

        输入：mat = [[1,2,3],[4,5,6],[7,8,9]], k = 2
        输出：[[45,45,45],[45,45,45],[45,45,45]]
         

        提示：

        m == mat.length
        n == mat[i].length
        1 <= m, n, k <= 100
        1 <= mat[i][j] <= 100*/

public class _29_矩阵区域和 {
    /*
    * 这道题的其实是二维前缀和的经典题，求矩阵和
    * 核心：result[i][j]其实是以(i-k,j-k)为左上角，(i+k,j+k)为右下角的矩阵元素之和
    * 动态规划：dp[i+1][j+1]表示(0,0)为左上角，(i,j)为右下角的矩阵元素之和
    * 至于i+1和j+1，是dp数组多了两层填充0，防止数组越界、边界问题
    * 公式推导：二维前缀和  https://dowalle.gitbook.io/algo/algorithm/2-suan-fa-ji-chu/5-qian-zhui-he
    * */
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int n=mat.length,m=mat[0].length;
        int[][] dp= new int[n+1][m+1];
        for (int i=0;i<n;i++){
            for (int j = 0; j < m; j++) {
                dp[i+1][j+1]=dp[i][j+1]+dp[i+1][j]+mat[i][j]-dp[i][j];
            }
        }
        int[][] result=new int[n][m];

        /*
        * 每个dp[i][j]都是以(i-k,j-k)为左上角，(i+k,j+k)为右下角的矩阵元素之和
        * 根据公式计算得出
        * */
        for (int i=0;i<n;i++){
            for (int j = 0; j < m; j++) {
                /*
                * 这里都+1是为了适配dp数组
                * */
                int x1=Math.max(0,j-k)+1;
                int y1=Math.max(0,i-k)+1;
                int x2=Math.min(m-1,j+k)+1;
                int y2=Math.min(n-1,i+k)+1;
                result[i][j]=dp[y2][x2]-dp[y2][x1-1]-dp[y1-1][x2]+dp[y1-1][x1-1];
            }
        }
        return result;
    }
}
