package leetcodeHOT100;

public class _10_正则表达式匹配 {
    //动态规划，问题比较复杂，边界比较多，需要分情况讨论
    public boolean isMatch(String s, String p) {
        if (s==null||p==null){
            return false;
        }
        //定义状态，dp[i][j]表示s中前i个字符和p中的前j个字符是否符合正则表达式匹配
        boolean[][] dp=new boolean[s.length()+1][p.length()+1];
        //初始化，dp[0][0]=true，表示两个字符串都为空时，匹配
        dp[0][0]=true;
        //当s为空字符串，p不为空字符串时，也有可能匹配，因此要考虑这种情况
        for (int i=1;i<p.length();i++){
            //当s当前字符为*时，可以将前一个字符去掉重新判断，因此去掉当前和前一个字符，来获取当前结果
            if (p.charAt(i)=='*'){
                dp[0][i]=dp[0][i-2];
            }
        }

        for (int i=1;i<=s.length();i++){
            for (int j=1;j<=p.length();j++){
                //1.如果当前i和j两个对应的字符匹配，则问题变化为dp[i-1][j-1]，即判断s的前i-1个字符和p的前j-1个字符是否匹配
                if (s.charAt(i-1)==p.charAt(j-1)||p.charAt(j-1)=='.'){
                    dp[i][j]=dp[i-1][j-1];
                }
                //2.如果两个字符不匹配，还需要判断p[j-1]是否为*,如果不为*，说明真的不匹配，那么dp[i][j]就为false
                else if (p.charAt(j-1)=='*'){
                    if (s.charAt(i-1)==p.charAt(j-2)||p.charAt(j-2)=='.'){
                        dp[i][j]=dp[i][j-1] //*号让前一个字符出现一次的情况
                                ||dp[i][j-2] //*号让前一个字符出现0次的情况，即移除*号和前一个字符，将问题转化为s的前i个字符和p的前j-2个字符是否匹配
                                ||dp[i-1][j]; //*号让前一个字符出现>=2次的情况
                    }else{
                        //如果p的前一个字符和s的当前字符不匹配，则用*消除p前一个字符，将问题转化为dp[i][j-2]
                        dp[i][j]=dp[i][j-2];
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
