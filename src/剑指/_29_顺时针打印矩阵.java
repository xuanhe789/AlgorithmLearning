package 剑指;

public class _29_顺时针打印矩阵 {
    //思路，设置上下左右边界，每打印一行或一列都将对应的边界缩小，防止重复打印
    public static int[] spiralOrder(int[][] matrix) {
        if (matrix.length==0){
            return new int[0];
        }
        int x=0;
        //左边界初始化
        int left=0;
        //右边界初始化
        int right=matrix[0].length-1;
        //上边界初始化
        int top=0;
        //下边界初始化
        int bottom=matrix.length-1;
        //定义返回结果数组
        int[] res=new int[matrix.length*matrix[0].length];
        while (true){
            //从左向右打印
            for (int i=left;i<=right;i++){
                res[x++]=matrix[top][i];
            }
            //缩小上边界，防止从上到下打印有重复，如果上边界+1大于下边界，则退出循环
            if (++top>bottom) break;
            //从上往下打印
            for (int i=top;i<=bottom;i++){
                res[x++]=matrix[i][right];
            }
            //缩小右边界，防止从右到左打印有重复
            if (--right<left) break;
            //从右向左打印
            for (int i=right;i>=left;i--){
                res[x++]=matrix[bottom][i];
            }
            //缩小下边界，防止从下往上打印有重复
            if (--bottom<top) break;
            for (int i=bottom;i>=top;i--){
                res[x++]=matrix[i][left];
            }
            //缩小左边界，防止从左往右打印有重复
            if (++left>right) break;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] a=new int[3][3];
        a[0]= new int[]{1, 2, 3};
        a[1]= new int[]{4,5,6};
        a[2]= new int[]{7,8,9};
        spiralOrder(a);
    }
}
