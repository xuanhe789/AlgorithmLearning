package leetcodeHOT100;

import java.util.Arrays;
import java.util.PriorityQueue;

//在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
//
//        示例 1:
//
//        输入: [3,2,1,5,6,4] 和 k = 2
//        输出: 5
//        示例 2:
//
//        输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//        输出: 4
//        说明:
//
//        你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
//
//        通过次数255,937提交次数395,307
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class 数组中第K个最大元素 {
    //优先队列解法，堆
    public int findKthLargest1(int[] nums, int k) {
        if (nums.length==1){
            return nums[0];
        }
        // 使用一个含有 k个元素的最小堆，lambda 表达式应写成：(a, b) -> a-b
        PriorityQueue<Integer> heap = new PriorityQueue<>(k,(a,b) -> a-b);
        for (int i=0;i<k;i++){
            heap.add(nums[i]);
        }
        for (int i=k;i<nums.length;i++){
            Integer peek = heap.peek();
            //如果当前元素大于堆顶元素(堆中最小的元素)，将堆顶元素移除，将当前元素加入堆
            if(nums[i]>peek){
                heap.poll();
                heap.add(nums[i]);
            }
        }
        //当遍历过后，堆中剩余的元素就是前K大的k个元素，由于是最小堆，所有堆顶元素就是第k大元素
        return heap.peek();
    }

    //暴力法，低级解法
    public int findKthLargest(int[] nums, int k) {
        if (nums.length==1){
            return nums[0];
        }
        int number=1;
        Arrays.sort(nums);
        if (k==1){
            return nums[nums.length-1];
        }
        int i=nums.length-1;
        for (i=nums.length-2;i>=0;i--){
            if (nums[i]!=nums[i+1]){
                number++;
            }
            if(k==number){
                break;
            }
        }
        return nums[i];
    }
}

