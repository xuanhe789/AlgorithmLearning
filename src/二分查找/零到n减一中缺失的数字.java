package 二分查找;
//一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
//
//         
//
//        示例 1:
//
//        输入: [0,1,3]
//        输出: 2
//        示例 2:
//
//        输入: [0,1,2,3,4,5,6,7,9]
//        输出: 8
public class 零到n减一中缺失的数字 {
    //第一种
    public int missingNumber(int[] nums) {
        int left=0;
        int right=nums.length-1;
        while (left<=right){
            int mid=left+(right-left)/2;
            if (nums[mid]>mid){
                right=mid-1;
            }
            else {
                left=mid+1;
            }
        }
        return left;
    }
    //第二种
    public int missingNumber2(int[] nums) {
        int left=0;
        //必须理解这一步
        int right=nums.length;
        while (left<right){
            int mid=left+(right-left)/2;
            if (nums[mid]>mid){
                right=mid;
            }
            else {
                left=mid+1;
            }
        }
        return left;
    }
}
