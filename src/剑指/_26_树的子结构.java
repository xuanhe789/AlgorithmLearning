package 剑指;
//输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
//
//        B是A的子结构， 即 A中有出现和B相同的结构和节点值。
//
//        例如:
//        给定的树 A:
//
//             3
//            / \
//           4   5
//          / \
//         1   2
//        给定的树 B：
//
//           4 
//          /
//         1
//        返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
//
//        示例 1：
//
//        输入：A = [1,2,3], B = [3,1]
//        输出：false
//        示例 2：
//
//        输入：A = [3,4,5,1,2], B = [4,1]
//        输出：true
//        限制：
//
//        0 <= 节点个数 <= 10000
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class _26_树的子结构 {
    /*
    * 思路：
    * 1.先在A中找到与B根节点相同的节点
    * 2.如果找到节点，则递归判断两颗树是否相同
    * 3.如果相同直接返回结果。
    * 4.如果不同，继续递归寻找下一个与B根节点相同的节点
    * */
    Boolean flag=false;
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A==null||B==null){
            return false;
        }
        dfs(A,B);
        return flag;
    }

    /*
    * 先在A中找到和B的根节点相同的节点
    * 然后进行对比
    * */
    public void dfs(TreeNode A,TreeNode B){
        if (A==null||B==null){
            return;
        }
        if (A.val==B.val){
            /*
            * 递归判断两个树是否相等，如果相等直接返回
            * */
            boolean subTreeHelper = isSubTreeHelper(A, B);
            if (subTreeHelper){
                flag=true;
                return;
            }
        }
        dfs(A.left,B);
        dfs(A.right,B);
    }

    /*
    * 递归判断两棵树是否相等
    * */
    public boolean isSubTreeHelper(TreeNode A, TreeNode B) {
        if (A==null&&B!=null){
            return false;
        }
        if (B==null){
            return true;
        }
        if (A.val==B.val){
            return isSubTreeHelper(A.left,B.left)&&isSubTreeHelper(A.right,B.right);
        }
        return false;
    }
}
