package leetcodeHOT100;

import java.util.Stack;

//知耻而后勇，知弱而图强
//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
//
//        求在该柱状图中，能够勾勒出来的矩形的最大面积。
//
//         
//
//        示例 1:
//
//
//
//        输入：heights = [2,1,5,6,2,3]
//        输出：10
//        解释：最大的矩形为图中红色区域，面积为 10
//        示例 2：
//
//
//
//        输入： heights = [2,4]
//        输出： 4
//         
//
//        提示：
//
//        1 <= heights.length <=105
//        0 <= heights[i] <= 104
public class _84_柱状图中最大的矩形 {
    //1.暴力解法,超时，最简单的解法
    public int largestRectangleArea(int[] heights) {
        if (heights.length==1){
            return heights[0];
        }
        int max=0;
        for (int i=0;i<heights.length;i++){
            int min=Integer.MAX_VALUE;
            for (int j=i;j<heights.length;j++){
                min=Math.min(min,heights[j]);
                max=Math.max(min*(j-i+1),max);
            }
        }
        return max;
    }

    //2.单调栈
    public int largestRectangleAreaStack(int[] heights) {
        if (heights.length==1){
            return heights[0];
        }
        int max=0;
        Stack<Integer> stack=new Stack<>();
        stack.add(0);
        for (int i=1;i<heights.length;i++){
            int wigth=1;
            while (!stack.isEmpty()&&stack.peek()>heights[i]){
                max=Math.max(max,wigth*heights[stack.peek()]);
                //出栈
                stack.pop();
                //宽度+1
                wigth++;
            }
            stack.add(i);
        }
        int wigth=1;
        while (!stack.isEmpty()){
            max=Math.max(max,heights[wigth*stack.peek()]);
            //出栈
            stack.pop();
            //宽度+1
            wigth++;
        }
        return max;
    }
}
