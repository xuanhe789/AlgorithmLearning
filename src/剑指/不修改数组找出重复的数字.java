package 剑指;

public class 不修改数组找出重复的数字 {
    public static int findRepeatNumber(int[] nums) {
        int left=1;
        int right=nums.length-1;
        while (left<right){
            int mid=left+(right-left)/2;
            int sum=0;
            for (int i:nums){
                if (i<=mid){
                    sum++;
                }
            }
            if (sum>mid){
                right=mid;
            }
            else {
                left=mid+1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] arr={2,2,2,2,2,2,3,7};
        findRepeatNumber(arr);
    }
}
