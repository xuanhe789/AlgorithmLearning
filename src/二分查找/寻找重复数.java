package 二分查找;

//给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
//
//        示例 1:
//
//        输入: [1,3,4,2,2]
//        输出: 2
//        示例 2:
//
//        输入: [3,1,3,4,2]
//        输出: 3
//        说明：
//
//        不能更改原数组（假设数组是只读的）。
//        只能使用额外的 O(1) 的空间。
//        时间复杂度小于 O(n2) 。
//        数组中只有一个重复的数字，但它可能不止重复出现一次。
//
//        链接：https://leetcode-cn.com/problems/find-the-duplicate-number
public class 寻找重复数 {
    //思路：二分法（二分查找）
    public int findDuplicate(int[] nums) {
        if (nums.length==1){
            return 1;
        }
        int left=1;
        int right=nums.length-1;
        int mid=0;
        while (left!=right){
            mid=(left+right)/2;
            int ant=0;
            for (int i=0;i<nums.length;i++){
                if (nums[i]<=mid){
                    ant++;
                }
            }
            if (ant>mid){
                right=mid;
            }
            else {
                left=mid+1;
            }
        }
        return left;

    }
}
