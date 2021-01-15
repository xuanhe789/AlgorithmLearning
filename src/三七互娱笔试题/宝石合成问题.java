package 三七互娱笔试题;

public class 宝石合成问题 {
    public static int get(int N){
        if (N<2){
            return N;
        }
        int num=1;
        while (N>1){
            if (num%2!=0){
                num=(num-1)*5/2+3;
            }
            else {
                num=num*5/2;
            }
            N--;
        }
        return num;
    }

    public static void main(String[] args) {
        int i = get(6);
        System.out.println(i);
    }
}
