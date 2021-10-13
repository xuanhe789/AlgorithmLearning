package leetcodeHOT100;

public class _141_环形链表 {
    //经典场景快慢指针，链表成环时，快慢指针一定会相遇
    public boolean hasCycle(ListNode head) {
        if (head==null||head.next==null){
            return false;
        }
        ListNode fast=head;
        ListNode slow=head;
        while (fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            while (slow==fast){
                return true;
            }
        }
        return false;
    }
}
