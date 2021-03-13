package 剑指;
//请完成一个函数，输入一个二叉树，该函数输出它的镜像。
//
//        例如输入：
//
//             4
//           /   \
//          2     7
//         / \   / \
//        1   3 6   9
//        镜像输出：
//
//             4
//           /   \
//          7     2
//         / \   / \
//        9   6 3   1
//
//         
//
//        示例 1：
//
//        输入：root = [4,2,7,1,3,6,9]
//        输出：[4,7,2,9,6,3,1]
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class _27_二叉树的镜像 {
    //这道题想了半小时才想出来，太菜了
    //思路：用递归的方法解决
    //1.递归方法，传入root的节点，和镜像树的节点，两个节点的值是一致的
    //2.先判断root左节点是否为空，不为空就构建一个相同的节点插入镜像树的右节点
    //3.然后将root的左节点和镜像树的右节点（两者值相同，为相同节点）传入递归参数继续递归
    //4.root右节点过程和上面一样
    public TreeNode mirrorTree(TreeNode root) {
        if (root==null){
            return null;
        }
        TreeNode treeNode = new TreeNode(root.val);
        bulid(root,treeNode);
        return treeNode;
    }

    public void bulid(TreeNode oldTree,TreeNode newTree){
        if (oldTree.left!=null){
            TreeNode newRight = new TreeNode(oldTree.left.val);
            newTree.right=newRight;
            bulid(oldTree.left,newRight);
        }
        if (oldTree.right!=null){
            TreeNode newLeft = new TreeNode(oldTree.right.val);
            newTree.left=newLeft;
            bulid(oldTree.right,newLeft);
        }
    }
}
