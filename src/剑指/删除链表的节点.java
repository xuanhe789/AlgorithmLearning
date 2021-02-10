package 剑指;

public class 删除链表的节点 {
    public ListNode deleteNode1(ListNode head, ListNode target) {
        if (head==target&&head.next==null){
            head=null;
            return head;
        }
        else if (head==target){
            ListNode next=head.next;
            head.next=null;
            head=next;
            return head;
        }
        else if (target.next!=null){
            target.val=target.next.val;
            target.next=target.next.next;
            return head;
        }
        else {
            ListNode cur=head.next;
            while (cur!=null){
                if (cur.next==target){
                    cur.next=null;
                    break;
                }
                cur=cur.next;
            }
            return head;
        }

    }


    //leetCode的题
    public ListNode deleteNode(ListNode head, int val) {
        if (head.val==val){
            ListNode next=head.next;
            head.next=null;
            head=next;
            return head;
        }
        ListNode cur=head.next;
        ListNode pre=head;
        while (cur!=null){
            if (cur.val==val){
                pre.next=cur.next;
                cur.next=null;
                return head;
            }
            cur=cur.next;
            pre=pre.next;
        }
        return null;
    }
}
