package 剑指;


import java.util.HashMap;
import java.util.Map;

//输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
//
//         
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
//          /  \
//        15   7
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class 重建二叉树 {
    int[] preorder;
    Map<Integer,Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map=new HashMap<>(preorder.length);
        this.preorder=preorder;
        for (int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return bulidTreeImp(0,0,inorder.length-1);
    }

    /**
     *
     * @param preLeft 表示前序遍历的左边界
     * @param inLeft 表示这一段子树的在中序遍历左边界
     * @param inRight 表示这一段子树的在中序遍历右边界
     * @return
     */
    public TreeNode bulidTreeImp(int preLeft,int inLeft,int inRight){
        if( inLeft > inRight){
            return null;
        }
        int currentValue=preorder[preLeft];
        TreeNode root = new TreeNode(currentValue);
        //找到当前值在中序遍历中的索引；
        Integer index = map.get(currentValue);
        //递归构建当前节点的左子树
        //左子树结点在前序遍历的位置就是当前节点的下一个
        root.left=bulidTreeImp(preLeft+1,inLeft,index-1);
        //递归构建当前节点的右子树
        //preLeft+(index-inLeft)+1含义为 根节点索引 + 左子树长度 + 1
        root.right=bulidTreeImp(preLeft+(index-inLeft)+1,index+1,inRight);
        return root;
    }

}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
