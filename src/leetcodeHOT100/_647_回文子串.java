package leetcodeHOT100;
//给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
//
//        具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
//
//         
//
//        示例 1：
//
//        输入："abc"
//        输出：3
//        解释：三个回文子串: "a", "b", "c"
//        示例 2：
//
//        输入："aaa"
//        输出：6
//        解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
//         
//
//        提示：
//
//        输入的字符串长度不会超过 1000 。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/palindromic-substrings
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class _647_回文子串 {
    //动态规划
    // dp[i][j]表示s的i到j子串是否是回文字符串
    public int countSubstrings(String s) {
        if (s==null||"".equals(s)){
            return 0;
        }
        //单个字符也是回文子串
        int sum=s.length();
        boolean[][] dp=new boolean[s.length()][s.length()];
        for (int i=0;i<s.length();i++){
            dp[i][i]=true;
        }
        for (int j=1;j<dp.length;j++){
            for (int i=0;i<j;i++){
                if (s.charAt(i)==s.charAt(j)){
                    if (j-i<3){
                        dp[i][j]=true;
                    }else {
                        dp[i][j]=dp[i+1][j-1];
                    }
                    if (dp[i][j]){
                        sum++;
                    }
                }
            }
        }
        return sum;
    }
}
