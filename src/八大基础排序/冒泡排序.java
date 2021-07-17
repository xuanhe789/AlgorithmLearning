package 八大基础排序;

public class 冒泡排序 {
    public static void main(String[] args) {
        int[] arr={7,1,2,3,4,5,6};
        bubbleSortPlus(arr);
        for (int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }

    public static void bubbleSort(int[] arr){
        //从小到大排序
        for (int i=0;i<arr.length-1;i++){
            for (int j=0;j<arr.length-i-1;j++){
                if (arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }

        }
        for (int i=0;i<arr.length-1;i++){
            for (int j=arr.length-1;j>i;j--){
                if (arr[j-1]>arr[j]){
                    int temp=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                }
            }
        }
    }

    public static void bubbleSortPlus(int[] arr){

        //定义一个标志
        Boolean is_change;
        for (int i=0;i<arr.length-1;i++){
            is_change=false;
            for (int j=0;j<arr.length-i-1;j++){
                if (arr[j+1]<arr[j]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    is_change=true;
                }
            }
            if (!is_change){
                break;
            }
        }
    }
}
