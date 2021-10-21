package leetcodeHOT100;

import java.util.*;

//给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
//
//        返回滑动窗口中的最大值。
//
//         
//
//        示例 1：
//
//        输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
//        输出：[3,3,5,5,6,7]
//        解释：
//        滑动窗口的位置                最大值
//        ---------------               -----
//        [1  3  -1] -3  5  3  6  7       3
//        1 [3  -1  -3] 5  3  6  7       3
//        1  3 [-1  -3  5] 3  6  7       5
//        1  3  -1 [-3  5  3] 6  7       5
//        1  3  -1  -3 [5  3  6] 7       6
//        1  3  -1  -3  5 [3  6  7]      7
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/sliding-window-maximum
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class _239_滑动窗口最大值_hard {
    //双向单调递减队列解决滑动窗口最大值问题
    //1.遍历数组元素，由于是单调递减的，所以队尾的元素是最小的
    //2.将当前元素和队尾元素比较，为了保证队列单调递减，如果当前元素比队尾元素大，则将移除队尾元素
    //3.循环比较队尾元素和当前元素，当队列为空或者当前元素比队尾元素小，比较才会停下来
    //4.然后将当前元素加入队尾
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length==1){
            return new int[]{nums[0]};
        }
        int index=0;
        int[] result=new int[nums.length-k+1];
        LinkedList<Integer> queue=new LinkedList();
        for (int i = 0; i <k ; i++) {
            //如果当前队列不为空并且队尾元素小于当前元素，移除队尾元素
            while (!queue.isEmpty()&&nums[queue.peekLast()]<=nums[i]){
                queue.removeLast();
            }
            queue.add(i);
        }
        result[index++]=nums[queue.peek()];
        for (int i = k; i < nums.length; i++) {
            //如果当前队列不为空并且队尾元素小于当前元素，移除队尾元素
            while (!queue.isEmpty()&&(queue.peekLast()<i-k+1||nums[queue.peekLast()]<=nums[i])){
                queue.removeLast();
            }
            //还需要将不在滑动窗口内的队头元素移除
            while (!queue.isEmpty()&&queue.peekFirst()<i-k+1){
                queue.removeFirst();
            }
            queue.add(i);
            result[index++]=nums[queue.peekFirst()];
        }

        return result;
    }
}
