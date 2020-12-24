import java.util.LinkedList;

public class 翻转二叉树 {
    //递归实现，深度优先
    public TreeNode invertTree(TreeNode root) {
        if (root==null){
            return null;
        }
        if (root.left!=null||root.right!=null){
            //递归反转root的左子树
            TreeNode right=invertTree(root.left);
            //递归反转root的右子树
            TreeNode left=invertTree(root.right);
            //将反转后的右子树赋值给root的左子树
            root.left=left;
            //将反转后的左子树赋值给root的右子树
            root.right=right;
        }
        return root;
    }
    //迭代实现，广度优先，需要创建一个队列来保存元素
    public TreeNode invertTree1(TreeNode root) {
        if (root==null){
            return null;
        }
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.add(root);
        //遍历不为空的树节点，交换他们的左右子树
        while (!treeNodes.isEmpty()){
            //将元素从队列中拿出，然后交换他们的左右子树
            TreeNode node=treeNodes.poll();
            TreeNode left=node.left;
            node.left=node.right;
            node.right=left;
            //判断右子树是否为空，不为空放进队列
            if (node.right!=null){
                treeNodes.add(node.right);
            }
            if (node.left!=null){
                treeNodes.add(node.left);
            }
        }
        return root;
    }
}



 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }
