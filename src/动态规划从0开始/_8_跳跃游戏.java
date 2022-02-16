package 动态规划从0开始;
/*给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。

        数组中的每个元素代表你在该位置可以跳跃的最大长度。

        判断你是否能够到达最后一个下标。

         

        示例 1：

        输入：nums = [2,3,1,1,4]
        输出：true
        解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
        示例 2：

        输入：nums = [3,2,1,0,4]
        输出：false
        解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。*/
public class _8_跳跃游戏 {
    /*
    * 动态规划，这道题后面的状态由前面的状态提前决定，也就是第i位置能否到达，由i前面能到达的位置计算出来的
    * dp[i]表示第i个位置能否到达，由前面的状态提前计算出来
    * */
    public boolean canJump(int[] nums) {
        if (nums.length==1){
            return true;
        }
        boolean[] dp = new boolean[nums.length];
        dp[0]=true;
        for (int i = 0; i < dp.length; i++) {
            if(dp[i]){
                arrive(dp,i,nums[i]);
            }else{
                return false;
            }

        }
        return dp[nums.length-1];
    }

    private void arrive(boolean[] dp, int begin, int num) {
        for (int i = 1; i <=num; i++) {
            if(begin+i<=dp.length-1){
                dp[begin+i]=true;
            }else{
                return;
            }
        }
    }
}
