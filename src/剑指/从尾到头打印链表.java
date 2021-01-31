package 剑指;

import java.util.ArrayList;
import java.util.List;

//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
public class 从尾到头打印链表 {
    public int[] reversePrint(ListNode head) {
        List<Integer> list=new ArrayList<>();
        addValue(head,list);
        int[] arr=new int[list.size()];
        int i=0;
        while(i<arr.length){
            arr[i]=list.get(i);
            i++;
        }
        return arr;
    }
     public void addValue(ListNode listNode,List list){
         if (listNode!=null){
             addValue(listNode.next,list);
             list.add(listNode.val);
         }
     }
}

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
  }
