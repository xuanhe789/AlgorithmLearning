package 剑指;
//知耻而后勇，知弱而图强
//在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
//
//         
//
//        示例 1：
//
//        输入：nums = [3,4,3,3]
//        输出：4
//        示例 2：
//
//        输入：nums = [9,1,7,9,7,9,7]
//        输出：1
//         
//
//        限制：
//
//        1 <= nums.length <= 10000
//        1 <= nums[i] < 2^31
public class _56_数组中数字出现的次数II {
    //思路：如果所有数字出现三次，那么他们的二进制位每一位加起来的个数都能被3整除
    //当加上一位出现一次的数字后，每一位加起来后对3取余的结果就是只出现过一次的数的结果
    //建议直接去看K神的图，很好理解
    public int singleNumber(int[] nums) {
        int[] arr=new int[32];
        int j=1;
        for (int num : nums) {
            for (int i=0;i<arr.length;i++){
                arr[i]+=num&1;
                num>>>=1;
            }
        }
        int result=0;
        for (int i=arr.length-1;i>=0;i--){
            result<<=1;
            result|=arr[i]%3;
        }
        return result;
    }
}