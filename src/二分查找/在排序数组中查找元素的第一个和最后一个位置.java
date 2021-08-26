package 二分查找;
//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
//
//        如果数组中不存在目标值 target，返回 [-1, -1]。
//
//        进阶：
//
//        你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
//         
//
//        示例 1：
//
//        输入：nums = [5,7,7,8,8,10], target = 8
//        输出：[3,4]
//        示例 2：
//
//        输入：nums = [5,7,7,8,8,10], target = 6
//        输出：[-1,-1]
//        示例 3：
//
//        输入：nums = [], target = 0
//        输出：[-1,-1]
public class 在排序数组中查找元素的第一个和最后一个位置 {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length==0){
            return new int[]{-1,-1};
        }
        int firstPosition = findFirstPosition(nums, target);
        if (firstPosition==-1){
            return new int[]{-1,-1};
        }
        int lastPosition = findLastPosition(nums, target);
        return new int[]{firstPosition,lastPosition};
    }
    //寻找目标元素开始的位置
    public int findFirstPosition(int[] nums,int target){
        int left=0;
        int right=nums.length-1;
        while (left<right){
            //向下取整
            int mid=left+(right-left)/2;
            if (nums[mid]<target){
                left=mid+1;
            }
            else if (nums[mid]==target){
                right=mid;
            }
            else {
                right=mid-1;
            }
        }
        return nums[left]==target?left:-1;
    }

    public int findLastPosition(int[] nums,int target){
        int left=0;
        int right=nums.length-1;
        while (left<right){
            //向上取整,相当于4.5取5
            int mid=left+(right-left+1)/2;
            if (nums[mid]>target){
                right=mid-1;
            }
            else if (nums[mid]==target){
                left=mid;
            }
            else {
                left=mid+1;
            }
        }
        return nums[left]==target?left:-1;
    }

}
