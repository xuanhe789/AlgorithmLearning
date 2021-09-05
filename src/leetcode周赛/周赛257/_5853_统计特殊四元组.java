package leetcode周赛.周赛257;

import java.util.Arrays;
import java.util.Comparator;

//给你一个 下标从 0 开始 的整数数组 nums ，返回满足下述条件的 不同 四元组 (a, b, c, d) 的 数目 ：
//
//        nums[a] + nums[b] + nums[c] == nums[d] ，且
//        a < b < c < d
// 
//
//        示例 1：
//
//        输入：nums = [1,2,3,6]
//        输出：1
//        解释：满足要求的唯一一个四元组是 (0, 1, 2, 3) 因为 1 + 2 + 3 == 6 。
//        示例 2：
//
//        输入：nums = [3,3,6,4,5]
//        输出：0
//        解释：[3,3,6,4,5] 中不存在满足要求的四元组。
//        示例 3：
//
//        输入：nums = [1,1,1,3,5]
//        输出：4
//        解释：满足要求的 4 个四元组如下：
//        - (0, 1, 2, 3): 1 + 1 + 1 == 3
//        - (0, 1, 3, 4): 1 + 1 + 3 == 5
//        - (0, 2, 3, 4): 1 + 1 + 3 == 5
//        - (1, 2, 3, 4): 1 + 1 + 3 == 5
//         
//
//        提示：
//
//        4 <= nums.length <= 50
//        1 <= nums[i] <= 100
public class _5853_统计特殊四元组 {
    //妈的，看到这个数据规模才反应过来使用暴力法
    //可以使用4个for循环，也可以使用dfs
    int result=0;

    public int countQuadruplets(int[] nums) {
        for (int i=3;i<nums.length;i++){
            dfs(nums,0,i,nums[i],0,0);
        }
        return result;
    }

    public void dfs(int[] nums,int start,int end,int target ,int length,int sum){
        if (length>3||sum>target){
            return;
        }
        if (length==3&&sum==target){
            result++;
            return;
        }
        for (int i=start;i<end;i++){
            dfs(nums,i+1,end,target,length+1,sum+nums[i]);
        }
    }
}
