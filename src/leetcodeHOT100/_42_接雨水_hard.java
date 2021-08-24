package leetcodeHOT100;
//知耻而后勇，知弱而图强
//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
//
//         
//
//        示例 1：
//
//
//
//        输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//        输出：6
//        解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
//        示例 2：
//
//        输入：height = [4,2,0,3,2,5]
//        输出：9
//         
//
//        提示：
//
//        n == height.length
//        0 <= n <= 3 * 104
//        0 <= height[i] <= 105
public class _42_接雨水_hard {

    //1.按列求
    //思路：遍历每一列，获取每一列左边的最高墙和右边的最高墙，根据较小的最高墙计算当前这一列能不能积雨水
    public int trap(int[] height) {
        if (height.length==0){
            return 0;
        }
        int sum=0;
        //从第二列开始，到倒数第二列，边界的列是不会有雨水的
        for (int i=1;i<height.length;i++){
            int maxLeft=0;
            int maxRight=0;
            //获取左边最高的墙
            for (int j=i-1;j>=0;j--){
                maxLeft=Math.max(maxLeft,height[j]);
            }
            //获取右边最高的墙
            for (int j=i+1;j<height.length;j++){
                maxRight=Math.max(maxRight,height[j]);
            }
            //如果当前墙的高度等于或高于左右的最高墙任意一个，则当前墙积不了水
            if (height[i]>=maxLeft||height[i]>=maxRight){
                continue;
            }
            //只有左右最高墙都比当前墙高时，当前墙才能积水
            int min=Math.min(maxLeft,maxRight);
            //记录当前墙的积水量
            sum+=min-height[i];
        }
        return sum;
    }

    //2.动态规划，用两个数组分别存储i位置左边的最高墙，和右边的最高墙
    public int trapDO(int[] height) {
        if (height.length==0){
            return 0;
        }
        int sum=0;
        int[] maxLeft=new int[height.length];
        maxLeft[0]=height[0];
        int[] maxRight=new int[height.length];
        maxRight[height.length-1]=height[height.length-1];

        for (int i=1;i<maxLeft.length;i++){
            maxLeft[i]=Math.max(maxLeft[i-1],height[i]);
        }

        for (int i=height.length-2;i>=0;i--){
            maxRight[i]=Math.max(maxRight[i+1],height[i]);
        }
        //从第二列开始，到倒数第二列，边界的列是不会有雨水的
        for (int i=1;i<height.length-1;i++){
            int maxleft=maxLeft[i-1];
            int maxright=maxRight[i+1];
            //如果当前墙的高度等于或高于左右的最高墙任意一个，则当前墙积不了水
            if (height[i]>=maxleft||height[i]>=maxright){
                continue;
            }
            //只有左右最高墙都比当前墙高时，当前墙才能积水
            int min=Math.min(maxleft,maxright);
            //记录当前墙的积水量
            sum+=min-height[i];
        }
        return sum;
    }
}
