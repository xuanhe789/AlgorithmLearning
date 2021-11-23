package leetcode每日一题;

import java.util.HashMap;
import java.util.Map;

public class _318_最大单词长度乘积_med {
    //hash表，位运算来计算每个字母是否出现，使用int类型的二进制位26位来表示a-z26个小写字母
    public int maxProduct(String[] words) {
        int result=0;
        Map<Integer, Integer> map = new HashMap<>();
        for (String word : words) {
            int length = word.length();
            //对单词中每个字母进行与运算，字母对应的二进制位如果为1，代表这个字母存在
            int t=0;
            for (char c : word.toCharArray()) {
                int u=c-'a';
                t|=(1<<u);
            }
            if (map.getOrDefault(t,0)<length){
                map.put(t,length);
            }
        }

        for (Integer integer : map.keySet()) {
            int i=integer;
            for (Integer integer1 : map.keySet()) {
                int j=integer1;
                if ((i&j)==0){
                    result=Math.max(result,map.get(integer)*map.get(integer1));
                }
            }
        }
        return result;
    }
}
