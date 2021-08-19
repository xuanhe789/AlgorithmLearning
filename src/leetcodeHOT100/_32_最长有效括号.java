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
    public int longestValidParentheses(String s) {
        if (s==null||s.equals("")){
            return 0;
        }
        int result=0;
        Stack<Character> left=new Stack<>();
        for (int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if (c=='('){
                left.push(c);
            }else {
                if (!left.isEmpty()){
                    result+=2;
                    left.pop();
                }
            }
        }
        return result;
    }
}
