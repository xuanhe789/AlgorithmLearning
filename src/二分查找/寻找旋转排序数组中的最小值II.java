package 二分查找;
//假设按照升序排序的数组在预先未知的某个点上进行了旋转。
//
//        ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
//
//        请找出其中最小的元素。
//
//        注意数组中可能存在重复的元素。
//
//        示例 1：
//
//        输入: [1,3,5]
//        输出: 1
//        示例 2：
//
//        输入: [2,2,2,0,1]
//        输出: 0
//        说明：
//
//        这道题是 寻找旋转排序数组中的最小值 的延伸题目。
//        允许重复会影响算法的时间复杂度吗？会如何影响，为什么？
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class 寻找旋转排序数组中的最小值II {
    public int search(int[] nums, int target) {
        if(nums.length==1){
            return nums[0];
        }
        int left=0;
        int right=nums.length-1;
        while (left<right){
            int mid=left+(right-left)/2;
            if (nums[mid]>nums[right]){
                left=mid+1;
            }
            else if (nums[mid]<nums[right]){
                right=mid;
            }
            else {
                right--;
            }
        }
        return nums[left];
    }
}
