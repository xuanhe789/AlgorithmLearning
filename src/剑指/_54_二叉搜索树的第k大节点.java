package 剑指;
//知耻而后勇，知弱而图强
//给定一棵二叉搜索树，请找出其中第k大的节点。
//
//         
//
//        示例 1:
//
//        输入: root = [3,1,4,null,2], k = 1
//        3
//        / \
//        1   4
//        \
//           2
//        输出: 4
//        示例 2:
//
//        输入: root = [5,3,6,2,4,null,null,1], k = 3
//        5
//        / \
//        3   6
//        / \
//        2   4
//        /
//        1
//        输出: 4
//         
//
//        限制：
//
//        1 ≤ k ≤ 二叉搜索树元素个数

public class _54_二叉搜索树的第k大节点 {
    int index=0;
    int result=0;
    //思路，先遍历右节点，再遍历中节点，再遍历左节点
    //就是将中序遍历倒过来
    public int kthLargest(TreeNode root, int k) {
        if (root==null){
            return -1;
        }
        dfs(root,k);
        return result;
    }

    public void dfs(TreeNode root,int k){
        if (root==null){
            return;
        }
        dfs(root.right,k);
        if (++index==k){
            result=root.val;
            return;
        }
        dfs(root.left,k);
    }

}
