package leetcodeHOT100;
//给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
//
//        此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
//
//         
//
//        示例 1：
//
//        输入：nums = [2,0,2,1,1,0]
//        输出：[0,0,1,1,2,2]
//        示例 2：
//
//        输入：nums = [2,0,1]
//        输出：[0,1,2]
//        示例 3：
//
//        输入：nums = [0]
//        输出：[0]
//        示例 4：
//
//        输入：nums = [1]
//        输出：[1]
//         
//
//        提示：
//
//        n == nums.length
//        1 <= n <= 300
//        nums[i] 为 0、1 或 2
//         
//
//        进阶：
//
//        你可以不使用代码库中的排序函数来解决这道题吗？
//        你能想出一个仅使用常数空间的一趟扫描算法吗？
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/sort-colors
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class 颜色分类 {
    //三指针
    public void sortColors1(int[] nums) {
        if (nums.length<2){
            return;
        }

        // all in [0, zero) = 0
        // all in [zero, i) = 1
        // all in [two, len - 1] = 2
        int zero=0;
        int i=0;
        int two=nums.length-1;

        while (i<=two){
            if (nums[i]==0){
                swap(nums,i,zero);
                i++;
                zero++;
            }
            else if (nums[i]==1){
                i++;
            }
            else {
                //nums[i]==2
                swap(nums,i,two);
                two--;
            }
        }
    }

    //单指针
    public void sortColors2(int[] nums) {
        if (nums.length<2){
            return;
        }
        int ptr=0;
        //第一次遍历，先把为0的元素全部移到最左边
        for (int i=0;i<nums.length;i++){
            if (nums[i]==0){
                swap(nums,i,ptr);
                ptr++;
            }
        }

        //第二次遍历，从最后一个0的后面开始，把全部1移到右0的右边
        for (int i=ptr;i<nums.length;i++){
            if (nums[i]==1){
                swap(nums,i,ptr);
                ptr++;
            }
        }
    }



    public void swap(int[] nums,int index1,int index2){
        int temp=nums[index1];
        nums[index1]=nums[index2];
        nums[index2]=temp;
    }
}
