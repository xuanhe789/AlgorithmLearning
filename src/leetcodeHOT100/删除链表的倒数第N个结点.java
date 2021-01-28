package leetcodeHOT100;
//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
//
//        进阶：你能尝试使用一趟扫描实现吗？
//
//         
//
//        示例 1：
//
//
//        输入：head = [1,2,3,4,5], n = 2
//        输出：[1,2,3,5]
//        示例 2：
//
//        输入：head = [1], n = 1
//        输出：[]
//        示例 3：
//
//        输入：head = [1,2], n = 1
//        输出：[1]
//         
//
//        提示：
//
//        链表中结点的数目为 sz
//        1 <= sz <= 30
//        0 <= Node.val <= 100
//        1 <= n <= sz
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class 删除链表的倒数第N个结点 {
    //三指针
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next==null&&n>1){
            return null;
        }
        ListNode headPoint=head;
        //双指针，pre节点先移动n-1步，after就是那个要删除的节点
        ListNode pre=head,after=head;
        for (int i=0;i<n-1;i++){
            if (pre.next==null){
                return null;
            }
            pre=pre.next;
        }
        //第三指针，记录after的前一个位置，用与删除after节点
        ListNode listNode3=head;
        while (pre.next!=null){
            listNode3=after;
            pre=pre.next;
            after=after.next;
        }
        listNode3.next=after.next;
        //如果after是头节点，说明要删除头节点，返回头节点的下个节点
        return after==head?after.next:head;

    }
}


class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
