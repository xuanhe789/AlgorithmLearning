package leetcode每日一题;

import java.util.HashMap;
import java.util.Map;

//给定一个正整数 n ，你可以做如下操作：
//
//        如果 n 是偶数，则用 n / 2替换 n 。
//        如果 n 是奇数，则可以用 n + 1或n - 1替换 n 。
//        n 变为 1 所需的最小替换次数是多少？
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/integer-replacement
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class _397_整数替换 {
    //递归，每条路都搜索，选择最小那一条路
    public int integerReplacement(int n) {
        if (n<=1){
            return 0;
        }
        if (n%2==0){
            return 1+integerReplacement(n/2);
        }else {
            return 2+Math.min(integerReplacement(n/2),integerReplacement(n/2+1));
        }
    }

    //记忆化递归
    Map<Integer,Integer> map=new HashMap<>();

    public int integerReplacementMap(int n) {
        if (n<=1){
            return 0;
        }
        if (!map.containsKey(n)){
            if (n%2==0){
                map.put(n,1+integerReplacementMap(n/2));
            }else {
                map.put(n,2+Math.min(integerReplacementMap(n/2),integerReplacementMap(n/2+1)));
            }
        }
        return map.get(n);
    }
}
