package 回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
//
//        说明：解集不能包含重复的子集。
//
//        示例:
//
//        输入: [1,2,2]
//        输出:
//        [
//        [2],
//        [1],
//        [1,2,2],
//        [2,2],
//        [1,2],
//        []
//        ]
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/subsets-ii
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class 子集2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result= new ArrayList<>();
        if (nums.length==0){
            return result;
        }
        boolean[] used=new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums,result,new ArrayList<Integer>(),used,0);
        return result;
    }

    public void dfs(int[] nums,List<List<Integer>> result,List<Integer> list,boolean[] used,int start){
        result.add(new ArrayList<>(list));

        for (int i=start;i<nums.length;i++){
            if (i>0&&nums[i]==nums[i-1]&&!used[i-1]){
                continue;
            }
            list.add(nums[i]);
            used[i]=true;
            dfs(nums,result,list,used,i+1);
            list.remove(list.size()-1);
            used[i]=false;
        }
    }
}
