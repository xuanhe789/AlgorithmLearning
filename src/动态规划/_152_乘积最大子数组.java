package 动态规划;

public class _152_乘积最大子数组 {

    public int maxProduct(int[] nums) {
        if (nums==null || nums.length==0){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        //用于存储遍历到当前位置乘积最小的值，乘积中必包含当前位置的数
        int nowMin = 1;
        //用于存储遍历到当前位置乘积最大的值，乘积中必包含当前位置的数
        int nowMax = 1;
        for (int i = 0; i < nums.length; i++) {
            //如果当前数字<0，则最高和最低呼唤
            if (nums[i]<0){
                int temp = nowMax;
                nowMax=nowMin;
                nowMin=temp;
            }
            nowMax=Math.max(nowMax*nums[i],nums[i]);
            nowMin=Math.min(nowMin*nums[i],nums[i]);
            max=nowMax>max?nowMax:max;
        }
        return max;
    }


    /*
    * 动态规划，使用双层空间，内存超出限制
    * */
    public int maxProductDP1(int[] nums) {
        if (nums==null || nums.length==0){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int[][] dp = new int[nums.length][nums.length];
        for (int i=0;i<nums.length;i++){
            dp[i][i]=nums[i];
            max=max<nums[i]?nums[i]:max;
        }
        for (int i=1;i<nums.length;i++){
            for (int j=0;j<i;j++){
                dp[j][i]=dp[j][i-1] * nums[i];
                max=max<dp[j][i]?dp[j][i]:max;
            }
        }
        return max;
    }
}
