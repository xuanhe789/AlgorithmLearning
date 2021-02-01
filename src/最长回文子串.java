import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

//给你一个字符串 s，找到 s 中最长的回文子串。
//
//         
//
//        示例 1：
//
//        输入：s = "babad"
//        输出："bab"
//        解释："aba" 同样是符合题意的答案。
//        示例 2：
//
//        输入：s = "cbbd"
//        输出："bb"
//        示例 3：
//
//        输入：s = "a"
//        输出："a"
//        示例 4：
//
//        输入：s = "ac"
//        输出："a"
//         
//
//        提示：
//
//        1 <= s.length <= 1000
//        s 仅由数字和英文字母（大写和/或小写）组成
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/longest-palindromic-substring
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class 最长回文子串 {
    public  String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        if (chars.length==1){
            return String.valueOf(chars[0]);
        }
        int maxlen=0,begin=0;
        for (int i=0;i<chars.length;i++){
            for (int j=chars.length-1;j>=i;j--){
                if (j-i+1>maxlen&& valid(chars,i,j)){
                    maxlen=j-i+1;
                    begin=i;
                }
            }
        }
        return s.substring(begin,maxlen+begin);
    }

    public boolean valid(char[] chars,int i,int j){
        while (i<=j){
            if (chars[i]!=chars[j]){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    //动态规划解法
    //1.状态定义
    //dp[i][j]表示左边为i，右边界为j的子字符串是否为回文
    //2.状态转移方程
    //dp[i][j]=(chars[i]==chars[j])&&(j-i<3||dp[i+1][j-1]
    //j-i<3表示子串等于或小于3时直接返回true
    //3.初始化
    //dp[i][i]=true
    public  String longestPalindromeBetter(String s) {
        if (s.length()==1){
            return s;
        }
        char[] chars = s.toCharArray();
        boolean[][] dp=new boolean[chars.length][chars.length];
        for (int i=0;i<chars.length;i++){
            dp[i][i]=true;
        }
        //右边界从1开始
        int maxlen=0;
        int begin=0;
        for (int j=1;j<chars.length;j++){
            //左边界从0开始，不能大于右边界
            for (int i=0;i<j;i++){
                if (chars[i]==chars[j]){
                    if (j-i<3){
                        dp[i][j]=true;
                    }
                    else {
                        //dp[i+1][j-1]已经在上一轮被计算出来了
                        dp[i][j]=dp[i+1][j-1];
                    }
                }
                if (dp[i][j]&&j-i+1>maxlen){
                    maxlen=j-i+1;
                    begin=i;
                }
            }
        }
        return s.substring(begin,begin+maxlen);
    }

    public static void main(String[] args) {
        String a="babad";
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        List<Integer> collect = list.stream().map(integer -> integer + 1).collect(Collectors.toList());
    }
}
