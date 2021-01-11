import java.util.HashMap;

//输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
//
//         
//
//        示例 1：
//
//        输入：nums = [2,7,11,15], target = 9
//        输出：[2,7] 或者 [7,2]
//        示例 2：
//
//        输入：nums = [10,26,30,31,47,60], target = 40
//        输出：[10,30] 或者 [30,10]
//         
//
//        限制：
//
//        1 <= nums.length <= 10^5
//        1 <= nums[i] <= 10^6
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class 和为s的两个数字 {
    //HashMap解法，空间复杂度为O(n)
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<nums.length;i++){
            if (map.containsKey(target-nums[i])){
                return new int[]{i,map.get(target-nums[i])};
            }
            map.put(nums[i],i);
        }
        return new int[]{};
    }

    //双指针解法，空间复杂度O(1)
    public int[] twoSum2(int[] nums, int target) {
        int left=0,right=nums.length-1;
        while (left<right){
            if (nums[left]+nums[right]==target){
                return new int[]{nums[left],nums[right]};
            }
            else if (nums[left]+nums[right]>target){
                right--;
            }
            else {
                left++;
            }
        }
        return new int[]{};
    }
}
