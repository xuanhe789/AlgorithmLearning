package leetcode周赛;
//知耻而后勇，知弱而图强
//给你一个大小为 m x n 的整数矩阵 mat 和一个整数 target 。
//
//        从矩阵的 每一行 中选择一个整数，你的目标是 最小化 所有选中元素之 和 与目标值 target 的 绝对差 。
//
//        返回 最小的绝对差 。
//
//        a 和 b 两数字的 绝对差 是 a - b 的绝对值。
//
//         
//
//        示例 1：
//
//
//
//        输入：mat = [[1,2,3],[4,5,6],[7,8,9]], target = 13
//        输出：0
//        解释：一种可能的最优选择方案是：
//        - 第一行选出 1
//        - 第二行选出 5
//        - 第三行选出 7
//        所选元素的和是 13 ，等于目标值，所以绝对差是 0 。
public class _582_最小化目标值与所选元素的差_med {
    //动态规划，背包问题
    public int minimizeTheDifference(int[][] mat, int target) {
        //状态定义：dp[i][j]表示是否存在从前i行中，每行各取一个数，各数之和为j的情况，true为有，false为无
        //为了防止数组越界，直接将dp每行的元素定义为4901，因为题给出的限制为n最大为70，m为70
        boolean[][] dp=new boolean[mat.length][4900+1];
        //初始化，第一行，如果i等于某个数，则直接为true
        for (int i=1;i<dp[0].length;i++){
            for (int j=0;j<mat[0].length;j++){
                if (i==mat[0][j]){
                    dp[0][i]=true;
                }
            }
        }
        //三重循环，分别是两层dp+每行的元素遍历
        for (int i=1;i<dp.length;i++){
            for (int j=1;j<dp[0].length;j++){
                for (int k=0;k<mat[0].length;k++){
                    //如果数字大于j，则直接为false
                    if (j>mat[i][k]){
                        int num=mat[i][k];
                        dp[i][j]=dp[i-1][j-num];
                        //如果dp[i][j]为true了，说明存在数字之和为j，不需要往后继续遍历数字了
                        if (dp[i][j]){
                            break;
                        }
                    }
                }
            }
        }
        //从target位置开始搜索，寻找离target最近的值
        //举个例子：nums=[[1,2,7,8,9]],target=6，从dp[dp.length-1][6]的位置开始寻找，找不到
        //则往左右两端找,dp[dp.length-1][5],dp[dp.length-1][7]，7能找到，直接返回Math.abs(7-6)
        //总而言之，就是从target位置开始找，返回离target最近的值
        int result=0;
        while (true){
            if (target-result>0&&dp[dp.length-1][target-result]){
                return result;
            }else if (target+result<4901&&dp[dp.length-1][target+result]){
                return result;
            }else {
                result++;
            }
        }
    }

    //优化空间，其实我不知道算不算优化空间，因为每次都新建一个数组，其实不考虑过程中GC的话，空间是一样的
    public int minimizeTheDifferenceBetter(int[][] mat, int target) {
        //状态定义：dp[i][j]表示是否存在从前i行中，每行各取一个数，各数之和为j的情况，true为有，false为无
        //为了防止数组越界，直接将dp每行的元素定义为4901，因为题给出的限制为n最大为70，m为70
        boolean[] dp=new boolean[4900+1];
        //初始化，第一行，如果i等于某个数，则直接为true
        for (int i=1;i<dp.length;i++){
            for (int j=0;j<mat[0].length;j++){
                if (i==mat[0][j]){
                    dp[i]=true;
                }
            }
        }
        //三重循环，分别是两层dp+每行的元素遍历
        for (int i=1;i<mat.length;i++){
            boolean[] temp=new boolean[4900+1];
            for (int j=1;j<dp.length;j++){
                for (int k=0;k<mat[0].length;k++){
                    //如果数字大于j，则直接为false
                    if (j>mat[i][k]){
                        int num=mat[i][k];
                        temp[j]=dp[j-num];
                        //如果dp[i][j]为true了，说明存在数字之和为j，不需要往后继续遍历数字了
                        if (temp[j]){
                            break;
                        }
                    }
                }
            }
            dp=temp;
        }
        //从target位置开始搜索，寻找离target最近的值
        //举个例子：nums=[[1,2,7,8,9]],target=6，从dp[dp.length-1][6]的位置开始寻找，找不到
        //则往左右两端找,dp[dp.length-1][5],dp[dp.length-1][7]，7能找到，直接返回Math.abs(7-6)
        //总而言之，就是从target位置开始找，返回离target最近的值
        int result=0;
        while (true){
            if (target-result>0&&dp[target-result]){
                return result;
            }else if (target+result<4901&&dp[target+result]){
                return result;
            }else {
                result++;
            }
        }
    }
}
