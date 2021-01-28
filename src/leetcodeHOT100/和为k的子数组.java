package leetcodeHOT100;

import java.util.HashMap;

//给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
//
//        示例 1 :
//
//        输入:nums = [1,1,1], k = 2
//        输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
//        说明 :
//
//        数组的长度为 [1, 20,000]。
//        数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/subarray-sum-equals-k
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class 和为k的子数组 {
    //前缀和+Hash表优化,类似于两数之和的思路
    public int subarraySum2(int[] nums, int k) {
        //map以元素之和为key，元素之和的值出现的次数为value
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int count=0;
        int preSum=0;
        for (int i=0;i<nums.length;i++){
            //如果map.containsKey(preSum+nums[i]-k)，说明有存在以i元素结尾的的子数组的和=k
            if (map.containsKey(preSum+nums[i]-k)){
                count+=map.get(preSum+nums[i]-k);
            }
            preSum+=nums[i];
            Integer mapResult = map.get(preSum);
            if (mapResult==null){
                map.put(preSum,1);
                continue;
            }
            map.put(preSum,mapResult+1);

        }
        return count;
    }
    //暴力法
    public int subarraySum(int[] nums, int k) {
        int count=0;
        for (int i=0;i<nums.length;i++){
            int sum=0;
            for (int j=i;j<nums.length;j++){
                sum=sum+nums[j];
                if (sum==k){
                    count++;
                }
            }
        }
        return count;
    }
}
