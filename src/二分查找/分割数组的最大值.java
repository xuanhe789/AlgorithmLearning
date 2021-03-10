package 二分查找;
//给定一个非负整数数组和一个整数 m，你需要将这个数组分成 m 个非空的连续子数组。设计一个算法使得这 m 个子数组各自和的最大值最小。
//
//        注意:
//        数组长度 n 满足以下条件:
//
//        1 ≤ n ≤ 1000
//        1 ≤ m ≤ min(50, n)
//        示例:
//
//        输入:
//        nums = [7,2,5,10,8]
//        m = 2
//
//        输出:
//        18
//
//        解释:
//        一共有四种方法将nums分割为2个子数组。
//        其中最好的方式是将其分为[7,2,5] 和 [10,8]，
//        因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/split-array-largest-sum
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class 分割数组的最大值 {
    //思路：二分查找，子数组之和的最大值在[max(nums),sum(nums)]，
    //此时我们可以设置max(nums)为左边界，sum(nums)为右边界，然后计算mid，
    //以mid为子数组之和的最大值，分割数组，如果分割的子数组个数大于m，
    //说明值(mid)取小了，left=mid+1,
    //如果分割的子数组个数小于或等于m，说明值取大了或者正好，right=mid
    //退出while循环的时候，此时的left（或者right）就是最小的子数组最大值之和
    public int splitArray(int[] nums, int m) {
        int left=0,right=0;
        int max=0;
        for (int i:nums){
            if (i>left){
                left=i;
            }
            right+=i;
        }
        while (left<right){
            int arrNums=0,arrSum=0;
            int mid=left+(right-left)/2;
            //这个循环根据mid分割数组，计算子数组的数量
            for (int i=0;i<nums.length;i++){
                if (arrSum+nums[i]<=mid){
                    arrSum+=nums[i];
                }
                else{
                    arrNums++;
                    arrSum=nums[i];
                }
                if (i==nums.length-1){
                    arrNums++;
                }
            }
            if (arrNums>m){
                left=mid+1;
            }
            else {
                right=mid;
            }
        }
        return left;
    }

    public int getMaxArray(int[] arr,int m,int maxVlue){
        int sum=0,max=0;
        for (int value:arr){
            if (sum+value<maxVlue){
                sum+=value;
            }
            else {
                sum=value;
            }
            max=Math.max(sum,max);
        }
        return max;
    }

    public static void main(String[] args) {
        分割数组的最大值 a = new 分割数组的最大值();
        a.splitArray(new int[]{7,2,5,10,8},2);
    }
}
