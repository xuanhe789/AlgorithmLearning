package leetcodeHOT100;

import java.util.*;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;

public class _85_最大矩形 {
    //单调栈，跟8题4差不多
    //从上往下遍历，用一个数组记录当前行1的高度，然后使用84题的单调栈解决问题
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length==0||matrix[0].length==0){
            return 0;
        }
        int max=0;
        int[] heights=new int[matrix[0].length];
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                if (matrix[i][j]=='0'){
                    heights[j]=0;
                }else {
                    heights[j]+=1;
                }
            }
            max=Math.max(largestRectangleAreaStack(heights),max);
        }
        return max;
    }

    public int largestRectangleAreaStack(int[] heights) {
        if (heights.length==0){
            return 0;
        }
        int max=0;
        int[] newHeight = Arrays.copyOf(heights, heights.length + 1);
        Stack<Integer> stack=new Stack<>();
        for (int i = 0; i < newHeight.length; i++) {
            while (!stack.isEmpty()&&newHeight[stack.peek()]>newHeight[i]){
                //去除重复高度的元素
                Integer now = stack.pop();
                while (!stack.isEmpty()&&newHeight[stack.peek()]==newHeight[now]){
                    stack.pop();
                }
                Integer left=stack.isEmpty()?-1:stack.peek();
                max=Math.max(max,newHeight[now]*(i-left-1));
            }
            stack.add(i);
        }
        return max;
    }

    public void deleteNode(ListNode node) {
        ListNode first=node;
        ListNode cur=first;
        while (cur.next!=null){
            cur.val=cur.next.val;
            if (cur.next.next==null){
                cur.next=null;
                break;
            }
            cur=cur.next;
        }
    }

    public boolean isPerfectSquare(int num) {
        if (num==1){
            return true;
        }
        int left=1;
        int right=num;
        while (left<right){
            int mid = left+(right-left)/2;
            int number=num/mid;
            if (number==mid){
                return true;
            }else if (number>mid){
                right=mid;
            }else {
                left=mid+1;
            }
        }
        return left*left==num;
    }

}
