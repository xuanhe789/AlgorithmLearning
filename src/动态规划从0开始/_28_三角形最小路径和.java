package 动态规划从0开始;

import java.util.List;

public class _28_三角形最小路径和 {
    /*
    * 动态规划，自三角形的底下往上计算，比自顶向下计算少了很多判断
    * dp[i][j]=Math.min(dp[i+1][j],dp[i+1][j+1])+
    * */
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp=new int[triangle.size()+1][triangle.size()+1];
        for (int i=triangle.size()-1;i>=0;i--){
            for (int j=0;j<triangle.get(i).size();j++){
                dp[i][j]=Math.min(dp[i+1][j],dp[i+1][j+1])+triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }

    /*
    * 空间优化
    * */
    public int minimumTotalBest(List<List<Integer>> triangle) {
        int[] dp=new int[triangle.size()+1];
        for (int i=triangle.size()-1;i>=0;i--){
            for (int j=0;j<triangle.get(i).size();j++){
                dp[j]=Math.min(dp[j],dp[j+1])+triangle.get(i).get(j);
            }
        }
        return dp[0];
    }

    /*
    * 自顶向下解法
    * */
    public int minimumTotalTopToBottom(List<List<Integer>> triangle) {
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
}
