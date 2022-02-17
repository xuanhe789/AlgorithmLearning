package 动态规划从0开始;
/*给定一个长度为 n 的环形整数数组 nums ，返回 nums 的非空 子数组 的最大可能和 。

        环形数组 意味着数组的末端将会与开头相连呈环状。形式上， nums[i] 的下一个元素是 nums[(i + 1) % n] ， nums[i] 的前一个元素是 nums[(i - 1 + n) % n] 。

        子数组 最多只能包含固定缓冲区 nums 中的每个元素一次。形式上，对于子数组 nums[i], nums[i + 1], ..., nums[j] ，不存在 i <= k1, k2 <= j 其中 k1 % n == k2 % n 。

         

        示例 1：

        输入：nums = [1,-2,3,-2]
        输出：3
        解释：从子数组 [3] 得到最大和 3
        示例 2：

        输入：nums = [5,-3,5]
        输出：10
        解释：从子数组 [5,5] 得到最大和 5 + 5 = 10
        示例 3：

        输入：nums = [3,-2,2,-3]
        输出：3
        解释：从子数组 [3] 和 [3,-2,2] 都可以得到最大和 3*/
public class _11_环形子数组的最大和 {
    /*
    * 动态规划，这道题分两种情况
    * 1.第一种情况：最大子数组在数组的中间，那么解法和【53.最大子数组之和一致】,不过多阐述
    * 2.第二种情况：最大子数组在由数组的两端组成，那么此时的最大子数组为数组的总和SUM-最小的子数组
    * 论证1：最大子数组两端一定是正数
    * 论证2：最小子数组的两端一定是负数
    * 论证3：最大子数组在数组的两端，那么最小子数组一定在数组的中间
    * 论证4：整个数组的和 = 最大子数组的和 + 最小子数组的和
    *
    * maxDp[i]表示以num[i]结尾的最大子数组之和
    * minDp[i]表示以num[i]结尾的最小子数组之和
    * */
    public int maxSubarraySumCircular(int[] nums) {
        if (nums.length==1){
            return nums[0];
        }
        int[] maxDp=new int[nums.length];
        int[] minDp=new int[nums.length];
        int sum=nums[0];
        int max=sum;
        int min=sum;
        maxDp[0]=sum;
        minDp[0]=sum;
        for (int i = 1; i < nums.length; i++) {
            maxDp[i]=Math.max(maxDp[i-1]+nums[i],nums[i]);
            max=Math.max(max,maxDp[i]);
            minDp[i]=Math.min(minDp[i-1]+nums[i],nums[i]);
            min=Math.min(min,minDp[i]);
            sum+=nums[i];
        }
        return Math.max(max,sum-min==0?max:sum-min);
    }

    /*
    * 空间优化
    * */
    public int maxSubarraySumCircularBest(int[] nums) {
        if (nums.length==1){
            return nums[0];
        }
        int sum=nums[0];
        int max=sum;
        int min=sum;
        int curMax=sum;
        int curMin=sum;
        for (int i = 1; i < nums.length; i++) {
            curMax=Math.max(curMax+nums[i],nums[i]);
            max=Math.max(max,curMax);
            curMin=Math.min(curMin+nums[i],nums[i]);
            min=Math.min(min,curMin);
            sum+=nums[i];
        }
        return Math.max(max,sum-min==0?max:sum-min);
    }
}
