package 动态规划从0开始;
/*如果一个数列 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该数列为等差数列。

        例如，[1,3,5,7,9]、[7,7,7,7] 和 [3,-1,-5,-9] 都是等差数列。
        给你一个整数数组 nums ，返回数组 nums 中所有为等差数组的 子数组 个数。

        子数组 是数组中的一个连续序列。

         

        示例 1：

        输入：nums = [1,2,3,4]
        输出：3
        解释：nums 中有三个子等差数组：[1, 2, 3]、[2, 3, 4] 和 [1,2,3,4] 自身。
        示例 2：

        输入：nums = [1]
        输出：0
         

        提示：

        1 <= nums.length <= 5000
        -1000 <= nums[i] <= 1000*/

public class _21_等差数列划分 {
    /*
    * 动态规划，dp[i]表示以i位置元素结尾的子数组长度
    * 当子数组长度为i(i>=3)时，那么符合题意子数组的个数为(3-2)+(4-2)+...+(i-2)
    * */
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length<3){
            return 0;
        }
        int[] dp = new int[nums.length];
        int result=0;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i]-nums[i-1] == nums[i-1]-nums[i-2]){
                dp[i]=dp[i-1]==0?3:dp[i-1]+1;
                result+=dp[i]-2;
            }
        }
        return result;
    }

    /*
    * 空间优化
    * */
    public int numberOfArithmeticSlicesBest(int[] nums) {
        if (nums.length<3){
            return 0;
        }
        int result=0;
        int arrLength=0;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i]-nums[i-1] == nums[i-1]-nums[i-2]){
                arrLength=arrLength==0?3:arrLength+1;
                result+=arrLength-2;
            }else {
                arrLength=0;
            }
        }
        return result;
    }
}
