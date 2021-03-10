package 剑指;
//剑指 Offer 25. 合并两个排序的链表
//        输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
//
//        示例1：
//
//        输入：1->2->4, 1->3->4
//        输出：1->1->2->3->4->4
//        限制：
//
//        0 <= 链表长度 <= 1000
public class _25_合并两个有序链表 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode first = new ListNode(0);
        ListNode current = first;
        while (l1!=null&&l2!=null){
            if (l1.val>=l2.val){
                current.next=l2;
                l2=l2.next;
                current=current.next;
            }else {
                current.next=l1;
                l1=l1.next;
                current=current.next;
            }
        }
        if (l1!=null){
            current.next=l1;
        }
        if (l2!=null){
            current.next=l2;
        }
        return first.next;

    }
}
