package 滴滴笔试;

import java.util.ArrayList;
import java.util.List;

//知耻而后勇，知弱而图强
//题目：有固定面额的硬币1，2，5，输入两个数，分别是硬币的数量：num，总价钱：totalMoney
//要求从3个面额硬币的数量中，计算出数量为num且总价值为totalMoney的硬币组成个数
//例如输入:4 , 8
//输出2
// 5,1,1,1
//2,2,2,2
public class 固定硬币组成总金钱 {
    public static int result;

    public static List<Integer> coins=new ArrayList<>();

    public int soulute(int a,int b){
        dfs(a,b,0);
        System.out.println(result);
        return result;
    }

    public void dfs(int sum,int totalMoney,int begin){
        if (sum==0&&totalMoney==0){
            result++;
            return;
        }
        if (sum==0||totalMoney<=0){
            return;
        }
        for (int i=begin;i<coins.size();i++) {
            dfs(sum-1,totalMoney- coins.get(i),i);
        }
    }

}
