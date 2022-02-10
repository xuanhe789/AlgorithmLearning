package 动态规划;
/*问题：有一堆石头，每块石头的重量都是正整数。每次从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x ≤ y。那么粉碎的可能结果如下：

        如果 x 与 y 相等，那么两块石头都会被完全粉碎；
        否则，重量为 x 的石头将会完全粉碎，而重量为 y 的石头的新重量为 y - x。
        最后，最多只会剩下一块石头。返回此时石头最小的可能重量。如果没有石头剩下，就返回 0。*/
public class _3_零一背包延伸_碎石头 {
    public int stonesProblem(int[] stonesWeight){
        if (stonesWeight.length==1){
            return stonesWeight[0];
        }
        //计算总重量的一半
        int total = 0;
        for (int i : stonesWeight) {
            total+=i;
        }
        int half = total/2;
        //dp[i][j]表示前i个石头的重量所能组合成的最大
        int[][] dp=new int[stonesWeight.length][half+1];
        //初始化
        dp[0][0]=0;
        for (int i = 1; i < half+1; i++) {
            if (i>=stonesWeight[0]){
                dp[0][i]=stonesWeight[0];
            }
        }

        for (int i=1; i<stonesWeight.length;i++){
            for (int j=1;j<half+1;j++){
                dp[i][j] = dp[i-1][j];
                if (stonesWeight[i]<=j){
                    dp[i][j]=Math.min(dp[i-1][j],dp[i-1][j-stonesWeight[i]]+stonesWeight[i]);
                }
            }
        }
        return half-dp[stonesWeight.length-1][half];
    }

    public int lastStoneWeightII(int[] stones) {
        if (stones.length==1){
            return stones[0];
        }
        //计算总重量的一半
        int total = 0;
        for (int i : stones) {
            total+=i;
        }
        int half = total/2;
        //dp[i][j]表示前i个石头的重量所能组合成的最大
        int[][] dp=new int[stones.length][half+1];
        //初始化
        dp[0][0]=0;
        for (int i = 1; i < half+1; i++) {
            if (i>=stones[0]){
                dp[0][i]=stones[0];
            }
        }

        for (int i=1; i<stones.length;i++){
            for (int j=1;j<half+1;j++){
                dp[i][j] = dp[i-1][j];
                if (stones[i]<=j){
                    dp[i][j]=Math.min(dp[i-1][j],dp[i-1][j-stones[i]]+stones[i]);
                }
            }
        }
        return half-dp[stones.length-1][half];
    }
}
