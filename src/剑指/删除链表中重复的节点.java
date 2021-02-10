package 剑指;

public class 删除链表中重复的节点 {
    //三指针
    public ListNode deleteDumplication(ListNode head){
        if (head.next==null){
            return head;
        }

        ListNode first=new ListNode(-1);
        first.next=head;
        //pre节点始终都在head的前面
        ListNode pre=first;
        while (head!=null&&head.next!=null){
            //判断两个节点是否相等
            if (head.val==head.next.val){
                //记录相等节点的值，head接着往下走，直到找到与val不相等的节点
                int val=head.val;
                head=head.next;
                //该循环往下搜索，直到找到
                while (head!=null&&head.val==val){
                    head=head.next;
                }
                //删除这个值节点
                pre.next=head;
            }
            else {
                pre=pre.next;
                head=head.next;
            }
        }
        return first.next;
    }
}
