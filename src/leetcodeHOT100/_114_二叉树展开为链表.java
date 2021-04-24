package leetcodeHOT100;

import java.util.LinkedList;
//知耻而后勇，知弱而图强
//给你二叉树的根结点 root ，请你将它展开为一个单链表：
//
//        展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
//        展开后的单链表应该与二叉树 先序遍历 顺序相同。
//         
//
//        示例 1：
//
//
//        输入：root = [1,2,5,3,4,null,6]
//        输出：[1,null,2,null,3,null,4,null,5,null,6]
//        示例 2：
//
//        输入：root = []
//        输出：[]
//        示例 3：
//
//        输入：root = [0]
//        输出：[0]
//         
//
//        提示：
//
//        树中结点数在范围 [0, 2000] 内
//        -100 <= Node.val <= 100
//         
//
//        进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？
public class _114_二叉树展开为链表 {
    //O(1)做法,如果当前节点左子树不为空，则找到左子树的最右节点theRight
    // 将当前节点的右子树插入到theRight的右子树，然后将左子树移动到右节点
    public void flattenBest(TreeNode root) {
        TreeNode cur=root;
        while (cur!=null){
            if (cur.left!=null){
                TreeNode theRight=cur.left;
                while (theRight.right!=null){
                    theRight=theRight.right;
                }
                theRight.right=cur.right;
                cur.right=cur.left;
                cur.left=null;
            }
            cur=cur.right;
        }
    }
    //很简单的一道题，定义一个队列
    //对树进行前序遍历，将节点依次放入队列，然后依次取出来接在右子树就可以啦
    public void flatten(TreeNode root) {
        if(root==null){
            return;
        }
        //前序遍历，将所有的节点加入到队列中
        LinkedList<TreeNode> linkedList=new LinkedList<>();
        pre(linkedList,root);
        TreeNode point = root;
        linkedList.removeFirst();
        point.left=null;
        while (!linkedList.isEmpty()){
            point.right=linkedList.removeFirst();
            point=point.right;
            point.left=null;
        }
    }

    public void pre(LinkedList<TreeNode> linkedList,TreeNode root){
        if (root==null){
            return;
        }
        linkedList.add(root);
        pre(linkedList,root.left);
        pre(linkedList,root.right);
    }
}
