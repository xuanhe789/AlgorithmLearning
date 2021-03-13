package 剑指;

public class _28_对称的二叉树 {
    public boolean isSymmetric(TreeNode root) {
        if (root==null){
            return false;
        }
        return validate(root.left,root.right);
    }

    public boolean validate(TreeNode left,TreeNode right){
        if (left==null&&right==null){
            return true;
        }
        if (left==null||right==null){
            return false;
        }
        if (left.val==right.val){
            return validate(left.left,right.right)&&validate(left.right,right.right);
        }
        return false;
    }
}
