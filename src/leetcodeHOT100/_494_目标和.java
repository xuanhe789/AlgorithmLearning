package leetcodeHOT100;
//给你一个整数数组 nums 和一个整数 target 。
//
//        向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
//
//        例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
//        返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
//
//         
//
//        示例 1：
//
//        输入：nums = [1,1,1,1,1], target = 3
//        输出：5
//        解释：一共有 5 种方法让最终目标和为 3 。
//        -1 + 1 + 1 + 1 + 1 = 3
//        +1 - 1 + 1 + 1 + 1 = 3
//        +1 + 1 - 1 + 1 + 1 = 3
//        +1 + 1 + 1 - 1 + 1 = 3
//        +1 + 1 + 1 + 1 - 1 = 3
//        示例 2：
//
//        输入：nums = [1], target = 1
//        输出：1
//         
//
//        提示：
//
//        1 <= nums.length <= 20
//        0 <= nums[i] <= 1000
//        0 <= sum(nums[i]) <= 1000
//        -1000 <= target <= 1000
public class _494_目标和 {
    //动态规划：和0-1背包问题很像，0-1背包问题是某个物品选或者不选
    //而这个问题是某个数是+或者-
    //dp[i][j]表示由nums数组中前i+1个数组进行加减得到数值j的表达式数量
    //sum是数组中所有数的综合，数值j的界限是[-sum,+sum]，由于数组的下标只能从0开始，所以数组的长度为2*sum+1
    //下标0代表[-sum,+sum]中的-sum,下标sum代表[-sum,+sum]中的0，下标2sum代表[-sum,+sum]中的sum
    //状态转移方程：dp[i][j]=dp[i-1][j-nums[i]]+dp[i-1][j+nums[i]];
    //初始化，第一个树只能组成-num[0]和nums[0]，因此dp[0][sum-nums[0]]+=1;    dp[0][sum+nums[0]]+=1;
    public int findTargetSumWaysDP(int[] nums, int target) {
        //1.求所有数zhihe
        int sum=0;
        for (int num : nums) {
            sum+=num;
        }
        //如果总数之和小于目标数，那么肯定返回结果为0
        if (sum<target){
            return 0;
        }
        int length=nums.length;
        int[][] dp=new int[length][2*sum+1];
        //初始化，第一个数能组成的值，为-nums[0]和num[0]
        dp[0][sum-nums[0]]+=1;
        dp[0][sum+nums[0]]+=1;
        for (int i=1;i<length;i++){
            for (int j=0;j<2*sum+1;j++){
                //j-nums[i]超出了所有数之和负数的的范围，只能由+得到
                if (j-nums[i]<0){
                    dp[i][j]=dp[i-1][j+nums[i]];
                    //j+nums[i]超出了所有数之和正数的的范围，只能由-得到
                }else if (j+nums[i]>2*sum){
                    dp[i][j]=dp[i-1][j-nums[i]];
                }
                else {
                    dp[i][j]=dp[i-1][j-nums[i]]+dp[i-1][j+nums[i]];
                }
            }
        }
        return dp[length-1][sum+target];
    }

    //回溯法，相当简单，数组中每个数只有加和减两种情况，直接回溯法，暴力递归解决。
    int result=0;
    public int findTargetSumWays(int[] nums, int target) {
        dfs(nums,target,0);
        return result;
    }

    private void dfs(int[] nums, int target, int index) {
        if (index==nums.length&&target==0){
            result++;
            return;
        }
        if (index==nums.length){
            return;
        }
        dfs(nums,target-nums[index],index+1);
        dfs(nums,target+nums[index],index+1);
    }


}
