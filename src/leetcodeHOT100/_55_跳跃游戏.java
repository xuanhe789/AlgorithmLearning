package leetcodeHOT100;
//知耻而后勇，知弱而图强
//给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
//
//        数组中的每个元素代表你在该位置可以跳跃的最大长度。
//
//        判断你是否能够到达最后一个下标。
//
//         
//
//        示例 1：
//
//        输入：nums = [2,3,1,1,4]
//        输出：true
//        解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
//        示例 2：
//
//        输入：nums = [3,2,1,0,4]
//        输出：false
//        解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
//         
//
//        提示：
//
//        1 <= nums.length <= 3 * 104
//        0 <= nums[i] <= 105
public class _55_跳跃游戏 {
    //不容易，这道题自己想出来了，不是最优解，虽然执行用时只击败了10%
    //定义一个dp数组记录每个下标标的状态
    //dp[i]=true表示下标为i的位置最终可以到达最后一个位置
    //从最后一个元素开始遍历，从后往前逐渐判断dp[i]的值
    //如果!dp[i]，说明i下标到达不了最后一个位置，就没必要以i为终点再去遍历了
    //如果nums[j]>=i-j，说明可以从下标j处到达下标i处，dp[j]=true
    //如果dp[i]并且i=0，说明第一个元素能够到达最后一个元素，返回true
    public boolean canJump(int[] nums) {
        if (nums.length==1){
            return true;
        }
        boolean[] dp=new boolean[nums.length];
        dp[dp.length-1]=true;
        for (int i=dp.length-1;i>=0;i--){
            if (!dp[i]){
                continue;
            }
            for (int j=0;j<i;j++){
                if (nums[j]>=i-j){
                    dp[j]=true;
                }
                if (dp[j]&&j==0){
                    return true;
                }
            }
        }
        return false;
    }
    //基于第一种的优化，但是执行时间更慢了，此处，智商减一，疑惑加一
    public boolean canJump2(int[] nums) {
        if (nums.length==1){
            return true;
        }
        boolean[] dp=new boolean[nums.length];
        dp[dp.length-1]=true;
        for (int i=dp.length-1;i>=0;i--){
            if (!dp[i]){
                continue;
            }
            for (int j=i-1;j>=0;j--){
                if (dp[j]){
                    i=j+1;
                    break;
                }
                if (nums[j]>=i-j){
                    dp[j]=true;
                }
                if (dp[j]&&j==0){
                    return true;
                }
            }
        }
        return false;
    }
}
