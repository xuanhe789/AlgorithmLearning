package 数组中等;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
//
//        注意：答案中不可以包含重复的三元组。
//        链接：https://leetcode-cn.com/problems/3sum
public class 三数之和 {
    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        if (nums.length<3||nums==null){
            return lists;
        }
        Arrays.sort(nums);
        for (int i=0;i<nums.length-1;i++){
            if (nums[i]>0) break;
            //如果两个数相同，则可能产生两个相同的结果
            if (nums[i]==nums[i-1]&&i>0) continue;
            int left=i+1;
            int right=nums.length-1;
            while (left<right){
                if (nums[i]+nums[left]+nums[right]==0){
                    List<Integer> list = Arrays.asList(nums[i], nums[left], nums[right]);
                    lists.add(list);
                    while (left<right&&nums[left]==nums[left+1]){
                        left++;
                    }
                    while (left<right&&nums[right]==nums[right-1]){
                        right--;
                    }
                    left++;
                    right--;
                }
                else if (nums[i]+nums[left]+nums[right]>0){
                    right--;
                }
                else {
                    left++;
                }
            }
        }
        return lists;
    }
}
