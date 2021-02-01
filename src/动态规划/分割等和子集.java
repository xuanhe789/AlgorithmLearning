package 动态规划;
//给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
//
//        注意:
//
//        每个数组中的元素不会超过 100
//        数组的大小不会超过 200
//        示例 1:
//
//        输入: [1, 5, 11, 5]
//
//        输出: true
//
//        解释: 数组可以分割成 [1, 5, 5] 和 [11].
//         
//
//        示例 2:
//
//        输入: [1, 2, 3, 5]
//
//        输出: false
//
//        解释: 数组不能分割成两个元素和相等的子集.
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/partition-equal-subset-sum
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class 分割等和子集 {
    //动态规划，0-1背包问题，建议在纸上画个表格来看，更加清晰
    //1.状态定义：
    //dp[i][j]表示从区间[0,i]的元素中挑选出一些正整数，使他们的和为j
    //2.状态转移方程
    //如果i位置元素的值刚好等于j即num[i]==j，dp[i][j]=true
    //如果如果i位置元素的值小于j，此处分两种情况：
    //①不选择 nums[i]，如果在 [0, i - 1] 这个子区间内已经有一部分元素，使得它们的和为 j ，那么 dp[i][j] = true；
    // dp[i][j]=dp[i-1][j]
    //②选择 nums[i]，如果在 [0, i - 1] 这个子区间内就得找到一部分元素，使得它们的和为 j - nums[i]
    //dp[i][j]=dp[i-1][j-nums[i]]
    //两种情况综合起来的方程式为 dp[i][j]=dp[i-1][j] || dp[i-1][j-nums[i]];
    //3.初始化
    //dp[0][nums[0]]=nums[i]<=avg?true:false
    public boolean canPartition(int[] nums) {
        if (nums.length==0){
            return false;
        }
        int sum=0;
        for (int i:nums){
            sum+=i;
        }
        if (sum%2!=0){
            return false;
        }
        int avg=sum/2;
        boolean[][] dp=new boolean[nums.length][avg+1];
        if (nums[0]<=avg){
            dp[0][nums[0]]=true;
        }
        for (int i=1;i<dp.length;i++){
            for (int j=0;j<=avg;j++){
                if (nums[i]==j){
                    dp[i][j]=true;
                }
                if (nums[i]<j){
                    dp[i][j]=dp[i-1][j] || dp[i-1][j-nums[i]];
                }
            }
        }
        return dp[nums.length-1][avg];
    }

    //优化版本1
    public static boolean canPartition1(int[] nums) {
        if (nums.length==0){
            return false;
        }
        int sum=0;
        for (int i:nums){
            sum+=i;
        }
        if (sum%2!=0){
            return false;
        }
        int avg=sum/2;
        boolean[][] dp=new boolean[nums.length][avg+1];
        dp[0][0]=true;
        if (nums[0]<=avg){
            dp[0][nums[0]]=true;
        }
        for (int i=1;i<dp.length;i++){
            for (int j=0;j<=avg;j++){
                dp[i][j] = dp[i - 1][j];
                if (nums[i]<=j){
                    dp[i][j]=dp[i-1][j] || dp[i-1][j-nums[i]];
                }
            }
            if (dp[i][avg]){
                return true;
            }
        }
        return dp[nums.length-1][avg];
    }

    public boolean canPartitionBest(int[] nums) {
        if (nums.length==0){
            return false;
        }
        int sum=0;
        for (int i:nums){
            sum+=i;
        }
        if (sum%2!=0){
            return false;
        }
        int avg=sum/2;
        boolean[] dp=new boolean[avg+1];
        dp[0]=true;
        for (int i=0;i<nums.length;i++){
            for (int j=avg;j>=0;j--){
                if (nums[i]==j){
                    dp[j]=true;
                    continue;
                }
                if(nums[i]<=j) {
                    dp[j]=dp[j]||dp[j-nums[i]];
                }
            }
        }
        return dp[avg];
    }

    public static void main(String[] args) {
        int[] a={1,5,11,5};
        canPartition1(a);
    }
}
