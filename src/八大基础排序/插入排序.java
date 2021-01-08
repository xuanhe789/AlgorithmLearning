package 八大基础排序;

public class 插入排序 {
    public static void sort(int[] arr){
        for (int i=1;i<arr.length;i++){
            int pom=arr[i];
            int j=i-1;
            while (j>=0&&pom<arr[j]){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=pom;
        }
    }

    public static void main(String[] args) {
        int[] arr={7,11,9,88,64,1};
        sort(arr);
        for (int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
