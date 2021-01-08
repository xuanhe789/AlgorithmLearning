package 八大基础排序;

public class 选择排序 {
}

class Solution{
    public static int[] solute(int[] array){
        int temp;
        //设置一个最小值
        int min;
        //设置一个int类型变量，记录最小值的小标
        int pom;
        for (int i=0;i<array.length-1;i++){
            pom=i;
            //默认第一个为最小
           min=array[i];
            for (int j=i+1;j<array.length;j++){
                if (array[j]<min){
                    min=array[j];
                    pom=j;
                }
            }
            temp=array[i];
            array[i]=min;
            array[pom]=temp;
        }
        for (int a:array){
            System.out.println(a);
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array={-1,-5,6,8,2,4,3,9};
        Solution.solute(array);
    }
}