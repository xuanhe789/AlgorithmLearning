package 动态规划从0开始;

public class _12_乘积最大子数组 {
    public int maxProduct(int[] nums) {
        if (nums==null || nums.length==0){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int nowMin = 1;
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
}
