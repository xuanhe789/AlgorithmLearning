package 剑指;

import java.util.HashMap;

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
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class 最长不含重复字符的子字符串 {
    //双指针
    public static int lengthOfLongestSubstring(String s) {
        if (s.length()<2){
            return s.length();
        }
        char[] chars = s.toCharArray();
        HashMap<Character,Integer> map= new HashMap<>();
        int max=0;
        int start=0,end=0;
        for (int i=0;i<chars.length;i++){
            if (map.containsKey(chars[i])&&start<=map.get(chars[i])){
                start=map.get(chars[i])+1;
            }
            end++;
            map.put(chars[i],i);
            max=Math.max(max,end-start);
        }
        return max;
    }

    public static void main(String[] args) {
        String s="abba";
    }
}
