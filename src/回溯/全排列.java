package 回溯;

import java.util.ArrayList;
import java.util.List;
//给定一个 没有重复 数字的序列，返回其所有可能的全排列。
//
//        示例:
//
//        输入: [1,2,3]
//        输出:
//        [
//        [1,2,3],
//        [1,3,2],
//        [2,1,3],
//        [2,3,1],
//        [3,1,2],
//        [3,2,1]
//        ]
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/permutations
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class 全排列 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length==0){
            return result;
        }
        boolean[] used=new boolean[nums.length];
        dfs(nums,result,used,new ArrayList<Integer>());
        return result;
    }

    public void dfs(int[] nums,List<List<Integer>> result,boolean[] used,List<Integer> list){
        if (list.size()==nums.length){
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i=0;i<nums.length;i++){
            if (used[i]){
                continue;
            }
            list.add(nums[i]);
            used[i]=true;
            dfs(nums,result,used,list);
            //重置状态
            list.remove(list.size()-1);
            used[i]=false;
        }
    }
}
