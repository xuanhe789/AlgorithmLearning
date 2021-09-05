package leetcodeHOT100;

import java.util.Arrays;
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
        int area = 0, n = heights.length;
        // 遍历每个柱子，以当前柱子的高度作为矩形的高 h，
        // 从当前柱子向左右遍历，找到矩形的宽度 w。
        for (int i = 0; i < n; i++) {
            int w = 1, h = heights[i], j = i;
            while (--j >= 0 && heights[j] >= h) {
                w++;
            }
            j = i;
            while (++j < n && heights[j] >= h) {
                w++;
            }
            area = Math.max(area, w * h);
        }
        return area;
    }

    //2.单调栈,单调递增，emmm这道题不知道该怎么说
    //思路就是遍历数组，以每个柱子的高度作为矩形的长，然后分别找到左边和右边第一个小于当前柱子的柱子
    // 通过左右柱子的下标即可计算出以当前柱子的高度为长的矩形的最大宽度，即可求该矩形的最大面积，然后和max比较
    public int largestRectangleAreaStack(int[] heights) {
        if (heights.length==1){
            return heights[0];
        }
        int max=0;
        //创建一个单调栈，栈顶元素存储的是还未计算矩形面积的最大高度柱子的下标
        Stack<Integer> stack=new Stack<>();
        //将第一个柱子入栈，从第二个柱子开始遍历
        stack.add(0);
        for (int i=1;i<heights.length;i++){
            //当前柱子高度小于栈顶的柱子高度时，即可直到当前柱子就是栈顶柱子右边的一个小的柱子
            while (!stack.isEmpty()&&heights[stack.peek()]>heights[i]){
                //然后再通过弹栈，下一个栈顶元素就是左边第一小的柱子
                Integer now = stack.pop();
                while (!stack.isEmpty()&&heights[now]==heights[stack.peek()]){
                    now=stack.peek();
                    stack.pop();
                }
                //如果栈为空，说明左边柱子的都比栈顶的柱子大，可以将他们宽度都计算在内，此时宽度的左边界为-1(包含了左边所有的柱子)
                Integer left=stack.isEmpty()?-1:stack.peek();
                max=Math.max(max,(i-left-1)*heights[now]);
            }
            stack.add(i);
        }
        //如果右边已经没有柱子了，那么还需要计算栈的里面柱子的面积，思路和上面是一样的
        //设一个无限小的宽度右边界，下标为最后一个柱子的下标+1
        int right=heights.length;
        while (!stack.isEmpty()){
            Integer now = stack.pop();
            while (!stack.isEmpty()&&heights[now]==heights[stack.peek()]){
                now=stack.peek();
                stack.pop();
            }
            Integer left=stack.isEmpty()?-1:stack.peek();
            max=Math.max(max,(right-left-1)*heights[now]);
        }
        return max;
    }

    //2.单调栈，加入哨兵优化代码
    public int largestRectangleAreaStack2(int[] heights) {
        if (heights.length==1){
            return heights[0];
        }
        int max=0;
        int[] newHeights = Arrays.copyOf(heights, heights.length + 1);
        Stack<Integer> stack=new Stack<>();
        stack.add(0);
        for (int i=1;i<newHeights.length;i++){
            while (!stack.isEmpty()&&heights[stack.peek()]>heights[i]){
                Integer now = stack.pop();
                while (!stack.isEmpty()&&heights[now]==heights[stack.peek()]){
                    now=stack.peek();
                    stack.pop();
                }
                Integer left=stack.isEmpty()?-1:stack.peek();
                max=Math.max(max,(i-left-1)*heights[now]);
            }
            stack.add(i);
        }
        return max;
    }
}
