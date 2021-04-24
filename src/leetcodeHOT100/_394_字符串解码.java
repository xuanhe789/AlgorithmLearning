package leetcodeHOT100;

import java.util.LinkedList;

//知耻而后勇，知弱而图强
//给定一个经过编码的字符串，返回它解码后的字符串。
//
//        编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
//
//        你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
//
//        此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
//
//         
//
//        示例 1：
//
//        输入：s = "3[a]2[bc]"
//        输出："aaabcbc"
//        示例 2：
//
//        输入：s = "3[a2[c]]"
//        输出："accaccacc"
//        示例 3：
//
//        输入：s = "2[abc]3[cd]ef"
//        输出："abcabccdcdcdef"
public class _394_字符串解码 {
    //辅助栈解法，定义两个辅助栈
    public String decodeString(String s) {
        if (s==null||"".equals(s)){
            return "";
        }
        //定义字符串辅助栈，用于存储[之前的字符串，之后恢复
        LinkedList<String> stack_String=new LinkedList<>();
        //定义倍数辅助栈，存储倍数，用于后续计算字符串数量
        LinkedList<Integer> stack_multil=new LinkedList<>();
        //当前倍数，如果遇到[，将其存储到stack_multil，并置0
        int multil=0;
        StringBuilder res=new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c=='['){
                //入栈
                stack_multil.addFirst(multil);
                stack_String.addFirst(res.toString());
                //置0置空
                multil=0;
                res=new StringBuilder();
            }else if (c==']'){
                //倍数出栈，乘以字符串
                Integer mul = stack_multil.removeFirst();
                //前面的字符串出栈
                String str = stack_String.removeFirst();
                StringBuilder temp=new StringBuilder();
                for (int i=0;i<mul;i++){
                    temp.append(res.toString());
                }
                //字符串拼接
                res=new StringBuilder(str+temp.toString());
            }else if (c>='0'&&c<='9'){

                multil=multil*10+Integer.parseInt(c+"");
            }else {
                res.append(c);
            }
        }
        return res.toString();
    }
}
