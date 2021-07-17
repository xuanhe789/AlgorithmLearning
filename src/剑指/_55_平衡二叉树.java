package 剑指;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class _55_平衡二叉树 {
    //后序遍历+剪枝，当一棵树为平衡二叉树时，需要遍历所有节点，时间复杂度O(n)
    public boolean isBalanced(TreeNode root) {
        if (root==null){
            return true;
        }
        return deepth(root)!=-1;
    }

    public int deepth(TreeNode treeNode) {
        if (treeNode==null){
            return 0;
        }
        int left = deepth(treeNode.left);
        if (left==-1){
            return -1;
        }
        int right = deepth(treeNode.right);
        if (right==-1){
            return -1;
        }
        return Math.abs(left-right)>1?-1:Math.max(left,right)+1;
    }

    //此解法时间复杂度为O(nlogn)
    //先序遍历+判断，当一棵树为平衡树时需要遍历所有子树节点
//    public boolean isBalanced(TreeNode root) {
//        if (root==null){
//            return true;
//        }
//        return valid(root);
//    }
//
//    public boolean valid(TreeNode treeNode){
//        if (treeNode==null){
//            return true;
//        }
//        int abs = Math.abs(deepth(treeNode.left) - deepth(treeNode.right));
//        if (abs>1){
//            return false;
//        }
//        return valid(treeNode.left)&&valid(treeNode.right);
//    }
//    public int deepth(TreeNode treeNode){
//        if (treeNode==null){
//            return 0;
//        }
//        return Math.max(deepth(treeNode.left),deepth(treeNode.right))+1;
//    }
}
