package leetcode每日一题;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _1217_最长定差子序列_med {
    //hash表
    public int longestSubsequence(int[] arr, int difference) {
        if (arr.length==1){
            return 1;
        }
        Map<Integer,Integer> map = new HashMap<>();
        int max=0;
        for (int i=0;i<arr.length;i++){
            Integer pre = map.getOrDefault(arr[i] - difference, 0);
            map.put(arr[i],pre+1);
            max=Math.max(max,pre+1);
        }
        return max;
    }
}
