package 动态规划;
//给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
//
//        说明：每次只能向下或者向右移动一步。
//
//         
//
//        示例 1：
//
//
//        输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
//        输出：7
//        解释：因为路径 1→3→1→1→1 的总和最小。
//        示例 2：
//
//        输入：grid = [[1,2,3],[4,5,6]]
//        输出：12
//         
//
//        提示：
//
//        m == grid.length
//        n == grid[i].length
//        1 <= m, n <= 200
//        0 <= grid[i][j] <= 100
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/minimum-path-sum
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class 最小路劲和 {
    //动态规划，思路和不同路劲差不多
    //状态转移方程
    // 当i=0时，dp[i][j]=dp[i][j-1]+grid[i][j];
    // 当j=0时， dp[i][j]=dp[i-1][j]+grid[i][j];
    // 当i>0&j>0时，dp[i][j]=Math.min(dp[i][j-1],dp[i-1][j])+grid[i][j];
    public int minPathSum(int[][] grid) {
        if (grid.length==1&&grid[0].length==1){
            return grid[0][0];
        }
        int[][] dp=new int[grid.length][grid[0].length];
        //初始化
        dp[0][0]=grid[0][0];
        for (int i=0;i<dp.length;i++){
            int a=0;
            if (i==0){
                a=1;
            }
            for (int j=a;j<dp[0].length;j++){
                if (i==0){
                    dp[i][j]=dp[i][j-1]+grid[i][j];
                }
                else if (j==0){
                    dp[i][j]=dp[i-1][j]+grid[i][j];
                }
                else {
                    dp[i][j]=Math.min(dp[i][j-1],dp[i-1][j])+grid[i][j];
                }
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }
}
