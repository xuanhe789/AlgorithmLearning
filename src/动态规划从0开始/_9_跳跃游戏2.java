package 动态规划从0开始;

import java.util.Arrays;
/*给你一个非负整数数组 nums ，你最初位于数组的第一个位置。

        数组中的每个元素代表你在该位置可以跳跃的最大长度。

        你的目标是使用最少的跳跃次数到达数组的最后一个位置。

        假设你总是可以到达数组的最后一个位置。

         

        示例 1:

        输入: nums = [2,3,1,1,4]
        输出: 2
        解释: 跳到最后一个位置的最小跳跃数是 2。
             从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
        示例 2:

        输入: nums = [2,3,0,1,4]
        输出: 2*/

public class _9_跳跃游戏2 {
    /*
    * 动态规划，和跳跃游戏一样，后面的状态有前面的状态提前算好
    * dp[i]表示到达第i个位置的最小跳跃步数，初始值为Integer.MAX_VALUE
    * */
    public int jump(int[] nums) {
        if (nums.length==1){
            return 0;
        }
        int[] dp= new int[nums.length];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;

        //初始化
        for (int i = 1; i <=nums[0]; i++) {
            if(i<=dp.length-1){
                dp[i]=Math.min(dp[i],dp[0]+1);
            }else{
                break;
            }
        }

        for (int i = 1; i < dp.length; i++) {
            if (dp[i]!=Integer.MAX_VALUE){
                arrive(dp,i,nums[i]);
            }
        }
        return dp[nums.length-1];
    }

    private void arrive(int[] dp, int begin, int num) {
        for (int i = 1; i <=num; i++) {
            if(begin+i<=dp.length-1){
                dp[begin+i]=Math.min(dp[begin+i],dp[begin]+1);
            }else {
                return;
            }
        }
    }
}
