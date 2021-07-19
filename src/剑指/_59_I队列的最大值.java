package 剑指;

import java.util.Deque;
import java.util.LinkedList;

//知耻而后勇，知弱而图强
//请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
//
//        若队列为空，pop_front 和 max_value 需要返回 -1
//
//        示例 1：
//
//        输入:
//        ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
//        [[],[1],[2],[],[],[]]
//        输出: [null,null,null,2,1,2]
//        示例 2：
//
//        输入:
//        ["MaxQueue","pop_front","max_value"]
//        [[],[],[]]
//        输出: [null,-1,-1]
//         
//
//        限制：
//
//        1 <= push_back,pop_front,max_value的总操作数 <= 10000
//        1 <= value <= 10^5
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class _59_I队列的最大值 {
}
//这道题的思路和上一道的滑动窗口是基本一样的
//定义两个队列，一个正常存储数据的先进先出队列queue，一个是队首为队列queue中最大值的队列maxQueue
class MaxQueue {
    //单调递减队列，队首元素为queue中的最大值
    Deque<Integer> maxQueue;
    //正常先进先出队列
    Deque<Integer> queue;
    //初始化队列
    public MaxQueue() {
        maxQueue=new LinkedList<>();
        queue=new LinkedList<>();
    }

    /*
    * 获取队列的最大值，直接从maxQueue中获取
    * */
    public int max_value() {
        if (maxQueue.isEmpty()){
            return -1;
        }
        return maxQueue.peek();
    }

    /*
    * 将新的元素插入队列，同时更新最大值队列，清除maxQueue中比当前元素小的所有元素
    * 因为当前元素是比队列中的元素后进入队列，所以说只要比当前元素小的，都没有机会称为最大值了，所以删掉
    * */
    public void push_back(int value) {
        queue.addLast(value);
        while (!maxQueue.isEmpty()&&value>=maxQueue.peekLast()){
            maxQueue.removeLast();
        }
        maxQueue.addLast(value);
    }
    /*
    * 弹出queue中的队首元素，同时判断更新maxQueue
    * */
    public int pop_front() {
        if (queue.isEmpty()){
            return -1;
        }
        Integer front = queue.removeFirst();
        if (maxQueue.peekFirst().equals(front)) {
            maxQueue.removeFirst();
        }
        return front;
    }
}
