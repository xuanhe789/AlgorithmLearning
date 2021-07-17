public class 最小二叉树 {
    public void minTree(int[] arr){
        if (arr==null||arr.length==0){
            return;
        }
        TreeNode treeNode = build(arr, 0, arr.length - 1);
        pre(treeNode);
    }

    public TreeNode build(int[] arr,int left,int right){
        if (left>right){
            return null;
        }
        int min=Integer.MAX_VALUE;
        int index=0;
        for (int i=left;i<=right;i++){
            if (arr[i]<min){
                min=arr[i];
                index=i;
            }
        }
        TreeNode treeNode = new TreeNode(min);
        treeNode.left=build(arr,left,index-1);
        treeNode.right=build(arr,index+1,right);
        return treeNode;
    }

    public void pre(TreeNode root){
        if (root==null){
            return;
        }
        System.out.println(root.val);
        pre(root.left);
        pre(root.right);
    }
}
