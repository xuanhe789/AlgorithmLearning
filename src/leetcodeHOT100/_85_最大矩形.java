package leetcodeHOT100;

import java.util.*;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;

public class _85_最大矩形 {
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


    class Bank {

        private long[] balance;
        private int length;
        public Bank(long[] balance) {
            this.balance=balance;
            this.length=balance.length;
        }

        public boolean transfer(int account1, int account2, long money) {
            if (account1>length||account2>length||balance[account1]<money){
                return false;
            }
            balance[account1-1]-=money;
            balance[account2-1]+=money;
            return true;
        }

        public boolean deposit(int account, long money) {
            if (account>length){
                return false;
            }
            balance[account-1]+=money;
            return true;
        }


        public boolean withdraw(int account, long money) {
            if (account>length||balance[account-1]<money){
                return false;
            }
            balance[account-1]-=money;
            return true;
        }
    }

    int count=0;

    public int countMaxOrSubsets(int[] nums) {
        if (nums.length==1){
            return 1;
        }
        int max=0;
        for (int num : nums) {
            max|=num;
        }
        dfs(nums,0,0,max);
        return count;
    }

    public void dfs(int[] nums,int index,int num,int max){
        if (num==max){
            count++;
        }
        for (int i=index;i<nums.length;i++){
            dfs(nums,i+1,num|nums[i],max);
        }
    }
}
