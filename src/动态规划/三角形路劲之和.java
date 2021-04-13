package 动态规划;

import java.util.List;

public class 三角形路劲之和 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp=new int[triangle.size()+1][triangle.size()+1];
        for (int i=triangle.size();i>=0;i--){
            for (int j=0;j<triangle.get(i).size();j++){
                dp[i][j]=Math.min(dp[i+1][j],dp[i+1][j+1])+triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }


}
