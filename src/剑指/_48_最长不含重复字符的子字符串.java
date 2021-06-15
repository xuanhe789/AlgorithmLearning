package 剑指;

import com.sun.deploy.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

//请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
//
//         
//
//        示例 1:
//
//        输入: "abcabcbb"
//        输出: 3
//        解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//        示例 2:
//
//        输入: "bbbbb"
//        输出: 1
//        解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//        示例 3:
//
//        输入: "pwwkew"
//        输出: 3
//        解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//             请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
public class _48_最长不含重复字符的子字符串 {
    //动态规划
    //dp[i]表示以字符串中第i+1个字符结尾的最长子串的长度
    //我做的是双指针+hash表实现
    //用一个hash表存储遍历过元素的位置，判断当前元素是否在之前的字符串是否存在相同的
    //用一个start表示左指针，遍历的i表示右指针,i-start+1表示字符串的长度
    public int lengthOfLongestSubstring(String s) {
        if (s.length()<=1){
            return s.length();
        }
        int max=1;
        int start=0;
        Map<Character,Integer> map=new HashMap<>();
        for (int i=0;i<s.length();i++){
            int length=0;
            char c = s.charAt(i);
            if (map.containsKey(c)){
                //判断重复的字符是否在start右边，如果是，更新start指针
                start=Math.max(start,map.get(c)+1);
            }
            length=i-start+1;
            map.put(c,i);
            max=Math.max(length,max);
        }
        return max;
    }
}
