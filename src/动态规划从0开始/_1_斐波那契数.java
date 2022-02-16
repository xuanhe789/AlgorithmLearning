package 动态规划从0开始;

public class _1_斐波那契数 {
    public int fib(int n) {
        if(n<2){
            return n;
        }
        int[] dp =new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    /*
    * 空间优化
    * */
    public int fibBest(int n) {
        if(n<2){
            return n;
        }
        int one=0;
        int two=1;
        int now =two;
        for(int i=2;i<=n;i++){
            now=two+one;
            one=two;
            two=now;
        }
        return now;
    }
}
