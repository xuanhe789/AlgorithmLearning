package 八大基础排序;

public class 希尔排序 {
    public static void sort(int[] arr){
        for (int gap=arr.length/2;gap>0;gap=gap/2){
            for (int i=gap;i<arr.length;i++){
                //保存i位置的数据
                int pom=arr[i];
                int j;
                //插入排序的方式，这个循环类似于插入排序
                for (j=i-gap;j>=0&&arr[j]>pom;j=j-gap){
                        arr[j+gap]=arr[j];
                }
                arr[j+gap]=pom;

            }
        }
    }

    public static void main(String[] args) {
        int[] arr={7,64,2,31,5,9};
        sort(arr);
        for (int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
