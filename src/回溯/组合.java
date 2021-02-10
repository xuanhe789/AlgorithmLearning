package 回溯;

import java.util.ArrayList;
import java.util.List;

//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
//
//        示例:
//
//        输入: n = 4, k = 2
//        输出:
//        [
//        [2,4],
//        [3,4],
//        [2,3],
//        [1,2],
//        [1,3],
//        [1,4],
//        ]
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/combinations
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class 组合 {

    //回溯法+剪枝
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result= new ArrayList<>();
        if (k==0){
            return result;
        }
        dfs( n, k, 1,result,new ArrayList<Integer>());
        return result;
    }

    public void dfs(int n,int k,int start,List<List<Integer>> result,List<Integer> list){
        if (list.size()==k){
            result.add(new ArrayList<>(list));
        }
        //这一步是剪枝
        if (k-list.size()-(n-start+1)>0){
            return;
        }
        for (int i=start;i<=n;i++){
            list.add(i);
            dfs(n,k,i+1,result,list);
            list.remove(list.size()-1);
        }
    }
}
