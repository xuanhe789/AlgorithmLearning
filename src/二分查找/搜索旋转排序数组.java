package 二分查找;
//升序排列的整数数组 nums 在预先未知的某个点上进行了旋转（例如， [0,1,2,4,5,6,7] 经旋转后可能变为 [4,5,6,7,0,1,2] ）。
//
//        请你在数组中搜索 target ，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
//
//         
//
//        示例 1：
//
//        输入：nums = [4,5,6,7,0,1,2], target = 0
//        输出：4
//        示例 2：
//
//        输入：nums = [4,5,6,7,0,1,2], target = 3
//        输出：-1
//        示例 3：
//
//        输入：nums = [1], target = 0
//        输出：-1
public class 搜索旋转排序数组 {
    //思路，因为数组在某个节点反转，所以数组分成两个有序的区间，我的做法是通过二分查找找到右区间的左边界
    //也可以找左区间的右边界，找到边界后分别通过二分查找在两个区间找target
    public int search(int[] nums, int target) {
        int mid = findMid(nums);
        int result=0;
        result = findTarget(nums, target, mid, nums.length - 1);
        if (result>0){
            return result;
        }
        return findTarget(nums,target,0,mid-1);

    }
    //寻找右区间的左边界
    public int findMid(int[] nums){
        int left=0;
        int right=nums.length-1;
        while (left<right){
            int mid=left+(right-left)/2;
            if (nums[right]>nums[mid]){
                right=mid;
            }
            else {
                left=mid+1;
            }
        }
        return left;
    }
//    在区间找Target
    public int findTarget(int[] nums,int target,int left,int right){
        while (left<right){
            int mid=left+(right-left)/2;
            if (nums[mid]==target){
                return mid;
            }
            else if (nums[mid]>target){
                right=mid;
            }
            else {
                left=mid+1;
            }
        }
        return nums[left]==target?left:-1;
    }
}
