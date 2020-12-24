import java.util.LinkedList;

//给定一个二叉树，检查它是否是镜像对称的。
//
//
//
//        例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
public class 对称二叉树 {
    public boolean isSymmetric(TreeNode root) {
        if (root==null){
            return true;
        }
        return isMirror(root.left,root.right);
    }
    //递归解法：传二叉树的根节点的左右子树节点，如果全为空返回true，只有一个为空则说明不对称
    //当两个都不为空时，判断两个节点的值是否相同，如果相同接着判断他们的左右子树
    public boolean isMirror(TreeNode treeNode1,TreeNode treeNode2){
        if (treeNode1==null&&treeNode2==null){
            return true;
        }
        else if (treeNode1==null||treeNode2==null){
            return false;
        }
        else {
            if (treeNode1.val==treeNode2.val){
                return (isMirror(treeNode1.left,treeNode2.right)&&isMirror(treeNode1.right,treeNode2.left));
            }
            return false;
        }
    }
    //迭代法解决
    public boolean isSymmetric1(TreeNode root) {
        if (root==null){
            return true;
        }
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.add(root.left);
        treeNodes.add(root.right);
        while (!treeNodes.isEmpty()){
            TreeNode treeNode2 = treeNodes.poll();
            TreeNode treeNode1 = treeNodes.poll();
            if (treeNode1==null&&treeNode2==null){
                continue;
            }
            else if (treeNode1==null||treeNode2==null){
                return false;
            }
            else {
                if (treeNode1.val==treeNode2.val){
                    treeNodes.add(treeNode1.left);
                    treeNodes.add(treeNode2.right);
                    treeNodes.add(treeNode1.right);
                    treeNodes.add(treeNode2.left);
                    continue;
                }
                return false;
            }
        }
        return true;
    }

}
