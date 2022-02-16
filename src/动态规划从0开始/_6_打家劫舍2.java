package 动态规划从0开始;
/*你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。

        给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。

         

        示例 1：

        输入：nums = [2,3,2]
        输出：3
        解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
        示例 2：

        输入：nums = [1,2,3,1]
        输出：4
        解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
             偷窃到的最高金额 = 1 + 3 = 4 。
        示例 3：

        输入：nums = [1,2,3]
        输出：3*/
public class _6_打家劫舍2 {
    /*
    * 动态规划
    * 因为首尾房子不能同时盗，因此可以盗取的房子情况有两种
    * 1.盗取0到i-2的房子
    * 2.盗取1到i-1的房子
    * 然后比较两种情况哪种盗的金额最高。
    * */
    public int rob(int[] nums) {
        if (nums.length==1){
            return nums[0];
        }
        int result1=getResult(nums,0);
        int result2=getResult(nums,1);
        return Math.max(result1,result2);
    }

    private int getResult(int[] nums, int begin) {
        int[] dp=new int[nums.length];
        dp[0]=0;
        dp[1]=nums[begin];
        for (int i=2;i<nums.length;i++){
            dp[i]=Math.max(dp[i-2]+nums[begin+i-1],dp[i-1]);
        }
        return dp[nums.length-1];
    }

    /*
    * 空间优化
    * */
    public int dynacticBetter(int[] nums,int start){
        int one=0;
        int two=nums[start];
        int now=two;
        for (int i=2;i<nums.length;i++){
            now=Math.max(two,one+nums[i-1+start]);
            one=two;
            two=now;
        }
        return now;
    }
}
