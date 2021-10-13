package leetcodeHOT100;

public class _136_只出现一次的数字 {
    //使用位运算，时间复杂度为O(n)
    //当两个数相同时，他们异或的值为0
    //0异或某个数，值等于那个数
    public int singleNumber(int[] nums) {
        if (nums.length==1){
            return nums[0];
        }
        int result=0;
        for (int num : nums) {
            result^=num;
        }
        return result;
    }
}
