package 剑指;

import java.util.LinkedList;

public class _36_二叉搜索树与双向链表 {
    MyNode pre,result;
    //双指针,一个结果指针，一个前指针
    //两种方法都是用的中序遍历，因为二叉搜索树的中序遍历就是排序好的节点值
    public MyNode treeToDoublyList1(MyNode root) {
        if (root==null){
            return null;
        }
        inTraversal(root);
        pre.right=null;
        return result;
    }

    public void inTraversal(MyNode node){
        if (node==null){
            return;
        }
        inTraversal(node.left);
        if (pre==null){
            pre=node;
            result=node;
            pre.left=null;
        }else {
            pre.right=node;
            node.left=pre;
            pre=pre.right;
        }
        inTraversal(node.right);

    }
    //暴力法，中序遍历得到的就是排序过的节点，将他们放入一个list，然后通过list将他们串起来
    public MyNode treeToDoublyList(MyNode root) {
        if (root==null){
            return null;
        }
        LinkedList<MyNode> list=new LinkedList<>();
        //中序遍历
        traversal(list,root);
        MyNode result=null;
        MyNode cur=null;
        while (!list.isEmpty()){
            MyNode node = list.removeFirst();
            if (cur==null){
                result=node;
                cur=node;
                cur.left=null;
                cur.right=null;
                continue;
            }
            cur.right=node;
            node.left=cur;
            cur=cur.right;
            cur.right=null;
        }
        return result;
    }
    public void traversal(LinkedList<MyNode> list,MyNode treeNode){
        if (treeNode==null){
            return;
        }
        traversal(list,treeNode.left);
        list.add(treeNode);
        traversal(list,treeNode.right);
    }
}

class MyNode {
    public int val;
    public MyNode left;
    public MyNode right;

    public MyNode() {}

    public MyNode(int _val) {
        val = _val;
    }

    public MyNode(int _val,MyNode _left,MyNode _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};


