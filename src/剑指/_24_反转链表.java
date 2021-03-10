package 剑指;
//定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
//
//         
//
//        示例:
//
//        输入: 1->2->3->4->5->NULL
//        输出: 5->4->3->2->1->NULL
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class _24_反转链表 {
    //三指针
    public ListNode reverseList(ListNode head){
        if (head==null||head.next==null){
            return head;
        }
        //定义pre指针，作用是一直指向反转链表得头节点
        ListNode pre=null;
        //指向当前得链表节点
        ListNode cur=null;
        //指向下一个链表节点
        ListNode next=head;
        while (next!=null){
            cur=next;
            next=next.next;
            cur.next=pre;
            pre=cur;
        }
        return pre;
    }
}
