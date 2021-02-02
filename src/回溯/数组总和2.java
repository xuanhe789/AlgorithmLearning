package 回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//
//        candidates 中的每个数字在每个组合中只能使用一次。
//
//        说明：
//
//        所有数字（包括目标数）都是正整数。
//        解集不能包含重复的组合。 
//        示例 1:
//
//        输入: candidates = [10,1,2,7,6,1,5], target = 8,
//        所求解集为:
//        [
//        [1, 7],
//        [1, 2, 5],
//        [2, 6],
//        [1, 1, 6]
//        ]
//        示例 2:
//
//        输入: candidates = [2,5,2,1,2], target = 5,
//        所求解集为:
//        [
//          [1,2,2],
//          [5]
//        ]
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/combination-sum-ii
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class 数组总和2 {
    //回溯法
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<>();
        boolean[] used=new boolean[candidates.length];
        Arrays.sort(candidates);
        dfs(candidates,target,result,new ArrayList<Integer>(),0,used);
        return result;
    }

    public void dfs(int[] candidates,int target,List<List<Integer>> result,List<Integer> list,int start,boolean[] used){
        if (target<0){
            return;
        }
        if (target==0){
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i=start;i<candidates.length;i++){
            //重点，经过排序后，如果上一个元素和当前元素相同，并且不是list里的上一层元素，则说明重复
            if (i>0&&candidates[i]==candidates[i-1]&&!used[i-1]){
                continue;
            }
            list.add(candidates[i]);
            used[i]=true;
            dfs(candidates,target-candidates[i],result,list,i+1,used);
            list.remove(list.size()-1);
            used[i]=false;
        }
    }
}
