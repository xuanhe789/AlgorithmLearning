package 八大基础排序;

public class 堆排序 {
    public void HeapSort(int[] arr){
        buildHeap(arr,arr.length);
        int k=arr.length-1;
        while (k>0){
            swap(arr,0,k);
            k--;
            heapify(arr,k,0);
        }
    }
    //将数组从上往下建堆，i=(length-1)/2表示完全二叉树中的最后一个非叶子节点，从这里开始构建堆
    public void buildHeap(int[] arr,int length){
        for (int i=(length-1)/2;i>=0;i--){
            heapify(arr,length-1,i);
        }
    }

    private void heapify(int[] a, int n, int i) {
        int maxPos = i;
        while (true){
            if (i*2+1<=n&&a[i]<a[i*2+1]){
                maxPos=i*2+1;
            }
            if (i*2+2<=n&&a[i]<a[i*2+2]){
                maxPos=i*2+2;
            }
            //maxpos==i，说明没有发生交换，已符合堆的特性，结束循环
            if (maxPos==i){
                break;
            }
            swap(a, i, maxPos);
            i=maxPos;
        }
    }
    //交换数组中两个位置的元素
    public void swap(int[] a,int j,int k){
        int temp=a[j];
        a[j]=a[k];
        a[k]=temp;
    }
}
