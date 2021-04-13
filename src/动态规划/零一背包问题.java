package 动态规划;

public class 零一背包问题 {
    //零一背包问题原题
    public static int packageProblem(int[] weight, int[] values,int capacity){
        if (weight.length==1&&weight[0]<capacity){
            return values[0];
        }
        //dp[i][j]表示第i个物品，背包容量为j时，所达到的最大价值
        int[][] dp=new int[weight.length][capacity+1];
        //下面这段循环的意思是第一个物品在各个容量的背包中是否能放下
        //相当于初始化
        for (int i=0;i<=capacity;i++){
            if (weight[0]<=i){
                dp[0][i]=values[0];
            }
            else {
                dp[0][i]=0;
            }
        }

        for (int i=1;i<dp.length;i++){
            for (int j=0;j<=capacity;j++){
                if (weight[i]<=j) {
                    dp[i][j] = Math.max(dp[i - 1][j],dp[i-1][j-weight[i]]+values[i] );
                }
            }
        }

        return dp[weight.length-1][capacity];
    }

    public static void main(String[] args) {
        int weight[]= {2,3,4,5};
        int value[]= {3,4,5,7};
        int maxweight = 9;
        int i = packageProblem(weight, value, maxweight);
        System.out.println(i);
    }
}
