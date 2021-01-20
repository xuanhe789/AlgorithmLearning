package 剑指;

public class 二进制中1的个数 {
    public int hammingWeight(int n) {
        if (n==0){
            return 0;
        }
        int sum=0;
        while (n!=0){
            int i = n & 1;
            if (i==1){
                sum++;
            }
            n=n>>>1;
        }
        return sum;
    }
}
