package 剑指;

import java.util.Stack;

//定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中
//，调用 min、push 及 pop 的时间复杂度都是 O(1)。
public class _30_包含min的栈 {
}

class MinStack{
    //数据栈
    public Stack dataStack;
    //辅助栈
    public Stack minStack;
    //变量最小值
    public int minValue=Integer.MAX_VALUE;
    public MinStack(){
        dataStack=new Stack();
        minStack=new Stack();
    }

    public void push(int x) {
        dataStack.push(x);
        if (x<=minValue){
            minValue=x;
            minStack.push(x);
        }
    }

    public void pop() {
        int pop = (int) dataStack.pop();
        if (pop==minValue){
            minStack.pop();
            if (!minStack.isEmpty()){
                int min= (int) minStack.peek();
                minValue=min;
            }else {
                minValue=Integer.MAX_VALUE;
            }
        }
    }

    public int top() {
        if (!dataStack.isEmpty()){
            return (int) dataStack.peek();
        }
        return 0;
    }

    public int min() {
        return minValue;
    }
}
