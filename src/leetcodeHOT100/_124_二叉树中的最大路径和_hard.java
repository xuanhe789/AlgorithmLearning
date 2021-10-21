package leetcodeHOT100;

public class _124_二叉树中的最大路径和_hard {
    int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root==null){
            return 0;
        }
        getMaxPathSum(root);
        return max;
    }

    public int getMaxPathSum(TreeNode root){
        if (root==null){
            return 0;
        }
        int sumAll=getMaxPathSum(root.left)+getMaxPathSum(root.right)+root.val;
        int sumRight=getMaxPathSum(root.right)+root.val;
        int sumLeft=getMaxPathSum(root.left)+root.val;
        int sumMax = Math.max(sumAll, Math.max(sumLeft, sumRight));
        int value=root.val;
        this.max =Math.max(Math.max(sumMax,value), this.max);
        return Math.max(sumLeft,Math.max(sumRight,value));
    }
}
