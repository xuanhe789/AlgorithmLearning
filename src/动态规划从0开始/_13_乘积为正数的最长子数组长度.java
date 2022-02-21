package 动态规划从0开始;
/*给你一个整数数组 nums ，请你求出乘积为正数的最长子数组的长度。

        一个数组的子数组是由原数组中零个或者更多个连续数字组成的数组。

        请你返回乘积为正数的最长子数组长度。

         

        示例  1：

        输入：nums = [1,-2,-3,4]
        输出：4
        解释：数组本身乘积就是正数，值为 24 。
        示例 2：

        输入：nums = [0,1,-2,-3,-4]
        输出：3
        解释：最长乘积为正数的子数组为 [1,-2,-3] ，乘积为 6 。
        注意，我们不能把 0 也包括到子数组中，因为这样乘积为 0 ，不是正数。
        示例 3：

        输入：nums = [-1,-2,-3,0,1]
        输出：2
        解释：乘积为正数的最长子数组是 [-1,-2] 或者 [-2,-3] 。*/
public class _13_乘积为正数的最长子数组长度 {
    /*
    * 动态规划，分别记录以当前位置结尾的【最大正数子数组之和】的长度以及【最大负数子数组之和】的长度
    * 当前元素<0，最小正数和最大正数长度互换
    * */
    public int getMaxLen(int[] nums) {
        if (nums.length==1){
            return nums[0]>0?1:0;
        }
        int curMinLength=0;
        int curMaxLength=0;
        int maxLength=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]<0){
                int temp=curMaxLength;
                curMaxLength=curMinLength==0?0:curMinLength+1;
                curMinLength=temp==0?1:temp+1;
            }
            else if (nums[i]>0){
                curMaxLength++;
                curMinLength=curMinLength==0?0:curMinLength+1;
            }else {
                curMaxLength=0;
                curMinLength=0;
            }
            maxLength=Math.max(maxLength,curMaxLength);
        }
        return maxLength;
    }
}
