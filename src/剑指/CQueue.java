package 剑指;

import java.util.Stack;

//双栈实现队列
public class CQueue {
    Stack<Object> stack1 ;
    Stack<Object> stack2;
    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (stack1.isEmpty()){
            return -1;
        }
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        int result = (int) stack2.pop();
        //还原
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return result;
    }
    //优化时间复杂度
    public int deleteHeadBetter(){
        if (stack1.isEmpty()){
            return -1;
        }
        if (!stack2.isEmpty()){
            stack2.pop();
        }
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        return (int) stack2.pop();
    }
}
