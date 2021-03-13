package leetcodeHOT100;

import java.util.ArrayList;
import java.util.List;

//给定一个二叉树的根节点 root ，返回它的 中序 遍历。
public class 二叉树的中序遍历 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result= new ArrayList<>();
        if (root==null){
            return result;
        }
        traversal(result,root);
        return result;
    }

    public void traversal(List<Integer> result,TreeNode root){
        if (root==null){
            return;
        }
        traversal(result,root.left);
        result.add(root.val);
        traversal(result,root.right);
    }

}

 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }