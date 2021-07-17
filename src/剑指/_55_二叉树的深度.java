package 剑指;

import java.util.HashMap;

//知耻而后勇，知弱而图强
public class _55_二叉树的深度 {
    public int maxDepth(TreeNode root) {
        if (root==null){
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}
