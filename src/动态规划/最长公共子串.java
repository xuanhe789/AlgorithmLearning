package 动态规划;
//知耻而后勇，知弱而图强
//描述
//        给定两个字符串str1和str2,输出两个字符串的最长公共子串
//        题目保证str1和str2的最长公共子串存在且唯一。
//        示例1
//        输入：
//        "1AB2345CD","12345EF"
//        复制
//        返回值：
//        "2345"
public class 最长公共子串 {
    //这道题我觉得挺难的，自己想的话想不出来
    //动态规划
    //1.状态定义：dp[i][j]表示以str1第i个字符，str2第j个字符结尾的最长公共子串的长度
    //2.状态转移方程：如果str1的第i个字符和str2的第j个字符相同，则dp[i][j]=dp[i-1][j-1]+1
    //3.初始化，因为dp[i][j]依赖于dp[i-1][j-1]，所以dp数组往后面多申请一位，让dp[0][j]和dp[i][0]的值都为0，方便后面的计算
    public String LCS (String str1, String str2) {
        if (str1.length()==0||str2.length()==0){
            return "";
        }
        int index=0;
        int max=0;
        //往后面多申请一位，dp[0][j]和dp[i][0]的值都为0
        int[][] dp=new int[str1.length()+1][str2.length()+1];
        for (int i=1;i<=str1.length();i++){
            for (int j=1;j<=str2.length();j++){
                //当两个字符相等时，则让上一个字符结尾的最长公共子串长度+1
                if (str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                    if (max<dp[i][j]){
                        max=dp[i][j];
                        //在str1中，公共最长子串最后一个字符的索引
                        index=i-1;
                    }
                }
            }
        }
        if (max==0){
            return "";
        }
        String substring = str1.substring(index - max + 1, index + 1);
        return substring;
    }

    public String LCSBetter (String str1, String str2) {
        if (str1.length()==0||str2.length()==0){
            return "";
        }
        int index=0;
        int max=0;
        //往后面多申请一位，dp[0][j]和dp[i][0]的值都为0
        int[] dp=new int[str2.length()+1];
        for (int i=1;i<=str1.length();i++){
            for (int j=str2.length();j>=1;j--){
                //初始化dp[j]为0
                dp[j]=0;
                if (str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[j]=dp[j-1]+1;
                    if (max<dp[j]){
                        max=dp[j];
                        //在str1中，公共最长子串最后一个字符的索引
                        index=i-1;
                    }
                }
            }
        }
        if (max==0){
            return "";
        }
        String substring = str1.substring(index - max + 1, index + 1);
        return substring;
    }
}
