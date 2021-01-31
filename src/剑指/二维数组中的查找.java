package 剑指;
//在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
//
//         
//
//        示例:
//
//        现有矩阵 matrix 如下：
//
//        [
//        [1,   4,  7, 11, 15],
//        [2,   5,  8, 12, 19],
//        [3,   6,  9, 16, 22],
//        [10, 13, 14, 17, 24],
//        [18, 21, 23, 26, 30]
//        ]
//        给定 target = 5，返回 true。
//
//        给定 target = 20，返回 false。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class 二维数组中的查找 {
    //思路：从矩阵的右上方的开始寻找，不断缩小矩阵，缩小矩阵后又在新的矩阵右上角寻找
    //若矩阵右上方的值>target，则说明这一列的值都比target大，排除掉这列，往左搜索
    //若矩阵右上方的值<target，则说明这一行的值都比target小，排除掉这一行，往下搜索
    //以此类推，直到找到target，若循环结束，则返回false
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix==null||matrix.length==0){
            return false;
        }

        //row代表第几行数
        int row=0;
        //colum代表第几列
        int colum=matrix[0].length-1;
        while (row<matrix.length&&colum>=0){
            if (matrix[row][colum]==target){
                return true;
            }
            else if (matrix[row][colum]>target){
                row++;
            }
            else {
                colum--;
            }
        }
        return false;
    }
}
