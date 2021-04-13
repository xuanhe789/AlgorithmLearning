package 滴滴笔试;

import java.util.*;
//大概题目：进程z在操作系统中从开始到执行结束有两个过程，准备阶段和执行阶段
//进程只有在准备阶段后才能进入执行阶段
//多个进程的准备阶段可以并发执行，执行阶段只能有一个线程执行
//n为线程数，a和b分别表示为准备阶段花费的时间和执行阶段花费的时间
//例子：
//2
//2 2
//5 1
//结果输出6
public class 进程最短执行时间 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        Map<Integer,Integer> map= new HashMap<>();
        int n=cin.nextInt();
        if (n==0){
            System.out.println(0);
        }
        int a = 0, b=0;
        int c=0;
        int min=Integer.MAX_VALUE;
        int sum=0;
        List<Integer> list= new ArrayList<>();
        while(n>=1) {
            a = cin.nextInt();
            b = cin.nextInt();
            if (a==min){
                sum+=b;
            }
            if (a<min){
                min=a;
                sum=a+b;
            }
            if (map.containsKey(a)){
                Integer integer = map.get(a);
                map.put(a,b+integer);
            }else {
                map.put(a,b);
                list.add(a);
            }
            n--;
        }
        if (list.size()==1){
            System.out.println(sum);
            return;
        }
        Collections.sort(list);
        for (Integer integer:list) {
            if (integer==min){
                continue;
            }
            if (sum>integer){
                sum+=map.get(integer);
            }else{
                sum=integer+map.get(integer);
            }
        }
        System.out.println(sum);
    }
}
