package leetcode每日一题;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//给你两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。
//
//        请你找出 nums1 中每个元素在 nums2 中的下一个比其大的值。
//
//        nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。
//
//         
//
//        示例 1:
//
//        输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
//        输出: [-1,3,-1]
//        解释:
//        对于 num1 中的数字 4 ，你无法在第二个数组中找到下一个更大的数字，因此输出 -1 。
//        对于 num1 中的数字 1 ，第二个数组中数字1右边的下一个较大数字是 3 。
//        对于 num1 中的数字 2 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
//        示例 2:
//
//        输入: nums1 = [2,4], nums2 = [1,2,3,4].
//        输出: [3,-1]
//        解释:
//            对于 num1 中的数字 2 ，第二个数组中的下一个较大数字是 3 。
//        对于 num1 中的数字 4 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
//         
//
//        提示：
//
//        1 <= nums1.length <= nums2.length <= 1000
//        0 <= nums1[i], nums2[i] <= 104
//        nums1和nums2中所有整数 互不相同
//        nums1 中的所有整数同样出现在 nums2 中
//         
//
//        进阶：你可以设计一个时间复杂度为 O(nums1.length + nums2.length) 的解决方案吗？
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/next-greater-element-i
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class _496_下一个更大元素I_easy {
    //思路：单调栈，建立单调递增栈
    //1.从后往前遍历nums2，与栈顶元素比较，弹出不符合单调递增的元素
    //2.筛选完毕后，此时栈顶元素就是比当前元素大的第一个右边元素，使用hash表存储起来
    //3.然后将当前元素推入栈顶
    //4.重复123步
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums2.length==1){
            return new int[]{0};
        }
        Map<Integer,Integer> map=new HashMap<>();
        Stack<Integer> stack=new Stack<>();
        for (int i=nums2.length-1;i>=0;i++){
            int num=nums2[i];
            while (!stack.isEmpty()&&stack.peek()<=num){
                stack.pop();
            }
            int value=stack.isEmpty()?-1:stack.peek();
            map.put(num,value);
            stack.push(num);
        }

        for (int i = 0; i < nums1.length; i++) {
            nums1[i]=map.get(nums1[i]);
        }
        return nums1;
    }
}
