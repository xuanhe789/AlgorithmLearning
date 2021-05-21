package 剑指;

import java.util.ArrayList;
import java.util.List;
//知耻而后勇，知弱而图强
//如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
//
//        例如，
//
//        [2,3,4] 的中位数是 3
//
//        [2,3] 的中位数是 (2 + 3) / 2 = 2.5
//
//        设计一个支持以下两种操作的数据结构：
//
//        void addNum(int num) - 从数据流中添加一个整数到数据结构中。
//        double findMedian() - 返回目前所有元素的中位数。
//        示例 1：
//
//        输入：
//        ["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
//        [[],[1],[2],[],[3],[]]
//        输出：[null,null,null,1.50000,null,2.00000]
//        示例 2：
//
//        输入：
//        ["MedianFinder","addNum","findMedian","addNum","findMedian"]
//        [[],[2],[],[3],[]]
//        输出：[null,null,2.00000,null,2.50000]
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class _41_数据流中的中位数 {

}
class MedianFinder{
    List<Integer> list;
    /** initialize your data structure here. */
    public MedianFinder() {
        list=new ArrayList<>();
    }
    //思路：插入的时候使用二分来找到要插入的位置，从而让列表在整个过程中都是有序的
    public void addNum(int num) {
        if (list.size()==0){
            list.add(num);
            return;
        }
        int left=0,right=list.size()-1;
        while (left<right){
            int mid=left+(right-left)/2;
            if (list.get(mid)==num){
                list.add(mid,num);
                return;
            } else if (list.get(mid)>num){
                right=mid;
            }else {
                left=mid+1;
            }
        }
        if (list.get(left)>num){
            list.add(left,num);
        }else {
            list.add(left+1,num);
        }
    }

    public double findMedian() {
        int size = list.size();
        if(size==0){
            return 0.00;
        }
        if (size ==1){
            return list.get(0).doubleValue();
        }
        if (size%2==0){
            int mid=size/2;
            double num1 = list.get(mid).doubleValue();
            double num2 = list.get(mid - 1).doubleValue();
            return (num1+num2)/2;
        }else {
            return list.get(size/2).doubleValue();
        }
    }
}
