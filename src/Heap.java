public class Heap {
    private int[] a; // 数组，从下标1开始存储数据
    private int n;  // 堆可以存储的最大数据个数
    private int count; // 堆中已经存储的数据个数

    public Heap(int capacity) {
        a = new int[capacity + 1];
        n = capacity;
        count = 0;
    }
    //往堆中插入数据，堆化
    public void insert(int data) {
        if (count >= n) return; // 堆满了
        ++count;
        a[count] = data;
        int i = count;
        while (i/2 > 0 && a[i] > a[i/2]) {  // 自下往上堆化
            swap(a, i, i/2);     // swap()函数作用：交换下标为i和i/2的两个元素
            i = i/2;
        }
    }

    public void removeMax(){
        if (count==0){
            return;
        }
        a[1]=a[count--];
        heapify(a,count,1);
    }
    //建堆
    public void buildHeap(int[] arr){
        for (int i=n/2;i>=1;i--){
            heapify(arr,n,i);
        }
    }

    public void heapSort(int[] arr){
        buildHeap(arr);
        int k=n;
        while (n>1){
            swap(arr,k,1);
            k--;
            heapify(arr,k,1);
        }
    }
    private void heapify(int[] a, int n, int i) {
        int maxPos = i;
        while (true){
            if (i*2<=n&&a[i]<a[i*2]){
                maxPos=i*2;
            }
            if (i*2+1<=n&&a[i]<a[i*2+1]){
                maxPos=i*2+1;
            }
            //maxpos==i，说明没有发生交换，已符合堆的特性，结束循环
            if (maxPos==i){
                break;
            }
            swap(a, i, maxPos);
            maxPos=i;
        }
    }

    public void swap(int[] a,int j,int k){
        int temp=a[j];
        a[j]=a[k];
        a[k]=temp;
    }
}
