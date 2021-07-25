package 动态规划;

public class _1_零一背包问题 {
    //零一背包问题原题，动态规划，从前往后计算
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
        }

        for (int i=1;i<dp.length;i++){
            for (int j=0;j<=capacity;j++){
                dp[i][j]=dp[i - 1][j];
                if (weight[i]<=j) {
                    dp[i][j] = Math.max(dp[i - 1][j],dp[i-1][j-weight[i]]+values[i] );
                }
            }
        }

        return dp[weight.length-1][capacity];
    }

    //动态规划空间优化，从后往前计算，利用上一次的结果，优化空间
    //dp只存储在选择上一个物品时，在各个容量下的最大价值
    // 计算当前物品的dp[j]，跟上一个物品的dp[j]和dp[j-weight[i]]有关，所以为了不影响dp[j-1]的计算，需要从右往左计算
    //画个二维表格就很好理解
    public static int packageProblemBetter(int[] weight, int[] values,int capacity){
        if (weight.length==1&&weight[0]<capacity){
            return values[0];
        }
        //dp[j]表示背包容量为j时，所达到的最大价值，只保存上一次的结果，这个dp数组存储的结果跟当前选择的物品有关
        int[] dp=new int[capacity+1];
        //下面这段循环的意思是第一个物品在各个容量的背包中是否能放下
        //相当于初始化
        for (int i=0;i<=capacity;i++){
            if (weight[0]<=i){
                dp[i]=values[0];
            }
        }

        for (int i=1;i<weight.length;i++){
            for (int j=capacity;j>=weight[i];j--){
                //这个判断是多余的，因为进入循环代码块的条件是j>=weight[i],也就是weight[i]<=j，但是为了好理解还是加上，
                if (weight[i]<=j) {
                    //这里的dp[j-weight[i]]其实是上一次的第i-1个物品的计算结果
                    dp[j] = Math.max(dp[j],dp[j-weight[i]]+values[i] );
                }
            }
        }

        return dp[capacity];
    }

    public static void main(String[] args) {
        int weight[]= {2,3,4,5};
        int value[]= {3,4,5,7};
        int maxweight = 9;
        int i = packageProblem(weight, value, maxweight);
        System.out.println(i);
    }
}
