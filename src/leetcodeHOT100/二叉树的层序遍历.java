package leetcodeHOT100;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
//
//         
//
//        示例：
//        二叉树：[3,9,20,null,null,15,7],
//
//        3
//        / \
//        9  20
//        /  \
//        15   7
//        返回其层序遍历结果：
//
//        [
//        [3],
//        [9,20],
//        [15,7]
//        ]
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class 二叉树的层序遍历 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if (root==null){
            return result;
        }
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty()){
            List<Integer> list= new ArrayList<>();
            deque.size()
            for (int i = 0; i< deque.size(); i++){
                TreeNode node = deque.poll();
                list.add(node.val);
                if (node.left!=null){
                    deque.add(node.left);
                }
                if (node.right!=null){
                    deque.add(node.right);
                }
            }
            result.add(list);
        }
        return result;
    }
}
