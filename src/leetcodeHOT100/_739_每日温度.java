package leetcodeHOT100;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

//请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
//
//        例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
//
//        提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/daily-temperatures
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class _739_每日温度 {
    //暴力法
    public int[] dailyTemperatures(int[] T) {
        int length=T.length;
        if (length == 1) {
            return new int[1];
        }
        int[] result=new int[length];
        result[length-1]=0;
        for (int i=0;i<length-1;i++){
            int days=0;
            for (int j=i+1;j<length;j++){
                if (T[i]>=T[j]){
                    days++;
                }
                if (T[i]<T[j]){
                    days++;
                    result[i]=days;
                    break;
                }
                if (j==length){
                    result[i]=0;
                }
            }
        }
        return result;
    }
    //递减栈
    //思路：创建一个栈，遍历整个数组，如果栈不为空，则判断当前温度值是否比栈顶元素的温度值高
    //如果高，则说明这是第一个高于栈顶元素温度的温度，则直接计算两者的下标距离就是结果的值
    public int[] dailyTemperaturesBest(int[] T) {
        int length=T.length;
        if (length == 1) {
            return new int[1];
        }
        int[] result=new int[length];
        Stack<Integer> stack= new Stack<>();
        for (int i=0;i<T.length;i++){
            int temperatures=T[i];
            while (!stack.isEmpty()&&temperatures>T[stack.peek()]){
                Integer index = stack.pop();
                result[index]=i-index;
            }
            stack.push(i);
        }
        return result;
    }
}

