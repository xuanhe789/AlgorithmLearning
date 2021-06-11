package 剑指;
//知耻而后勇，知弱而图强
//给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
//
//         
//
//        示例 1:
//
//        输入: 12258
//        输出: 5
//        解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
//         
//
//        提示：
//
//        0 <= num < 231
public class _46_把数字翻译成字符串 {
    //动态规划，青蛙跳台阶问题
    //dp[i]表示数字的前i+1部分转换成不同字符串的数量
    //转移方程:如果X(i-1)X(i)<=25并且>=10，那么dp[i]=dp[i-1]+[i-2]
    //否则，dp[i]=dp[i-1]。
    //可以用int两个变量代替dp[i-1]、[i-2],优化空间
    public int translateNum(int num) {
        String str = String.valueOf(num);
        int dp_1=1,dp_2=1;
        for (int i=1;i<str.length();i++){
            //截取当前和后一位形成新的字符串
            String substring = str.substring(i - 1, i + 1);
            //判断是否小于25并且大于10
            if (substring.compareTo("25")<=0&&substring.compareTo("10")>=0){
                //对应dp[i]=dp[i-1]+[i-2]
                int temp=dp_1;
                dp_1=dp_2+dp_1;
                dp_2=temp;
            }else {
                //对应dp[i]=dp[i-1]。
                //这一步是更新dp[i-2]
                dp_2=dp_1;
            }
        }
        return dp_1;
    }

    //解题方法和上面一致，只不过是从右到左遍历，剑指offer作者的思路也是从右到左
    public int translateNum1(int num) {
        String str = String.valueOf(num);
        int dp_1=1,dp_2=1;
        for (int i=str.length()-2;i>=0;i--){
            //截取当前和后一位形成新的字符串
            String substring = str.substring(i , i + 2);
            //判断是否小于25并且大于10
            if (substring.compareTo("25")<=0&&substring.compareTo("10")>=0){
                //对应dp[i]=dp[i-1]+[i-2]
                int temp=dp_1;
                dp_1=dp_2+dp_1;
                dp_2=temp;
            }else {
                //对应dp[i]=dp[i-1]。
                //这一步是更新dp[i-2]
                dp_2=dp_1;
            }
        }
        return dp_1;
    }

    //最佳解法，数字取余，替代了转化字符串，空间复杂度优化为O（1）
    public int translateNum2(int num) {
        if (num<10){
            return 1;
        }
        String str = String.valueOf(num);
        int dp_1=1,dp_2=1;
        while (num!=0){
            int doub=num%100;
            if (doub>=10&&doub<=25){
                int temp=dp_1;
                dp_1=dp_2+dp_1;
                dp_2=temp;
            }else {
                dp_2=dp_1;
            }
            num=num/10;
        }
        return dp_1;
    }
}
