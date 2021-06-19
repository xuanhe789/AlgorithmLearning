package leetcodeHOT100;

import java.util.HashMap;

//知耻而后勇，知弱而图强
//给定一个二叉树，判断其是否是一个有效的二叉搜索树。
//
//        假设一个二叉搜索树具有如下特征：
//
//        节点的左子树只包含小于当前节点的数。
//        节点的右子树只包含大于当前节点的数。
//        所有左子树和右子树自身必须也是二叉搜索树。
//        示例 1:
//
//        输入:
//        2
//        / \
//        1   3
//        输出: true
//        示例 2:
//
//        输入:
//        5
//        / \
//        1   4
//             / \
//            3   6
//        输出: false
//        解释: 输入为: [5,1,4,null,null,3,6]。
//             根节点的值为 5 ，但是其右子节点值为 4 。
public class _98_验证二叉搜索树 {
    //这个变量要用long来接收，因为测试用例有一个超过了int的最大值
    Long pre =Long.MIN_VALUE;
    //思路：根据BST的特性，中序遍历出来的数据是有序的，从左到右递增
    //所以，用一个变量pre记录上一个节点的值，然后判断当前节点的值是否大于pre
    //如果小于说明不是BST，如果大于，将当前节点的值赋值给pre，继续递归判断
    //综上所述，中序遍历解法就是利用了BST中序遍历的数据是有序的这一特性。
    public boolean isValidBST(TreeNode root) {
        if (root==null){
            return true;
        }
        //中序遍历递归判断左子树
        boolean validLeft = isValidBST(root.left);
        //如果左子树不是BST，直接返回false
        if (!validLeft||root.val<=pre){
            return false;
        }
        //将当前节点的值赋值给pre变量，用于下一个节点的判断
        pre=(long)root.val;
        boolean validBST = isValidBST(root.right);
        return validBST;
    }

}
