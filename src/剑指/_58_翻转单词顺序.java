package 剑指;
//输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
//
//         
//
//        示例 1：
//
//        输入: "the sky is blue"
//        输出: "blue is sky the"
//        示例 2：
//
//        输入: "  hello world!  "
//        输出: "world! hello"
//        解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
//        示例 3：
//
//        输入: "a good   example"
//        输出: "example good a"
//        解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
//         
//
//        说明：
//
//        无空格字符构成一个单词。
//        输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
//        如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
public class _58_翻转单词顺序 {
    //思路：双指针，左右指针，都从最右端开始，逐渐往左缩
    public String reverseWords(String s) {
        if (s==null||s.equals("")){
            return s;
        }
        StringBuilder result = new StringBuilder();
        //定义左右指针
        int right=s.length()-1;
        int left=right;
        while (left>=0){
            //当遇到空格时，说明左右指针相同，左右指针都--
            if (s.charAt(left)==' '){
                left--;
                right--;
            }
            //当左指针为0时，说明是第一个单词的第一个字母，则开始拼接
            //当左指针的上一个字母为空格时，开始拼接
            else if (left==0||s.charAt(left-1)==' '){
                for (int i=left;i<=right;i++){
                    result.append(s.charAt(i));
                }
                result.append(' ');
                left--;
                right=left;
            }
            //当左指针指向非空格时，左指针--，右指针不动，此时右指针指向当前单词的最后一个字母
            else {
                left--;
            }
        }
        if (result.length()>0&&result.charAt(result.length()-1)==' '){
            result.deleteCharAt(result.length()-1);
        }
        return result.toString();
    }

}
