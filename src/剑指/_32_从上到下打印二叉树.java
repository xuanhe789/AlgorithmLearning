package 剑指;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
//
//         
//
//        例如:
//        给定二叉树: [3,9,20,null,null,15,7],
//
//        3
//        / \
//        9  20
//        /  \
//        15   7
//        返回：
//
//        [3,9,20,15,7]
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class _31_从上到下打印二叉树 {
    //层序遍历
    public int[] levelOrder(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        if (root==null){
            return new int[0];
        }
        LinkedList<TreeNode> linkedList=new LinkedList<>();
        linkedList.add(root);
        while (!linkedList.isEmpty()){
            int size = linkedList.size();
            for (int i=0;i<size;i++){
                TreeNode treeNode = linkedList.removeFirst();
                result.add(treeNode.val);
                if (treeNode.left!=null){
                    linkedList.add(treeNode.left);
                }
                if (treeNode.right!=null){
                    linkedList.add(treeNode.right);
                }
            }
        }
        int[] resultArray=new int[result.size()];
        for (int i=0;i<resultArray.length;i++){
            resultArray[i]=result.get(i);
        }
        return resultArray;

    }
}
