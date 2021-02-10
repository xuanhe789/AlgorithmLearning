package leetcodeHOT100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 最小栈 {
    private LinkedList stack;
    private int minValue=Integer.MAX_VALUE;
    public 最小栈() {
        stack=new LinkedList();
    }

    public void push(int x) {
        stack.addFirst(x);
        if (x<minValue){
            minValue=x;
        }
    }

    public void pop() {
        int remove = (int) stack.removeFirst();
        if (remove==minValue){
            minValue=Integer.MAX_VALUE;
            setNewMinValue();
        }
    }

    public int top() {
        int top= (int) stack.getFirst();
        return top;
    }

    public int getMin() {
        return minValue;
    }

    public void setNewMinValue(){
        for (Object o : stack) {
            if ((int)o<minValue){
                minValue= (int) o;
            }
        }
    }
}
