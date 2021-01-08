package 八大基础排序;

public class 快速排序 {
    public static void quickSort(int[] array,int low,int high){
        //选取一个基准数，就用第一个数作为基准数吧
        int i=low;
        int j=high;
        if(low>=high){
            return;
        }
        int pivot=array[low];

        while (i<j){
            //如果选取第一个节点，则必须从右边开始搜索
            while (array[j]>=pivot&&i<j){
                j--;
            }
            while (array[i]<=pivot&&i<j){
                i++;
            }
            if (i<j){
                int temp=array[i];
                array[i]=array[j];
                array[j]=temp;
            }
        }
        array[low]=array[i];
        array[i]=pivot;
        //递归
        quickSort(array,low,j-1);
        quickSort(array,j+1,high);
    }

    public static void quickSort_last(int[] arr,int low,int high){
        int i,j,privot;
        if (low>=high){
            return;
        }
        i=low;
        j=high;
        privot=arr[high];
        while (i<j){
            //选取最后一个节点作为基准点，就必须从左边开始搜索
            while (i<j&&arr[i]<=privot){
                i++;
            }
            while ((i<j&&arr[j]>=privot)){
                j--;
            }
            if (i<j){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        arr[high]=arr[i];
        arr[i]=privot;

        quickSort(arr,low,i-1);
        quickSort(arr,i+1,high);
    }

   static public void main(String[] args) {
        int[] array={8,6,11,2,9,57,21,34,1,66};
        quickSort_last(array,0,array.length-1);
        for (int i:array){
            System.out.println(i);
        }
    }
}
