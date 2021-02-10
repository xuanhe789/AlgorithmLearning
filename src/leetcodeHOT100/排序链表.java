package leetcodeHOT100;
//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
//
//        进阶：
//
//        你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
//         
//
//        示例 1：
//
//
//        输入：head = [4,2,1,3]
//        输出：[1,2,3,4]
//        示例 2：
//
//
//        输入：head = [-1,5,3,4,0]
//        输出：[-1,0,3,4,5]
//        示例 3：
//
//        输入：head = []
//        输出：[]
//         
//
//        提示：
//
//        链表中节点的数目在范围 [0, 5 * 104] 内
//        -105 <= Node.val <= 105
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/sort-list
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class 排序链表 {
    //归并排序
    public ListNode sortListBetter(ListNode head) {
        if (head==null||head.next==null){
            return head;
        }
        //快慢指针，或者链表的中位点，然后分割
        ListNode fast=head.next,slow=head;
        while (fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode temp=slow.next;
        slow.next=null;
        //递归分割
        ListNode left=sortListBetter(head);
        ListNode right=sortListBetter(temp);
        //合并
        //定义一个前指针
        ListNode pre=new ListNode(0);
        ListNode h=pre;
        while (left!=null&&right!=null){
            if (left.val<=right.val){
                pre.next=left;
                left=left.next;
            }
            else {
                pre.next=right;
                right=right.next;
            }
            pre=pre.next;
        }
        pre.next=left!=null?left:right;
        return h.next;
    }

    //多指针解法，找到最小值的节点，然后交换他们的值
    //选择排序，时间超出限制
    public ListNode sortList(ListNode head) {
        if (head==null||head.next==null){
            return head;
        }
        ListNode cur=head;
        while (cur!=null){
            int min=cur.val;
            ListNode minNode=cur;
            ListNode copy=cur.next;
            while (copy!=null){
                if (copy.val<min){
                    min=copy.val;
                    minNode=copy;
                }
                copy=copy.next;
            }
            minNode.val=cur.val;
            cur.val=min;
        }
        return head;
    }
}
