package 动态规划;
//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
//
//        机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
//
//        问总共有多少条不同的路径？
//
//         
//
//        示例 1：
//
//
//        输入：m = 3, n = 7
//        输出：28
//        示例 2：
//
//        输入：m = 3, n = 2
//        输出：3
//        解释：
//        从左上角开始，总共有 3 条路径可以到达右下角。
//        1. 向右 -> 向右 -> 向下
//        2. 向右 -> 向下 -> 向右
//        3. 向下 -> 向右 -> 向右
//        示例 3：
//
//        输入：m = 7, n = 3
//        输出：28
//        示例 4：
//
//        输入：m = 3, n = 3
//        输出：6
//         
//
//        提示：
//
//        1 <= m, n <= 100
//        题目数据保证答案小于等于 2 * 109
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/unique-paths
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class 不同路劲 {
    //动态规划：
    //1.状态：dp[i][j]表示到达这个节点的路径数
    //2.根据题目要求，每次移动只能往下或者往右移动一步
    //到达一个节点的路劲必须是从他正上方或正左方移动过来；
    // ，因此可得，状态转移方程:
    // 当i>0&&j>0时，dp[i][j]=dp[i-1][j]+dp[i][j-1]
    //当i=0时，dp[i][j]=dp[i][j-1]
    //当j=0时，dp[i][j]=dp[i-1][j]
    //3.初始条件：dp[0][0]
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
        //初始条件
        dp[0][0]=1;
        for (int i=0;i<dp.length;i++){
            int a=0;
            if (i==0){
                a=1;
            }
            for (int j=a;j<n;j++){
                if (i==0){
                    dp[i][j]=dp[i][j-1];
                    continue;
                }
                else if (j==0){
                    dp[i][j]=dp[i-1][j];
                    continue;
                }
                else {
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        //返回右下角元素
        return dp[m-1][n-1];
    }

    //过了两个月后，上面的代码看不懂了，写的好垃圾啊，上面的代码
    public int uniquePathsBest(int m, int n) {
        int[][] dp=new int[m][n];
        //初始条件
        dp[0][0]=1;
        for (int i=0;i<dp.length;i++){
            dp[i][0]=1;
        }
        for (int i=0;i<dp[0].length;i++){
            dp[0][i]=1;
        }
        for (int i=1;i<dp.length;i++){
            for (int j=1;j<dp[0].length;j++){
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }

        //返回右下角元素
        return dp[m-1][n-1];
    }
}
