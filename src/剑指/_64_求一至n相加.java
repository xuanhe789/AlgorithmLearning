package 剑指;

public class _64_求一至n相加 {
    //使用逻辑短路符
    int result=0;
    public int sumNums(int n) {
        result+=n;
        boolean flage=n>1&&sumNums(n-1)>0;
        return result;
    }
}
