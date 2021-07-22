package leetcodeHOT100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//知耻而后勇，知弱而图强
//假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。
//
//        请你重新构造并返回输入数组 people 所表示的队列。返回的队列应该格式化为数组 queue ，其中 queue[j] = [hj, kj] 是队列中第 j 个人的属性（queue[0] 是排在队列前面的人）。
//
//         
//
//        示例 1：
//
//        输入：people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
//        输出：[[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
//        解释：
//        编号为 0 的人身高为 5 ，没有身高更高或者相同的人排在他前面。
//        编号为 1 的人身高为 7 ，没有身高更高或者相同的人排在他前面。
//        编号为 2 的人身高为 5 ，有 2 个身高更高或者相同的人排在他前面，即编号为 0 和 1 的人。
//        编号为 3 的人身高为 6 ，有 1 个身高更高或者相同的人排在他前面，即编号为 1 的人。
//        编号为 4 的人身高为 4 ，有 4 个身高更高或者相同的人排在他前面，即编号为 0、1、2、3 的人。
//        编号为 5 的人身高为 7 ，有 1 个身高更高或者相同的人排在他前面，即编号为 1 的人。
//        因此 [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]] 是重新构造后的队列。
//        示例 2：
//
//        输入：people = [[6,0],[5,0],[4,0],[3,2],[2,2],[1,4]]
//        输出：[[4,0],[5,0],[2,2],[3,2],[1,4],[6,0]]
public class _406_根据身高重建队列 {
    //思路：先根据ki进行升序排序，再使用稳定性排序算法根据hi降序排序
    public int[][] reconstructQueue(int[][] people) {
        quickSort(people,0,people.length-1,1);
        merge(people,0,people.length-1);
//        Arrays.sort(people,(person1, person2)->{
//            if (person1[0] == person2[0]){
//                return person1[1]-person2[1];
//            }else {
//                return person2[0]-person1[0];
//            }
//        });
        List<int[]> list=new ArrayList<>();
        for (int[] person : people) {
            int size = list.size();
            if (size<=person[1]){
                list.add(person);
                continue;
            }
            list.add(person[1],person);
        }
        int[][] result = list.toArray(new int[people.length][]);
        return result;
    }

    public void quickSort(int[][] array,int low ,int high,int flag){
        if (low>=high){
            return;
        }
        int left=low;
        int right=high;
        int target=array[low][flag];
        int[] firstArr=array[low];
        while (left<right){
            while (left<right&&array[right][flag]>=target){
                right--;
            }
            while (left<right&&array[left][flag]<=target){
                left++;
            }
            if (left<right){
                int[] temp=array[left];
                array[left]=array[right];
                array[right]=temp;
            }
        }
        array[low]=array[left];
        array[left]=firstArr;
        quickSort(array,low,left-1,flag);
        quickSort(array,left+1,high,flag);
    }

    public void merge(int[][] arr,int low,int high){
        if (low>=high){
            return;
        }
        int mid=(high+low)>>>1;
        merge(arr,low,mid);
        merge(arr,mid+1,high);
        mergeSort(arr,low,mid,high);
    }

    public void mergeSort(int[][] arr, int low,int mid, int high) {
        int[][] leftArray=new int[mid-low+1][];
        int[][] rightArray=new int[high-mid][];
        for (int i = low; i <= mid; i++) {
            leftArray[i - low] = arr[i];
        }
        for (int j = mid+1; j <= high; j++) {
            rightArray[j - mid-1] = arr[j];
        }
        int left=0;
        int right=0;
        int k=low;
        while (left <leftArray.length&& right <rightArray.length){
            if (leftArray[left][0]>=rightArray[right][0]){
                arr[k]=leftArray[left];
                left++;
            }else {
                arr[k]=rightArray[right];
                right++;
            }
            k++;
        }
        while (left <leftArray.length){
            arr[k]=leftArray[left];
            left++;
            k++;
        }
        while (right <rightArray.length){
            arr[k]=rightArray[right];
            right++;
            k++;
        }
    }

}
