package 剑指;
//知耻而后勇，知弱而图强
//我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
//
//         
//
//        示例:
//
//        输入: n = 10
//        输出: 12
//        解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
//        说明:  
//
//        1 是丑数。
//        n 不超过1690。
public class _49_丑数 {
    //动态规划，三指针
    //dp[i]代表第i+1个丑数
    public int nthUglyNumber(int n) {
        //定义三个指针，从0（第一个元素）开始
        int a=0,b=0,c=0;
        int[] dp=new int[n];
        //第一个丑数为1
        dp[0]=1;
        for (int i=1;i<dp.length;i++){
            //取三个中最小的，最小的才能有序，形成有序的丑数数组
            dp[i]=Math.min(Math.min(dp[a]*2,dp[b]*3),dp[c]*5);
            if (dp[i]==dp[a]*2){
                a++;
            }
            if (dp[i]==dp[b]*3){
                b++;
            }
            if (dp[i]==dp[c]*5){
                c++;
            }
        }
        return dp[n-1];
    }
}
