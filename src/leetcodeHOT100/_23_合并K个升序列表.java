package leetcodeHOT100;

import java.util.Comparator;
import java.util.PriorityQueue;

//知耻而后勇，知弱而图强
//给你一个链表数组，每个链表都已经按升序排列。
//
//        请你将所有链表合并到一个升序链表中，返回合并后的链表。
//
//         
//
//        示例 1：
//
//        输入：lists = [[1,4,5],[1,3,4],[2,6]]
//        输出：[1,1,2,3,4,4,5,6]
//        解释：链表数组如下：
//        [
//        1->4->5,
//        1->3->4,
//        2->6
//        ]
//        将它们合并到一个有序链表中得到。
//        1->1->2->3->4->4->5->6
//        示例 2：
//
//        输入：lists = []
//        输出：[]
//        示例 3：
//
//        输入：lists = [[]]
//        输出：[]
//         
//
//        提示：
//
//        k == lists.length
//        0 <= k <= 10^4
//        0 <= lists[i].length <= 500
//        -10^4 <= lists[i][j] <= 10^4
//        lists[i] 按 升序 排列
//        lists[i].length 的总和不超过 10^4
public class _23_合并K个升序列表 {
    //我是真的垃圾，优先队列（堆）都想不到
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length==0||(lists.length==1&&lists[0]==null)){
            return null;
        }
        ListNode first=new ListNode();
        ListNode cur=first;
        //创建最小堆
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });
        //将不为空的链表节点加入最小堆排序
        for (ListNode list : lists) {
            if(list!=null){
                minHeap.add(list);
            }
        }
        //如果堆不为空，则取出堆顶元素插入链表
        while (!minHeap.isEmpty()){
            //取出堆顶元素插入链表
            cur.next=minHeap.poll();
            cur=cur.next;
            //如果堆顶元素还有后续节点，则加入堆排序
            if (cur.next!=null){
                minHeap.add(cur.next);
            }
        }
        return first.next;
    }


    //分治思想，归并排序的思想，两两合并，返回合并后的新链表，新链表继续合并，最后合并成一个大链表
    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists.length==0||(lists.length==1&&lists[0]==null)){
            return null;
        }
        //分治思想
        return merge(lists,0,lists.length-1);
    }

    public ListNode merge(ListNode[] lists,int left,int right){
        //如果left==right，说明只有一个链表，直接返回
        if (left==right){
            return lists[left];
        }
        int mid=left+(right-left)/2;
        ListNode leftNode=merge(lists,left,mid);
        ListNode rightNode=merge(lists,mid+1,right);
        return mergeNode(leftNode,rightNode);
    }

    //合并两个链表
    public ListNode mergeNode(ListNode leftNode,ListNode rightNode){
        ListNode first=new ListNode();
        ListNode cur=first;
        while (leftNode != null && rightNode != null) {
            if (leftNode.val<=rightNode.val){
                cur.next=leftNode;
                leftNode=leftNode.next;
            }else {
                cur.next=rightNode;
                rightNode=rightNode.next;
            }
            cur=cur.next;
        }
        if (leftNode!=null){
            cur.next=leftNode;
        }
        if (rightNode!=null){
            cur.next=rightNode;
        }
        return first.next;
    }
}
