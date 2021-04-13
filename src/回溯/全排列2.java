package 回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
//
//         
//
//        示例 1：
//
//        输入：nums = [1,1,2]
//        输出：
//        [[1,1,2],
//        [1,2,1],
//        [2,1,1]]
//        示例 2：
//
//        输入：nums = [1,2,3]
//        输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//         
//
//        提示：
//
//        1 <= nums.length <= 8
//        -10 <= nums[i] <= 10
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/permutations-ii
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class 全排列2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used=new boolean[nums.length];
        //要先排序，才能剪枝
        Arrays.sort(nums);
        dfs(nums,result,new ArrayList<Integer>(),used);
        return result;
    }

    public void dfs(int[] nums,List<List<Integer>> result,List<Integer> list,boolean[] used){
        if (list.size()==nums.length){
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i=0;i<nums.length;i++){
            if (used[i]){
                continue;
            }
            //重点来了,因为已经排序过了，如果当前元素和上一个元素相同，则会出现重复的结果
            //因此剪掉当前元素，当然i必须大于0，不然i-1没有意思
            if (i>0&&nums[i]==nums[i-1]&&!used[i-1]){
                continue;
            }
            list.add(nums[i]);
            used[i]=true;
            dfs(nums,result,list,used);
            list.remove(list.size()-1);
            used[i]=false;
        }
    }
}
