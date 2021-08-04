package leetcodeHOT100;
//知耻而后勇，知弱而图强
//编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
//
//        每行的元素从左到右升序排列。
//        每列的元素从上到下升序排列。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/search-a-2d-matrix-ii
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class _240_搜索二维矩阵II {

    //从矩阵左上角开始搜寻
    //根据矩阵的特点，如果当前格子的值大于target,则往左退一列
    //如果当前格子的值小于target,则往下加一行
    public boolean searchMatrix(int[][] matrix, int target) {
        int col=matrix[0].length-1;
        int row=0;
        while (true){
            if (matrix[row][col]==target){
                return true;
            }else if (matrix[row][col]>target){
                col--;
            }else {
                row++;
            }

            if (col<0||row==matrix.length){
                return false;
            }
        }
    }
}
