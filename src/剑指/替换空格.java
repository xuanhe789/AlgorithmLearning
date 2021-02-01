package 剑指;
//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
//
//         
//
//        示例 1：
//
//        输入：s = "We are happy."
//        输出："We%20are%20happy."
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class 替换空格 {
    //简单的一道题，用Stringbuilder，判断字符是否为空格，如果不为空格就append,否则替换
    //不要用s.replaceAll()，否则时间复杂为O(n^2)
    public String replaceSpace(String s) {
        if (s==null||s.equals("")){
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        int i=0;
        while (i<s.length()){
            if (s.charAt(i)==' '){
                stringBuilder.append("%20");
            }
            else {
                stringBuilder.append(s.charAt(i));
            }
            i++;
        }
        return stringBuilder.toString();
    }
}
