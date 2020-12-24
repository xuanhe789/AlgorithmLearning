public class 路劲总和III {
    public int pathSum(TreeNode root, int sum) {
        return pathSum(root,sum,new int[1000],0);
    }
    public int pathSum(TreeNode treeNode ,int sum,int[] array, int p){
        if (treeNode==null){
            return 0;
        }
        int val=treeNode.val;
        int n=sum==val?1:0;
        for (int i=p-1;i>=0;i--){
            val+=array[i];
            if (val==sum){
                n++;
            }
        }
        array[p]=treeNode.val;
        int left = pathSum(treeNode.left, sum, array, p + 1);
        int rigth = pathSum(treeNode.right,sum,array,p+1);
        return n+left+rigth;
    }

}
