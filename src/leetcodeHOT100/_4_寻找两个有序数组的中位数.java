package leetcodeHOT100;
//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
//
//         
//
//        示例 1：
//
//        输入：nums1 = [1,3], nums2 = [2]
//        输出：2.00000
//        解释：合并数组 = [1,2,3] ，中位数 2
//        示例 2：
//
//        输入：nums1 = [1,2], nums2 = [3,4]
//        输出：2.50000
//        解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
//        示例 3：
//
//        输入：nums1 = [0,0], nums2 = [0,0]
//        输出：0.00000
//        示例 4：
//
//        输入：nums1 = [], nums2 = [1]
//        输出：1.00000
//        示例 5：
//
//        输入：nums1 = [2], nums2 = []
//        输出：2.00000
//         
//
//        提示：
//
//        nums1.length == m
//        nums2.length == n
//        0 <= m <= 1000
//        0 <= n <= 1000
//        1 <= m + n <= 2000
//        -106 <= nums1[i], nums2[i] <= 106
//         
//
//        进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
public class _4_寻找两个有序数组的中位数 {
    //思路：二分查找，设计两条分割线，在分割线左边所有的数小于分割线右边所有的数
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //在短的数组上找分割线，否则会导致数组下标越界，因此设num1为长度短的那个数组
        if (nums1.length>nums2.length){
            int[] temp=nums1;
            nums1=nums2;
            nums2=temp;
        }
        int num1Length=nums1.length;
        int num2Length=nums2.length;
        //计算分割线左边元素的数量
        int totalLeft=(num1Length+num2Length+1)/2;
        int left=0;
        int right=num1Length;
        //要做到分割线左边所有的数小于分割线右边所有的数，那么必须满足以下条件
        //num1[i-1]<=num2[j]&&nums[j-1]<=nums[i]
        //下面的二分查找的意义就是：找到最后一个num1[i-1]<=num2[j]&&nums[j-1]<=nums[i]
        while (left<right){
            int i=left+(right-left+1)/2;
            int j=totalLeft-i;
            //如果num1分割线左边第一个数比num2分割线右边第一个数大，则不满足num1[i-1]<=num2[j]&&nums[j-1]<=nums[i]
            //说明num1走过头了，往左缩
            if (nums1[i-1]>nums2[j]){
                right=i-1;
            }else {
                left=i;
            }
        }
        //此时的i就是num1分割线右边第一个数的下标
        int i=left;
        //此时的j就是num2分割线右边第一个数的下标
        int j=totalLeft-left;
        //分别获取每条分割线的左右两个数，用于比较和计算结果
        int num1Lmax=i==0?Integer.MIN_VALUE:nums1[i-1];
        int num1Rmin=i==num1Length?Integer.MAX_VALUE:nums1[i];
        int num2Lmax=j==0?Integer.MIN_VALUE:nums2[j-1];
        int num2Rmin=j==num2Length?Integer.MAX_VALUE:nums2[j];
        if ((num1Length+num2Length)%2!=0){
            return Math.max(num1Lmax,num2Lmax);
        }
        return (double) (Math.max(num1Lmax,num2Lmax)+Math.min(num1Rmin,num2Rmin))/2;
    }
}
