package 八大基础排序;

public class 归并排序 {
    public static void main(String[] args) {
        int[] arrays={9,55,1,3,14,6,7,15};
        mergeSort(arrays,0,arrays.length-1);
        for (int i:arrays){
            System.out.println(i);
        }
    }

    public static void mergeSort(int[] arrays,int L,int R){
        if (L==R){
            return;
        }
        else {
            //取中间的数进行拆分
            int M=(L+R)/2;
            //左边的数不断进行拆分
            mergeSort(arrays,L,M);
            //右边的数不断进行拆分
            mergeSort(arrays,M+1,R);
            //合并
            merge(arrays,L,M+1,R);
        }
    }

    private static void merge(int[] arrays,int L,int M,int R) {
        //左边数组的大小
        int[] leftArray = new int[M - L];
        int[] rightArray = new int[R - M + 1];
//        填充数组
        for (int i = L; i < M; i++) {
            leftArray[i - L] = arrays[i];
        }
        for (int j = M; j <= R; j++) {
            rightArray[j - M] = arrays[j];
        }
        int i = 0, j = 0,k=L;
//        两个排好序的数组合并，双指针指向两个数组
        while (i < leftArray.length && j < rightArray.length) {
            //注意，这里不能写成>，否则将变成不稳定的排序算法
            if (leftArray[i] >= rightArray[j]) {
                arrays[k]=rightArray[j];
                j++;
                k++;
            }
            else {
                arrays[k]=leftArray[i];
                i++;
                k++;
            }
        }
        //走到这里，说明有一个数组已经遍历完
        while (i<leftArray.length){
            arrays[k]=leftArray[i];
            i++;
            k++;
        }
        while (j<rightArray.length){
            arrays[k]=rightArray[j];
            j++;
            k++;
        }
    }
}
