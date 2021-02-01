package 回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//
//        candidates 中的数字可以无限制重复被选取。
//
//        说明：
//
//        所有数字（包括 target）都是正整数。
//        解集不能包含重复的组合。 
//        示例 1：
//
//        输入：candidates = [2,3,6,7], target = 7,
//        所求解集为：
//        [
//        [7],
//        [2,2,3]
//        ]
//        示例 2：
//
//        输入：candidates = [2,3,5], target = 8,
//        所求解集为：
//        [
//          [2,2,2,2],
//          [2,3,3],
//          [3,5]
//        ]
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/combination-sum
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class 数组总和 {
    //回溯+剪枝
    //如果 target 减去一个数得到负数，那么减去一个更大的树依然是负数，同样搜索不到结果。
    // 基于这个想法，我们可以对输入数组进行排序，添加相关逻辑达到进一步剪枝的目的；
    public List<List<Integer>> combinationSumBetter(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        //排序是剪枝的前提
        Arrays.sort(candidates);
        dfs(candidates,0,target,result,new ArrayList<Integer>());
        return result;
    }

    public void dfs2(int[] candidates,int begin,int traget,List<List<Integer>> result,List<Integer> list){
        if (traget==0){
            result.add(new ArrayList<Integer>(list));
            return;
        }
        // 重点理解这里从 begin 开始搜索的语意
        for (int i=begin;i<candidates.length;i++){
            if (traget-candidates[i]<0){
                break;
            }
            list.add(candidates[i]);
            dfs(candidates,i,traget-candidates[i],result,list);
            //回溯法的关键，还原状态
            list.remove(list.size()-1);
        }
    }


    //回溯法
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(candidates,0,target,result,new ArrayList<Integer>());
        return result;
    }

    public void dfs(int[] candidates,int begin,int traget,List<List<Integer>> result,List<Integer> list){
        if (traget<0){
            return;
        }
        if (traget==0){
            result.add(new ArrayList<Integer>(list));
            return;
        }
        // 重点理解这里从 begin 开始搜索的语意
        for (int i=begin;i<candidates.length;i++){
            list.add(candidates[i]);
            dfs(candidates,i,traget-candidates[i],result,list);
            //回溯法的关键，还原状态
            list.remove(list.size()-1);
        }
    }

}
