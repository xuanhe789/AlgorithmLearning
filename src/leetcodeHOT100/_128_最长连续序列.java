package leetcodeHOT100;

import java.util.*;

//知耻而后勇，知弱而图强
//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
//
//         
//
//        进阶：你可以设计并实现时间复杂度为 O(n) 的解决方案吗？
//
//         
//
//        示例 1：
//
//        输入：nums = [100,4,200,1,3,2]
//        输出：4
//        解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
//        示例 2：
//
//        输入：nums = [0,3,7,2,5,8,4,6,0,1]
//        输出：9
//         
//
//        提示：
//
//        0 <= nums.length <= 104
//        -109 <= nums[i] <= 109
public class _128_最长连续序列 {
    //最简单做法，时间复杂度O(nlogn)，先排序，后遍历，
    //时间复杂度不符合题目要求
    public int longestConsecutive(int[] nums) {
        if (nums.length<2){
            return nums.length;
        }
        Arrays.sort(nums);
        int max=1,point=1;
        for (int i=1;i<nums.length;i++){
            if (nums[i]==nums[i-1]+1){
                point++;
            }else if (nums[i]!=nums[i-1]){
                point=1;
            }
            max=Math.max(point,max);
        }
        return max;
    }
    //使用空间换时间，用hash表进行存储所有的数据并去重
    //然后遍历数组，利用set来获取每个数的左边界和右边界，如当前数100，往左搜索左边界99、98、97...右边界也是这样
    public int longestConsecutive1(int[] nums) {
        if (nums.length<2){
            return nums.length;
        }
        Set<Integer> set=new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max=1;
        for (int num : nums) {
            if (set.remove(num)) {
                int left = num ;
                int right = num ;
                //找到这个元素的最左边界，如num=100，那么往左找99、98、97、96..直到找到不连续的为止
                while (set.contains(left-1)) {
                    set.remove(left);
                    left--;
                }
                //找到这个元素的最左边界，如num=100，那么往左找101、102、103....直到找到不连续的为止
                while (set.contains(right+1)) {
                    set.remove(right);
                    right++;
                }
                max = Math.max(right - left + 1, max);
            }
        }
        return max;
    }
}
