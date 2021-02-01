import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
//
//         
//
//        示例 1：
//
//        输入：n = 3
//        输出：["((()))","(()())","(())()","()(())","()()()"]
//        示例 2：
//
//        输入：n = 1
//        输出：["()"]
//         
//
//        提示：
//
//        1 <= n <= 8
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/generate-parentheses
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class 括号生成 {
    public List<String> result=new ArrayList<>();
    //回溯法，剪枝
    public List<String> generateParenthesis(int n) {
        if (n==1){
            return Arrays.asList("()");
        }
        dfs(new StringBuilder(),n,n);
        return result;
    }

    /**
     *
     * @param stringBuilder
     * @param left 左括号的剩余数量
     * @param right 右括号的剩余数量
     */
    public void dfs(StringBuilder stringBuilder,int left,int right){
        //递归终止条件一：当左右括号都用完，将字符串加入结果集
        if (left==0&&right==0){
            result.add(stringBuilder.toString());
        }
        //根据逻辑，右括号永远不可能比左括号少，如果少了，说明错误，结束递归
        if (left>right){
            return;
        }
        //如果左括号还有剩余，继续往字符串添加
        if (left>0){
            stringBuilder.append('(');
            //接着递归，左括号减一
            dfs(stringBuilder,left-1,right);
            //递归总之后，删除掉数据，以免影响其他分支
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
        if (right>0){
            stringBuilder.append(')');
            dfs(stringBuilder,left-1,right);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);

        }
    }
}
