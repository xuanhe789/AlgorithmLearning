package leetcodeHOT100;

import java.util.Stack;

public class _20_有效的括号 {
    public boolean isValid(String s) {
        if (s.length()<=1){
            return false;
        }
        Stack<Character> stack=new Stack<>();
        for (char c : s.toCharArray()) {
            if (c=='('||c=='['||c=='{'){
                stack.add(c);
            } else if (c==')') {
                if (stack.isEmpty()||stack.pop()!='('){
                    return false;
                }
            }else if (c=='}'){
                if (stack.isEmpty()||stack.pop()!='{'){
                    return false;
                }
            }else if (c==']'){
                if (stack.isEmpty()||stack.pop()!='['){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
