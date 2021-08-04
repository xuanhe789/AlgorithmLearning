package leetcodeHOT100;
//知耻而后勇，知弱而图强
//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
//
//        每行中的整数从左到右按升序排列。
//        每行的第一个整数大于前一行的最后一个整数。
//         
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/search-a-2d-matrix
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class _74_搜索二维矩阵 {
    //思路：两次二分查找
    //1.先使用二分查找，找到该数存在于哪一行i
    //2.再通过二分查找，在第i行判断是否存在
    public boolean searchMatrix(int[][] matrix, int target) {
        //二分查找，定位在哪一行找
        int left=0;
        int right=matrix.length-1;
        while (left<right){
            int mid=left+(left+right+1)/2;
            if (matrix[mid][0]==target){
                return true;
            }else if (matrix[mid][0]>target){
                right=mid-1;
            }else {
                left=mid;
            }
        }
        //找到target所在的行数
        int point=left;
        left=0;
        right=matrix[0].length-1;
        //二分查找，寻找target是否存在
        while (left<right){
            int mid=left+(right+left)/2;
            if (matrix[point][mid]==target){
                return true;
            }else if (matrix[point][mid]>target){
                right=mid;
            }else {
                left=mid+1;
            }
        }
        if (matrix[point][left]==target){
            return true;
        }
        return false;
    }
}
