package 动态规划从0开始;

import java.util.List;
/*给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。

        注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。

         

        示例 1：

        输入: s = "leetcode", wordDict = ["leet", "code"]
        输出: true
        解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
        示例 2：

        输入: s = "applepenapple", wordDict = ["apple", "pen"]
        输出: true
        解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
             注意，你可以重复使用字典中的单词。
        示例 3：

        输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
        输出: false*/
public class _19_单词拆分 {
    /*
    * 动态规划，dp[i]表示s的前i个字符是否可由单词组成
    * */
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[0]=true;
        for (int i = 0; i < s.length(); i++) {
            for (String word : wordDict) {
                boolean can=check(word,s,i);
                if (can){
                    int length = word.length();
                    //如果i+length已经为true，则不再计算
                    if (dp[i+length]){
                        continue;
                    }else {
                        //到这里，说明s的[i+1,i+length]字符可由单词组成，需要判断dp[i]是否可由单词组成
                        dp[i+length]=dp[i];
                    }
                }
            }
        }
        return dp[dp.length-1];
    }

    private boolean check(String word, String source, int index) {
        if (word.length()>source.length()-index){
            return false;
        }
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i)==source.charAt(i+index)){
                continue;
            }else {
                return false;
            }
        }
        return true;
    }
}
