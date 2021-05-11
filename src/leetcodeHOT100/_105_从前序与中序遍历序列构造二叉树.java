package leetcodeHOT100;

import java.util.HashMap;
import java.util.Map;

//根据一棵树的前序遍历与中序遍历构造二叉树。
//
//        注意:
//        你可以假设树中没有重复的元素。
//
//        例如，给出
//
//        前序遍历 preorder = [3,9,20,15,7]
//        中序遍历 inorder = [9,3,15,20,7]
//        返回如下的二叉树：
//
//        3
//        / \
//        9  20
//        /  \
//        15   7
//        通过次数186,603提交次数267,813
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class _105_从前序与中序遍历序列构造二叉树 {
    int[] preorder;
    Map<Integer,Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder=preorder;
        map=new HashMap<>();
        for (int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return buildTreeImp(0,0,inorder.length-1);
    }

    public TreeNode buildTreeImp(int preLeft,int inLeft,int inRight){
        if (inLeft>inRight){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preLeft]);
        Integer index = map.get(preorder[preLeft]);
        root.left=buildTreeImp(preLeft+1,inLeft,index-1);
        root.right=buildTreeImp(preLeft+(index-inLeft)+1,index+1,inRight);
        return root;
    }
}
