package 剑指;

import java.util.concurrent.ArrayBlockingQueue;

//知耻而后勇，知弱而图强
//输入两个链表，找出它们的第一个公共节点。
//
//        如下面的两个链表：
//
//
//
//        在节点 c1 开始相交。
//
//         
//
//        示例 1：
//
//
//
//        输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
//        输出：Reference of the node with value = 8
//        输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class _52_两个链表的第一个公共节点 {
    //可以用双栈实现，但那个空间复杂度位O(n)，不符合题目要求
    //双指针解法，一种规律吧
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA==null||headB==null){
            return null;
        }
        ListNode A=headA,B=headB;
        while (A!=B){
            A=A==null?headB:A.next;
            B=B==null?headA:B.next;
        }
        return A;
    }

    //我自己的做法，计算两条链表的长度，定义两个指针，让长的链表先跑对应的距离
    //使他们的链表长度相同，然后一起遍历
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        int Aleangth = 0, Bleangth = 0;
        ListNode A = headA, B = headB;
        while (A != null) {
            Aleangth += 1;
            A = A.next;
        }
        while (B != null) {
            Bleangth += 1;
            B = B.next;
        }
        A=headA;
        B=headB;
        int abslouteLength = 0;
        if (Aleangth > Bleangth) {
            abslouteLength = Aleangth - Bleangth;
            while (abslouteLength != 0) {
                A = A.next;
                abslouteLength--;
            }
        } else {
            abslouteLength = Bleangth - Aleangth;
            while (abslouteLength != 0) {
                B = B.next;
                abslouteLength--;
            }
        }
        while (A != null && B != null) {
            if (A==B) {
                return A;
            }
            A=A.next;
            B=B.next;
        }
        return null;
    }
}
