package 剑指;
//存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
//
//        返回同样按升序排列的结果链表。
//
//         
//
//        示例 1：
//
//
//        输入：head = [1,1,2]
//        输出：[1,2]
//        示例 2：
//
//
//        输入：head = [1,1,2,3,3]
//        输出：[1,2,3]
//         
//
//        提示：
//
//        链表中节点数目在范围 [0, 300] 内
//        -100 <= Node.val <= 100
//        题目数据保证链表已经按升序排列

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

    //代码优化，双指针
    public ListNode deleteDumplication1(ListNode head){
        if (head.next==null){
            return head;
        }
        ListNode cur=head;
        while (cur!=null&&cur.next!=null){
            //如果当前节点与下个节点相同，则保留当前节点，找到下一个不相同的节点，修改指针指向
            if (cur.val==cur.next.val){
                while (cur.next!=null&&cur.next.val==cur.val){
                    cur.next=cur.next.next;
                }
            }
            cur=cur.next;
        }
        return head;
    }
}
