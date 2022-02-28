package 动态规划从0开始;

import com.sun.javaws.jnl.MatcherReturnCode;

public class _20_接雨水 {
    /*
    * 动态规划，备忘录解法，分别使用两个数组记录【i位置左边最大的柱子】，【i位置右边最大的柱子】
    * 然后从第二个柱子开始遍历，找到当前柱子【最左边最高的柱子】和【最右边最高的柱子】，取他们中的最小值
    * 如果最小值高于当前柱子，说明当前柱子能存雨水。
    * */
    public int trap(int[] height) {
        if (height.length==0){
            return 0;
        }
        //动态规划，分别记忆i位置左边最大的柱子，i位置右边最大的柱子
        int[] maxLeft=new int[height.length];
        int[] maxRight=new int[height.length];
        maxLeft[0]=height[0];
        maxRight[height.length-1]=height[height.length-1];
        int result=0;
        //初始化左边最大柱子高度
        for (int i=1;i<height.length-1;i++){
            maxLeft[i]=Math.max(maxLeft[i-1],height[i]);
        }
        // 初始化右边最大柱子高度
        for (int i=height.length-2;i>=1;i--){
            maxRight[i]=Math.max(maxRight[i+1],height[i]);
        }
        for (int i = 1; i < height.length-1; i++) {
            int minHigh=Math.min(maxLeft[i],maxRight[i]);
            if (minHigh>height[i]){
                result+=minHigh-height[i];
            }
        }
        return result;
    }
}
