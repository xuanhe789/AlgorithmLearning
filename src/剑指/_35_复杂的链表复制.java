package 剑指;

import java.util.HashMap;
import java.util.Map;

//请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class _35_复杂的链表复制 {
    //HashMap解法，复制每个链表Node的时候，用Hash表存储原链表节点Node的复制节点Node'
    //然后第二次遍历链表，利用Hashmap中Node和Node'的映射关系，进行对复制链表节点的random进行赋值
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        Node pre = new Node(0);
        Node cur = pre;
        Node old = head;
        //1.构建新的链表
        while (old != null) {
            Node node = new Node(old.val);
            map.put(old, node);
            cur.next = node;
            cur = cur.next;
            old = old.next;
        }
        Node curRandom = pre.next;
        //利用HashMap为新链表的random赋值
        while (head != null) {
            if (head.random == null) {
                head = head.next;
                curRandom = curRandom.next;
                continue;
            }
            Node random = map.get(head.random);
            curRandom.random = random;
            curRandom = curRandom.next;
            head = head.next;
        }
        return pre.next;
    }

    //拼接与拆分法
    public Node copyRandomList2(Node head) {
        if (head == null) {
            return null;
        }
        //1.拼接链表
        Node cur = head;
        while (cur != null) {
            Node node = new Node(cur.val);
            node.next = cur.next;
            cur.next = node;
            cur = node.next;
        }
        //2.给复制节点的random赋值
        Node cur1 = head;
        while (cur1 != null) {
            if (cur1.random != null) {
                cur1.next.random = cur1.random.next;
            }
            cur1 = cur1.next.next;
        }
        //3.拆分链表
        Node result = head.next, result1 = head.next, pre = head;
        while (result.next != null) {
            pre.next = pre.next.next;
            result.next = result.next.next;
            pre = pre.next;
            result = result.next;
        }
        pre.next=null;
        return result1;
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
