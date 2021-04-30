package 剑指;

import java.util.LinkedList;

//请实现两个函数，分别用来序列化和反序列化二叉树。
//
//        示例: 
//
//        你可以将以下二叉树：
//
//        1
//        / \
//        2   3
//        / \
//        4   5
//
//        序列化为 "[1,2,3,null,null,4,5]"
public class _37_序列化二叉树 {
    //根据题意，序列化后的结果就是层序遍历的结果
    public String serialize(TreeNode root) {
        if (root==null){
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        LinkedList<TreeNode> linkedList=new LinkedList<>();
        linkedList.add(root);
        while (!linkedList.isEmpty()){
            int size = linkedList.size();
            for (int i=0;i<size;i++){
                TreeNode node = linkedList.removeFirst();
                if (node==null){
                    sb.append("null,");
                    continue;
                }
                sb.append(node.val+",");
                linkedList.add(node.left);
                linkedList.add(node.right);
            }
        }
        //去除掉后面多余的NULL，但发现时间复杂的差不多
//        while (sb.length()>=5&&sb.substring(sb.length()-5,sb.length()).equals("null,")){
//            sb.delete(sb.length()-5,sb.length());
//        }
        sb.deleteCharAt(sb.length()-1);
        sb.append("]");
        return sb.toString();
    }

    //将字符串反序列化的过程也是使用的类似层序遍历的方式
    public TreeNode deserialize(String data) {
        if (data==null){
            return null;
        }
        String[] values = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        LinkedList<TreeNode> linkedList=new LinkedList<>();
        linkedList.add(root);
        int i=1;
        while (!linkedList.isEmpty()&&i<values.length){
            TreeNode node = linkedList.removeFirst();
            if (!values[i].equals("null")){
                TreeNode node1 = new TreeNode(Integer.parseInt(values[i]));
                node.left=node1;
                linkedList.add(node1);
            }
            i++;
            if (!values[i].equals("null")){
                TreeNode node1 = new TreeNode(Integer.parseInt(values[i]));
                node.right=node1;
                linkedList.add(node1);
            }
            i++;
        }
        return root;
    }
}
