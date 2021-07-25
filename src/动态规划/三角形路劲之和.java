package 动态规划;

import java.util.List;
//知耻而后勇，知弱而图强
//给定一个三角形 triangle ，找出自顶向下的最小路径和。
//
//        每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
//
//
//
//        示例 1：
//
//        输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
//        输出：11
//        解释：如下面简图所示：
//        2
//        3 4
//        6 5 7
//        4 1 8 3
//        自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
//        示例 2：
//
//        输入：triangle = [[-10]]
//        输出：-10
//
//
//        提示：
//
//        1 <= triangle.length <= 200
//        triangle[0].length == 1
//        triangle[i].length == triangle[i - 1].length + 1
//        -104 <= triangle[i][j] <= 104
public class 三角形路劲之和 {
    //动态规划，从下往上计算
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp=new int[triangle.size()+1][triangle.size()+1];
        for (int i=triangle.size();i>=0;i--){
            for (int j=0;j<triangle.get(i).size();j++){
                dp[i][j]=Math.min(dp[i+1][j],dp[i+1][j+1])+triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }
    //空间优化，dp数组只存储上一次的计算结果，因为dp[i]跟上一次计算结果的dp[i]和dp[i+1]有关，为了不影响dp[i+1]的值，从左往右计算
    //和0-1背包的空间优化很像，其实画个二维表格出来很好理解
    public int minimumTotalBest(List<List<Integer>> triangle) {
        if (triangle.size()==1){
            return triangle.get(0).get(0);
        }
        int[] dp=new int[triangle.size()+1];
        for (int i=triangle.size()-1;i>=0;i--){
            List<Integer> list = triangle.get(i);
            for (int j=0;j<list.size();j++){
                dp[j]=Math.min(dp[j],dp[j+1])+list.get(j);
            }
        }
        return dp[0];

    }

    //动态规划：从上往下
    public int minimumTotal3(List<List<Integer>> triangle) {
        if (triangle.size()==1){
            return triangle.get(0).get(0);
        }
        int[][] dp=new int[triangle.size()][triangle.size()];
        dp[0][0]=triangle.get(0).get(0);
        for (int i=1;i<dp.length;i++){
            List<Integer> list = triangle.get(i);
            for (int j=0;j<i+1;j++){
                if (j==0){
                    dp[i][j]=dp[i-1][j]+list.get(j);
                }else if (j==i){
                    dp[i][j]=dp[i-1][j-1]+list.get(j);
                }else {
                    dp[i][j]=Math.min(dp[i-1][j-1],dp[i-1][j])+list.get(j);
                }
            }
        }
        int min=Integer.MAX_VALUE;
        for (int i : dp[dp.length - 1]) {
            if (i<min){
                min=i;
            }
        }
        return min;
    }

    //动态规划：从上往下，空间优化
    public int minimumTotal4(List<List<Integer>> triangle) {
        if (triangle.size()==1){
            return triangle.get(0).get(0);
        }
        int[] dp=new int[triangle.size()];
        dp[0]=triangle.get(0).get(0);
        for (int i=1;i<dp.length;i++){
            List<Integer> list = triangle.get(i);
            for (int j=i;j>=0;j--){
                if (j==0){
                    dp[j]=dp[j]+list.get(j);
                }else if (j==i){
                    dp[j]=dp[j-1]+list.get(j);
                }else {
                    dp[j]=Math.min(dp[j-1],dp[j])+list.get(j);
                }
            }
        }
        int min=Integer.MAX_VALUE;
        for (int i : dp) {
            if (i<min){
                min=i;
            }
        }
        return min;
    }

    //经典的动态规划，再做一遍
    public int minimumTotal2(List<List<Integer>> triangle) {
        if (triangle.size()==1){
            return triangle.get(0).get(0);
        }
        int[][] dp=new int[triangle.size()+1][triangle.size()+1];
        for (int i=triangle.size()-1;i>=0;i--){
            List<Integer> list = triangle.get(i);
            for (int j=0;j<i+1;j++){
                dp[i][j]=Math.min(dp[i+1][j],dp[i+1][j+1])+list.get(j);
            }
        }
        return dp[0][0];
    }


}
