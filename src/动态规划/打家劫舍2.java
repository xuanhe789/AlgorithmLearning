package 动态规划;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

//你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
//
//        给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额。
//
//         
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/house-robber-ii
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class 打家劫舍2 {
    public int rob(int[] nums) {
        if (nums.length==1){
            return nums[0];
        }
        int result1=dynactic(nums,0);
        int result2=dynactic(nums,1);
        return Math.max(result1,result2);
    }

    public int dynactic(int[] nums,int start){
        //dp[0]是等于0的，所以这个dp只能计算num.length-1个元素
        int[] dp=new int[nums.length];
        dp[0]=0;
        //从第0个或第一个开始
        dp[1]=nums[start];
        for (int i=2;i<nums.length;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i-1+start]);
        }
        return dp[dp.length-1];
    }
}
