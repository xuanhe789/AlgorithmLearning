package leetcodeHOT100;
//知耻而后勇，知弱而图强
//给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
//
//        你可以对一个单词进行如下三种操作：
//
//        插入一个字符
//        删除一个字符
//        替换一个字符
//         
//
//        示例 1：
//
//        输入：word1 = "horse", word2 = "ros"
//        输出：3
//        解释：
//        horse -> rorse (将 'h' 替换为 'r')
//        rorse -> rose (删除 'r')
//        rose -> ros (删除 'e')
//        示例 2：
//
//        输入：word1 = "intention", word2 = "execution"
//        输出：5
//        解释：
//        intention -> inention (删除 't')
//        inention -> enention (将 'i' 替换为 'e')
//        enention -> exention (将 'n' 替换为 'x')
//        exention -> exection (将 'n' 替换为 'c')
//        exection -> execution (插入 'u')
//         
//
//        提示：
//
//        0 <= word1.length, word2.length <= 500
//        word1 和 word2 由小写英文字母组成
public class _72_编辑距离 {
    //动态规划，dp[i][j]表示word1前i个字符转换成word2前j个字符所需要的做少操作数
    public int minDistance(String word1, String word2) {
        //dp数组需要多加一位，防止空字符串dp[0][j]表示word1为空字符串的时候，dp[i][0]表示word2为空字符串的时候
        int[][] dp=new int[word1.length()+1][word2.length()+1];
        //当word1为空的时候，转化成word2需要进行插入操作
        for (int i=1;i<=word2.length();i++){
            dp[0][i]=i;
        }
        //当word2为空的时候，word1转化成word2需要进行删除操作
        for (int i=1;i<=word1.length();i++){
            dp[i][0]=i;
        }
        //1.当word1的第i个字符和word2第j个字符相同时，也就是word1.charAt(i-1)==word2.charAt(j-1)
        //这时，不需要对word1的第i个字符进行任何操作，问题转化为dp[i-1][j-1]
        //2.当word1的第i个字符和word2第j个字符不相同时，word1可以执行插入，删除和修改操作，取这三个操作执行后的编辑距离的最小值
        //插入操作：dp[i][j]可以由word1插入第i个字符得来，也就是dp[i][j-1]+1，+1代表word1插入第i个字符
        //删除操作：dp[i][j]可以由word1删除第i个字符得来，也就是dp[i-1][j]+1，+1代表word1删除第i个字符
        for (int i=1;i<=word1.length();i++){
            for (int j=1;j<=word2.length();j++){
                if (word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else {
                    dp[i][j]=Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
