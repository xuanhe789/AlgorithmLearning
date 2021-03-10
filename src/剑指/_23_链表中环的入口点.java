package 剑指;


//这道题和Hot100中环形链表2是同一道题
public class _23_链表中环的入口点 {
    public ListNode detectCycleBest(ListNode head) {
        if (head==null||head.next==null){
            return null;
        }
        ListNode slow=head;
        ListNode fast=head;
        Boolean flag=false;
        while (fast!=null&&fast.next!=null){

            fast=fast.next.next;
            head=head.next;
            //这一步得放到下面来，因为一开快慢指针都指向head
            if (head==fast){
                flag=true;
                break;
            }
        }
        if (flag==false){
            return null;
        }
        slow=head;
        while (slow!=head){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
}
