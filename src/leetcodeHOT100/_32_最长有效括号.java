package leetcodeHOT100;

import java.util.Stack;

//知耻而后勇，知弱而图强
//给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
//
//         
//
//        示例 1：
//
//        输入：s = "(()"
//        输出：2
//        解释：最长有效括号子串是 "()"
//        示例 2：
//
//        输入：s = ")()())"
//        输出：4
//        解释：最长有效括号子串是 "()()"
//        示例 3：
//
//        输入：s = ""
//        输出：0
//         
//
//        提示：
//
//        0 <= s.length <= 3 * 104
//        s[i] 为 '(' 或 ')'
public class _32_最长有效括号 {
    //动态规划，dp[i]表示以第i个字符结尾的最长有效括号长度
    //状态转移方程：
    //1.当s.charAt(i-1)=='(',将一个'('压栈，因为以左括号结尾肯定无效的，所以此时dp[i]=0
    //2.当s.charAt(i-1)==')'时，如果栈为空，则不存在左括号与当前右括号匹配，dp[i]=0
    //如果栈不为空，则dp[i]=2+dp[i-1]+dp[i-(2+dp[i-1])]，我表达能力不太好，这条式子可以用"()((()))"在纸上列举理解一下，
    //其中dp[i-(2+dp[i-1])]表示以i右括号匹配的左括号的左一位字符结尾的最大有效长度
    public int longestValidParentheses(String s) {
        if (s==null||s.equals("")){
            return 0;
        }
        //用于存储最大有效长度，也是方法的返回值
        int max=0;
        //栈，遇到左括号就存入栈，用于和右括号匹配
        Stack<Character> stack=new Stack<>();
        //dp[i]表示以第i个字符结尾的最长有效括号长度，dp[0]=0
        int[] dp=new int[s.length()+1];
        for (int i=1;i<=s.length();i++){
            if (s.charAt(i-1)=='('){
                //将一个'('压栈，因为以左括号结尾肯定无效的，所以此时dp[i]=0
                stack.push('(');
            }else {
                if (stack.isEmpty()){
                    continue;
                }
                stack.pop();
                dp[i]=2+dp[i-1]+dp[i-(2+dp[i-1])];
                max=Math.max(dp[i],max);
            }
        }
        return max;
    }
}
