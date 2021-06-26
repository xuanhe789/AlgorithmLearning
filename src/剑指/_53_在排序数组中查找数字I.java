package 剑指;
//统计一个数字在排序数组中出现的次数。
//
//         
//
//        示例 1:
//
//        输入: nums = [5,7,7,8,8,10], target = 8
//        输出: 2
//        示例 2:
//
//        输入: nums = [5,7,7,8,8,10], target = 6
//        输出: 0
//         
//
//        限制：
//
//        0 <= 数组长度 <= 50000
public class _53_在排序数组中查找数字I {
    public int search(int[] nums, int target) {
        if (nums.length==0){
            return 0;
        }
        int left = findLeft(nums, target);
        if (left==-1){
            return 0;
        }
        int right = findRight(nums, target);
        return right-left+1;
    }

    public int findLeft(int[] nums,int target){
        int left=0;
        int right=nums.length-1;
        while (left<right){
            int mid=left+(right-left)/2;
            if (nums[mid]<target){
                left=mid+1;
            }else if (nums[mid]==target){
                right=mid;
            }
            else {
                right=mid;
            }
        }
        if (nums[left]==target){
            return left;
        }
        return -1;
    }

    public int findRight(int[] nums,int target){
        int left=0;
        int right=nums.length-1;
        while (left<right){
            int mid=left+(right-left+1)/2;
            if (nums[mid]<target){
                left=mid+1;
            }
            else if (nums[mid]==target){
                left=mid;
            }
            else {
                right=mid-1;
            }
        }
        if (nums[left]==target){
            return left;
        }
        return -1;
    }
}
