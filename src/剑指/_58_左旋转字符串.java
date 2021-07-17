package 剑指;
//知耻而后勇，知弱而图强
//字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
//
//         
//
//        示例 1：
//
//        输入: s = "abcdefg", k = 2
//        输出: "cdefgab"
//        示例 2：
//
//        输入: s = "lrloseumgh", k = 6
//        输出: "umghlrlose"
public class _58_左旋转字符串 {
    public String reverseLeftWords(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i=n;i<s.length();i++){
            sb.append(s.charAt(n));
        }
        for (int i=0;i<n;i++){
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
