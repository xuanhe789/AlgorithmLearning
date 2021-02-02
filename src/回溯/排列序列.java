package 回溯;
//给出集合 [1,2,3,...,n]，其所有元素共有 n! 种排列。
//
//        按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
//
//        "123"
//        "132"
//        "213"
//        "231"
//        "312"
//        "321"
//        给定 n 和 k，返回第 k 个排列。
//
//         
//
//        示例 1：
//
//        输入：n = 3, k = 3
//        输出："213"
//        示例 2：
//
//        输入：n = 4, k = 9
//        输出："2314"
//        示例 3：
//
//        输入：n = 3, k = 1
//        输出："123"
//         
//
//        提示：
//
//        1 <= n <= 9
//        1 <= k <= n!
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/permutation-sequence
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class 排列序列 {
    int number=1;
    String result=null;
    public String getPermutation(int n, int k) {
        boolean[] used=new boolean[n+1];
        dfs(n,k,new StringBuilder(),used);
        return result;
    }
    public void dfs(int n,int k,StringBuilder stringBuilder,boolean[] used){
        if (stringBuilder.length()==n&&number==k){
            result=stringBuilder.toString();
            number++;
            return;
        }
        if (stringBuilder.length()==n){
            number++;
            return;
        }
        for (int i=1;i<=n;i++){
            if (used[i]){
                continue;
            }
            stringBuilder.append(i);
            used[i]=true;
            dfs(n,k,stringBuilder,used);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
            used[i]=false;
        }
    }
}
