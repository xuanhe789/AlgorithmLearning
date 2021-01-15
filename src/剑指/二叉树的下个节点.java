package 剑指;

public class 二叉树的下个节点 {
    //1.递归解决，不同情况不同递归
    public TreeLinkNode getNext(TreeLinkNode node){
        //如果当前节点的右子节点不为空，则找到右子树的最左子节点
        if (node.right!=null){
            return findNext(node.right);
        }
        //如果当前节点右子节点为空。而且为父节点的左子节点，直接返回父节点
        else if (node.pre!=null&&node.pre.left==node){
            return node.pre;
        }
        //如果当前节点右子节点为空。而且为父节点的右子节点，向上递归寻找节点
        //直到找到节点为父节点的左子节点的节点，如果找不到返回null
        else if (node.pre!=null&&node.pre.right==node){
            return getHead(node.pre);
        }
        //如果上面情况都不是，说明当前节点是根节点，并且没有右子树，返回null
        else {
            return null;
        }
    }

    public TreeLinkNode findNext(TreeLinkNode node){
        if (node.left!=null){
            return findNext(node.left);
        }
        else {
            return node;
        }
    }

    public TreeLinkNode getHead(TreeLinkNode node){
        if (node.pre!=null&&node.pre.right==node){
            return getHead(node.pre);
        }
        else if (node.pre!=null&&node.pre.left==node){
            return node.pre;
        }
        else {
            return null;
        }
    }
    //更好的解法
    public TreeLinkNode GetNext(TreeLinkNode treeLinkNode){
        if (treeLinkNode.right!=null){
            treeLinkNode=treeLinkNode.right;
            while (treeLinkNode.left!=null){
                treeLinkNode=treeLinkNode.left;
            }
            return treeLinkNode;
        }
        else if (treeLinkNode.pre!=null&&treeLinkNode.pre.left==treeLinkNode){
            return treeLinkNode.pre;
        }
        else if (treeLinkNode.pre!=null){
            treeLinkNode=treeLinkNode.pre;
            while (treeLinkNode.pre != null && treeLinkNode.pre.right == treeLinkNode) {
                treeLinkNode=treeLinkNode.pre;
            }
            return treeLinkNode.pre;
        }
        return null;
    }
}

class TreeLinkNode {
    int val;
    TreeLinkNode left ;
    TreeLinkNode right;
    TreeLinkNode pre;
    TreeLinkNode(int val) {
        this.val = val;
    }
}

