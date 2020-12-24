import java.util.Stack;

//20. 有效的括号
//        给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
//
//        有效字符串需满足：
//
//        左括号必须用相同类型的右括号闭合。
//        左括号必须以正确的顺序闭合。
//        注意空字符串可被认为是有效字符串。
//
//        示例 1:
//
//        输入: "()"
//        输出: true
//        示例 2:
//
//        输入: "()[]{}"
//        输出: true
//        示例 3:
//
//        输入: "(]"
//        输出: false
public class 有效的括号 {
    //思路：1.利用栈，遇到开括号时将其放入栈，遇到闭括号时判断栈是否为空（为空则此前无push进对应的开括号，此字符串非法），
    //
    //栈不为空则从栈中pop出栈顶元素判断括号类型是否一致，不一致证明此闭括号无对应开括号，字符串非法。
    //
    //最终栈为空则字符串满足要求，不为空则有不对应的括号存在
    public boolean isValid(String s) {
        //1.特判
        if(s.length()<=1) return false;
        Stack<Character> characters = new Stack<>();
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)=='('){
                characters.push(')');
            }
            else if (s.charAt(i)=='{'){
                characters.push('}');
            }
            else if (s.charAt(i)=='['){
                characters.push(']');
            }
            else if (characters.isEmpty()||s.charAt(i)!=characters.pop()){
                return false;
            }
        }
        if (characters.isEmpty()){
            return true;
        }
        return false;
    }
}
