package 动态规划从0开始;

import java.util.HashMap;
import java.util.Map;
/*给你一个整数数组 nums ，你可以对它进行一些操作。

        每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除 所有 等于 nums[i] - 1 和 nums[i] + 1 的元素。

        开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。

         

        示例 1：

        输入：nums = [3,4,2]
        输出：6
        解释：
        删除 4 获得 4 个点数，因此 3 也被删除。
        之后，删除 2 获得 2 个点数。总共获得 6 个点数。
        示例 2：

        输入：nums = [2,2,3,3,3,4]
        输出：9
        解释：
        删除 3 获得 3 个点数，接着要删除两个 2 和 4 。
        之后，再次删除 3 获得 3 个点数，再次删除 3 获得 3 个点数。
        总共获得 9 个点数。*/
public class _7_删除并获得点数 {
    /*
    * 动态规划，这道题可转化为打家劫舍，在选择过程中，选择第i个数字就不能选择第i-1个数字和第i-2个数字，也就是打家劫舍中不能抢邻居房子。
    * 因此状态转移方程为：dp[i]=Math.max(dp[i-1],dp[i-2] + map.get(i)*i);
    * dp[i]表示从0-i数字中，删除所能获取的最大值
    * */
    public int deleteAndEarn(int[] nums) {
        if (nums.length==1){
            return nums[0];
        }
        Map<Integer,Integer> map=new HashMap<>();
        int max=0;
        for (int num : nums) {
            Integer value = map.getOrDefault(num, 0);
            map.put(num,value+1);
            max=Math.max(max,num);
        }
        int[] dp=new int[max+1];
        dp[0]=0;
        dp[1]=map.get(1)==null?0:map.get(1);
        for (int i=2;i<=max;i++){
            if (map.get(i)!=null){
                dp[i]=Math.max(dp[i-1],dp[i-2] + map.get(i)*i);
            }else {
                dp[i]=dp[i-1];
            }
        }
        return dp[max];
    }

    /*
    * 空间优化
    * */
    public int deleteAndEarnBetter(int[] nums) {
        if (nums.length==1){
            return nums[0];
        }
        Map<Integer,Integer> map=new HashMap<>();
        int max=0;
        for (int num : nums) {
            Integer value = map.getOrDefault(num, 0);
            map.put(num,value+1);
            max=Math.max(max,num);
        }
        int one=0;
        int two=map.get(1)==null?0:map.get(1);
        int now=two;
        for (int i=2;i<=max;i++){
            if (map.get(i)!=null){
                now=Math.max(two,one + map.get(i)*i);
            }else {
                now=two;
            }
            one=two;
            two=now;
        }
        return now;
    }
}
