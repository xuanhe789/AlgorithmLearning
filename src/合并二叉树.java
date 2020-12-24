//给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
//
//        你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
//
//        链接：https://leetcode-cn.com/problems/merge-two-binary-trees
public class 合并二叉树 {
    //递归实现，思路：先判断左右树是否为空，全为空返回null,如果左子树为空，返回右子树，如果右子树为空，返回左子树
    //如果全部为空，创建新的树节点，值为左子树与右子树之和。
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1==null&&t2==null){
            return null;
        }
        else if (t1==null){
            return t2;
        }
        else if (t2==null){
            return t1;
        }
        else {
            TreeNode root= new TreeNode(t1.val+t2.val);
            root.left=mergeTrees(t1.left,t2.left);
            root.right=mergeTrees(t1.right,t2.right);
            return root;
        }
    }
}
