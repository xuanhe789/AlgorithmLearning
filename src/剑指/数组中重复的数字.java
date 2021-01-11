package 剑指;
//在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
//
//        示例 1：
//
//        输入：
//        [2, 3, 1, 0, 2, 5, 3]、[3,4,0,0]
//        输出：2 或 3
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class 数组中重复的数字 {
    //最佳解法，时间复杂度O(n),空间复杂度O(1)
    //思路，根据题意：在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
    //说明数组元素的索引和值是一对多的关系，通过交换操作，必然可以找到其中的一个重复的元素
    //代码思路：若 nums[i] = inums[i]=i ： 说明此数字已在对应索引位置，无需交换，因此跳过；
    //若 nums[nums[i]] = nums[i]nums[nums[i]]=nums[i] ： 代表索引 nums[i]nums[i] 处和索引 ii 处的元素值都为 nums[i]nums[i] ，即找到一组重复值，返回此值 nums[i]nums[i] ；
    //否则： 交换索引为 ii 和 nums[i]nums[i] 的元素值，将此数字交换至对应索引位置。
    public static int findRepeatNumber(int[] nums) {
        for (int i=0;i<nums.length;i++){
            if (nums[i]==i){
                continue;
            }
            else if (nums[nums[i]]==nums[i]){
                return nums[i];
            }
            else {
                int temp=nums[i];
                nums[i]=nums[nums[i]];
                nums[temp]=temp;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3});
    }
}
