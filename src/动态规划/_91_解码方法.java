package 动态规划;

import java.util.HashMap;
import java.util.Map;
/*一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：

        'A' -> "1"
        'B' -> "2"
        ...
        'Z' -> "26"
        要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：

        "AAJF" ，将消息分组为 (1 1 10 6)
        "KJF" ，将消息分组为 (11 10 6)
        注意，消息不能分组为  (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。

        给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。

        题目数据保证答案肯定是一个 32 位 的整数。

         

        示例 1：

        输入：s = "12"
        输出：2
        解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
        示例 2：

        输入：s = "226"
        输出：3
        解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
        示例 3：

        输入：s = "0"
        输出：0
        解释：没有字符映射到以 0 开头的数字。
        含有 0 的有效映射是 'J' -> "10" 和 'T'-> "20" 。
        由于没有字符，因此没有有效的方法对此进行解码，因为所有数字都需要映射。

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/decode-ways
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class _91_解码方法 {
    private int result;
    /*
    * 回溯法，超时
    * */
    public int numDecodings(String s) {
        if (s.charAt(0)=='0'){
            return 0;
        }
        int length = s.length();
        dfs(s, length,0,1);
        if (length>1){
            dfs(s,length,0,2);
        }
        return result;
    }

    private void dfs(String source, int strLength, int index, int checkLength){
        if (source.charAt(index)=='0'){
            return;
        }
        int check = Integer.valueOf(source.substring(index, index + checkLength));
        if (check<1||check>26){
            return;
        }
        if (strLength==index+checkLength){
            result++;
            return;
        }
        if (strLength-1>=index+checkLength){
            dfs(source,strLength,index+checkLength,1);
        }
        if (strLength-1>index+checkLength){
            dfs(source,strLength,index+checkLength,2);
        }
    }

    /*
     * 动态规划，优化空间复杂度，由于dp[i]只和dp[i-1]和dp[i-2]有关，因此
     * */
    public int numDecodingsDPBest(String s) {
        if (s.charAt(0)=='0'){
            return 0;
        }
        int prev1=1;
        int prev2=1;
        int now=1;
        for (int i=1;i<s.length();i++){
            if (s.charAt(i)=='0'){
                Integer value = Integer.valueOf(s.charAt(i - 1)-'0');
                if (value<3&&value>0){
                    now=prev1;
                    prev1=prev2;
                    prev2=now;
                    continue;
                }else {
                    return 0;
                }
            }
            now=prev2;
            if (s.charAt(i-1)=='0'){
                prev1=prev2;
                prev2=now;
                continue;
            }
            Integer check = Integer.valueOf(s.substring(i - 1, i+1));
            if (check<=26){
                now+=prev1;
            }
            prev1=prev2;
            prev2=now;
        }
        return now;
    }

    /*
     * 动态规划，这道题类似于【上台阶问题】,都是从前一个字符和前二个字符得到当前结果
     * 1.状态定义：dp[i]表示s的前i个字符可组成的组合数
     * 2.状态转移方程
     * 2.1 当i-1个字符为0时，则需要判断第i-2个字符是否大于2，如果大于2或者等于0，则无法组合，直接return0
     * 如果符合，则dp[i]=dp[i-2]
     * 2.2 当i-1位置的字符不为0，并且前一个字符为0时，dp[i]=dp[i-1]
     * 2.3 当i-1位置的字符不为0，并且第i-1和i-2组成的数字<=26时，dp[i]=dp[i-1]+dp[i-2]
     * */
    public int numDecodingsDP(String s) {
        if (s.charAt(0)=='0'){
            return 0;
        }
        int[] dp = new int[s.length()+1];
        dp[0]=1;
        dp[1]=1;
        for (int i=2;i<dp.length;i++){
            if (s.charAt(i-1)=='0'){
                Integer value = Integer.valueOf(s.charAt(i - 2)+"");
                if (value<3&&value>0){
                    dp[i]=dp[i-2];
                    continue;
                }else {
                    return 0;
                }
            }
            dp[i]+=dp[i-1];
            if (s.charAt(i-2)=='0'){
                continue;
            }
            Integer check = Integer.valueOf(s.substring(i - 2, i));
            if (check<=26){
                dp[i]+=dp[i-2];
            }
        }
        return dp[dp.length-1];
    }


}
