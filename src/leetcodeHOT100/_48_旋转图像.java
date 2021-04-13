package leetcodeHOT100;
//给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
//
//        你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
//
//         
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/rotate-image
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class _48_旋转图像 {
    //思路，这道题有点抽象，不知道怎么表达
    public void rotate(int[][] matrix) {
        if (matrix.length==0){
            return;
        }
        int length=matrix.length;
        //行
        //思路：int length=matrix.length;，
        //某个位置顺时针90度的置换公式为matrix[i][j]->matrix[j][n-i-1]，也就是说matrix[j][n-i-1]=matrix[i][j]
        for (int i=0;i<length/2;i++){
            for (int j=i;j<length-1-i;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[length-j-1][i];
                matrix[length-j-1][i]=matrix[length-i-1][length-j-1];
                matrix[length-i-1][length-j-1]=matrix[j][length-i-1];
                matrix[j][length-i-1]=temp;
            }
        }
    }
}
