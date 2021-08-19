package 剑指;

import java.util.ArrayList;
import java.util.List;

//知耻而后勇,知弱而图强
//输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
//
//        序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
//
//         
//
//        示例 1：
//
//        输入：target = 9
//        输出：[[2,3,4],[4,5]]
//        示例 2：
//
//        输入：target = 15
//        输出：[[1,2,3,4,5],[4,5,6],[7,8]]
public class  _57_II和为s的连续正数序列 {
    //滑动窗口，左窗口从1开始，右窗口从2开始
    public int[][] findContinuousSequence(int target) {
        int left=1;
        int right=2;
        int sum=left+right;
        List<int[]> lists=new ArrayList<>();
        while (right<target&&right>left){
            if (sum==target){
                int[] arr=new int[right-left+1];
                for (int i=0;i<=right-left;i++){
                    arr[i]=i+left;
                }
                lists.add(arr);
                sum+=++right;
                sum-=left++;
                sum-=left++;
            }
            else if (sum>target){
                sum-=left;
                left++;
            }else {
                right++;
                sum+=right;
            }
        }
        int[][] results = lists.toArray(new int[lists.size()][]);
        return results;
    }
}
