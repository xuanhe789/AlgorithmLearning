package 剑指;

import java.util.*;

//知耻而后勇，知弱而图强
//给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
//
//        示例:
//
//        输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//        输出: [3,3,5,5,6,7]
//        解释:
//
//        滑动窗口的位置                最大值
//        ---------------               -----
//        [1  3  -1] -3  5  3  6  7       3
//        1 [3  -1  -3] 5  3  6  7       3
//        1  3 [-1  -3  5] 3  6  7       5
//        1  3  -1 [-3  5  3] 6  7       5
//        1  3  -1  -3 [5  3  6] 7       6
//        1  3  -1  -3  5 [3  6  7]      7
//         
//
//        提示：
//
//        你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
public class _59_I滑动窗口的最大值 {
    //最优做法：单调队列，队列里面的元素始终是有序的，队首最大，队尾最小
    public int[] maxSlidingWindowBest(int[] nums, int k) {
        if (k==0){
            return new int[]{};
        }
        //队列存储值的下标，队列中的第一个元素是滑动窗口里面最大的值的下标
        Deque<Integer> deque=new LinkedList();
        int[] result=new int[nums.length-k+1];
        deque.addFirst(0);
        //初始化第一个滑动窗口
        for (int i=0;i<k;i++){
            //把队列中比当前元素值小的元素清除掉
            while (!deque.isEmpty()&&nums[i]>=nums[deque.peekLast()]){
                deque.removeLast();
            }
            //将当前元素加入队列
            deque.addLast(i);
        }
        result[0]=nums[deque.peek()];
        for (int i=k;i<nums.length;i++){
            //如果当前元素大于队列中最大的值，说明当前元素是滑动窗口中是最大的，把队列之前的全部清除掉
            if (nums[i]>=nums[deque.peek()]){
                deque.clear();
            }
            //如果队列第一个元素已不在滑动窗口中，则删掉队首元素，队列中第二个元素暂时充当最大元素
            else if (deque.peek()<i-k+1){
                deque.removeFirst();
            }
            //将队列中比当前元素小的元素全部清除掉
            while (!deque.isEmpty()&&(deque.peekLast()<i-k+1||nums[i]>=nums[deque.peekLast()])){
                deque.removeLast();
            }
            deque.addLast(i);
            //加入结果集
            result[i-k+1]=nums[deque.peek()];
        }
        return result;
    }

    //个人思路：思路比较简单，暴力搜索
    //1.用两个变量分辨存储当前滑动窗口的最大值和最大值的下标
    //2.先找出第一个滑动窗口内的最大值和索引
    //3.然后下标从k开始遍历
    //4.1如果下个滑动窗口的最后一个值大于上个滑动窗口的最大值，则直接更新max和index
    //4.2如果小于，并且最大值已经不在当前滑动窗口中，则重新遍历寻找最大值和下标
    //4.3如果小于，并且最大值还在当前滑动窗口中，则保持不变
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k==0){
            return new int[]{};
        }
        List<Integer> list=new ArrayList<>();
        int max=Integer.MIN_VALUE;
        int index=0;
        for (int i=0;i<k;i++){
            if (nums[i]>max){
                max=nums[i];
                index=i;
            }
        }
        list.add(max);
        for (int i=k;i<nums.length;i++){
            if (nums[i]>max){
                max=nums[i];
                index=i;
            }else if (i-k+1>index){
                max=Integer.MIN_VALUE;
                for (int j=i-k+1;j<=i;j++){
                    if (nums[j]>max){
                        max=nums[j];
                        index=j;
                    }
                }
            }
            list.add(max);
        }
        int[] result=new int[list.size()];
        for (int i=0;i<result.length;i++){
            result[i]=list.get(i);
        }
        return result;
    }


}
