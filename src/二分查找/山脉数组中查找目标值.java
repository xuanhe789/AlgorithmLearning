package 二分查找;

//何为山脉数组？如果数组?A 是一个山脉数组的话，那它满足如下条件：
//
//        首先，A.length >= 3
//
//        其次，在?0 < i?< A.length - 1?条件下，存在 i 使得：
//
//        A[0] < A[1] < ... A[i-1] < A[i]
//        A[i] > A[i+1] > ... > A[A.length - 1]
//        ?
//
//        你将?不能直接访问该山脉数组，必须通过?MountainArray?接口来获取数据：
//
//        MountainArray.get(k)?- 会返回数组中索引为k?的元素（下标从 0 开始）
//        MountainArray.length()?- 会返回该数组的长度
//        ?
//
//        注意：
//
//        对?MountainArray.get?发起超过 100 次调用的提交将被视为错误答案。此外，任何试图规避判题系统的解决方案都将会导致比赛资格被取消。
//
//        为了帮助大家更好地理解交互式问题，我们准备了一个样例 “答案”：https://leetcode-cn.com/playground/RKhe3ave，请注意这 不是一个正确答案。
//
//        ?
//
//        示例 1：
//
//        输入：array = [1,2,3,4,5,3,1], target = 3
//        输出：2
//        解释：3 在数组中出现了两次，下标分别为 2 和 5，我们返回最小的下标 2。
//        示例 2：
//
//        输入：array = [0,1,2,4,2,1], target = 3
//        输出：-1

public class 山脉数组中查找目标值 {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int top = findTop(mountainArr);
        int leftValue = findLeftArray(target, mountainArr, 0, top);
        if (leftValue!=-1){
            return leftValue;
        }
        return findRightArray(target,mountainArr,top+1,mountainArr.length()-1);
    }
    //找山顶元素
    public int findTop(MountainArray mountainArray){
        int left=0;
        int right=mountainArray.length()-1;
        while (left<right){
            int mid=left+(right-left)/2;
            int value = mountainArray.get(mid);
            int pre=mountainArray.get(mid-1);
            int after=mountainArray.get(mid+1);
            if (value>pre&&value>after){
                return mid;
            }
            else if (value>pre){
                left=mid+1;
            }
            else {
                right=mid;
            }
        }
        return left;
    }

    //二分查找，搜索左边有序数组
    public int findLeftArray(int target,MountainArray mountainArray,int left,int right){
        while (left<right){
            int mid=left+(right-left)/2;
            int value = mountainArray.get(mid);
            if (value==target){
                return mid;
            }
            else if (value>target){
                right=mid;
            }
            else {
                left=mid+1;
            }
        }
        return mountainArray.get(left)==target?left:-1;
    }

    //二分查找，搜索右边有序数组
    public int findRightArray(int target,MountainArray mountainArray,int left,int right){
        while (left<right){
            int mid=left+(right-left)/2;
            int value = mountainArray.get(mid);
            if (value==target){
                return mid;
            }
            else if (value>target){
                left=mid+1;
            }
            else {
                right=mid;
            }
        }
        return mountainArray.get(left)==target?left:-1;
    }
}
interface MountainArray {
    public int get(int index);
    public int length();
}
