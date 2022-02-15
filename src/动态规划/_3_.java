package 动态规划;
/*有一堆石头，用整数数组 stones 表示。其中 stones[i] 表示第 i 块石头的重量。

        每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：

        如果 x == y，那么两块石头都会被完全粉碎；
        如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
        最后，最多只会剩下一块 石头。返回此石头 最小的可能重量 。如果没有石头剩下，就返回 0。

         

        示例 1：

        输入：stones = [2,7,4,1,8,1]
        输出：1
        解释：
        组合 2 和 4，得到 2，所以数组转化为 [2,7,1,8,1]，
        组合 7 和 8，得到 1，所以数组转化为 [2,1,1,1]，
        组合 2 和 1，得到 1，所以数组转化为 [1,1,1]，
        组合 1 和 1，得到 0，所以数组转化为 [1]，这就是最优值。*/

public class _3_ {
    /*
    * 思路该问题可转化为求最接近的石头重量一半的石头组合，因为最小重量肯定是越靠近中间值，两批石头相减才最小
    * 因此该问题转化为动态规划的0-1背包问题，dp[i][j]表示【固定重量为j时，前i个石头所选组合最接近j的重量值】
    * 所有重量的一半表示0-1背包中的背包重量
    * 所选组合的重量值表示所选组合物品的最大价值
    * */
    public int lastStoneWeightII(int[] stones) {
        if (stones.length==1){
            return stones[0];
        }
        int total=0;
        for (int stone : stones) {
            total+=stone;
        }
        int half=total/2;
        int[][] dp=new int[stones.length][half+1];
        for (int i = 1; i <= half; i++) {
            if (stones[0]<=i){
                dp[0][i]=stones[0];
            }
        }

        for (int i=1;i<stones.length;i++){
            for (int j=1;j<=half;j++){
                dp[i][j]=dp[i-1][j];
                if (stones[i]<=j){
                    dp[i][j]=Math.min(dp[i-1][j],dp[i-1][j-stones[i]]+stones[i]);
                }
            }
        }
        return total-dp[stones.length-1][half]*2;
    }

    /*
    * 因为dp[i][j]只和dp[i-1][j]或者dp[i-1][j-stones[i]有关(上一层的前面元素)
    * 因此可以优化空间
    * */
    public int lastStoneWeightIIBetter(int[] stones) {
        if (stones.length==1){
            return stones[0];
        }
        int total=0;
        for (int stone : stones) {
            total+=stone;
        }
        int half=total/2;
        int[] dp=new int[half+1];
        for (int i = 1; i <= half; i++) {
            if (stones[0]<=i){
                dp[i]=stones[0];
            }
        }

        for (int i=1;i<stones.length;i++){
            for (int j=1;j<=half;j++){
                if (stones[i]<=j){
                    dp[j]=Math.max(dp[j],dp[j-stones[i]]+stones[i]);
                }
            }
        }
        return total-dp[half]*2;
    }
}
