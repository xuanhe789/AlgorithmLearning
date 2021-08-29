package leetcodeHOT100;

import java.util.HashMap;
import java.util.Map;

//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
//
//         
//
//        注意：
//
//        对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
//        如果 s 中存在这样的子串，我们保证它是唯一的答案。
//         
//
//        示例 1：
//
//        输入：s = "ADOBECODEBANC", t = "ABC"
//        输出："BANC"
//        示例 2：
//
//        输入：s = "a", t = "a"
//        输出："a"
//        示例 3:
//
//        输入: s = "a", t = "aa"
//        输出: ""
//        解释: t 中两个字符 'a' 均应包含在 s 的子串中，
//        因此没有符合条件的子字符串，返回空字符串。
//         
//
//        提示：
//
//        1 <= s.length, t.length <= 105
//        s 和 t 由英文字母组成
//         
//
//        进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？
public class _76_最小覆盖子串 {
    public String minWindow(String s, String t) {
        if (s.length()<t.length()){
            return "";
        }
        //记录最小子串的长度
        int min_length=Integer.MAX_VALUE;
        //记录最小子串的第一个字符的索引
        int index=0;
        //hash表存储窗口内所需要的字符及其个数
        Map<Character,Integer> need=new HashMap<>();
        //初始化
        for (char c : t.toCharArray()) {
            if (!need.containsKey(c)){
                need.put(c,1);
            }else {
                need.put(c,need.get(c)+1);
            }
        }
        //定义一个变量存储滑动窗口包含t所需的字符总个数
        int needCount=t.length();
        //滑动窗口左指针
        int left=0;
        //滑动窗口右指针
        int right=0;
        //先滑动右窗口，使窗口内包含t的所有字符，再停下来滑动左窗口
        while (right<s.length()){
            char c = s.charAt(right);
            //如果当前字符时t所包含的字符，需要修改need;
            if (need.containsKey(c)){
                //当need.get(c)>0的时候，说明窗口需要当前字符串，让窗口所需的字符总数needCount-1；
                if (need.get(c)>0){
                    needCount--;
                }
                //修改need
                need.put(c,need.get(c)-1);
            }
            //滑动左窗口,每次遇到t字符串中的字符时，记录下长度，并修改need哈希表
            //当left滑动至
            if (needCount==0){
                while (needCount==0){
                    char c1 = s.charAt(left);
                    if (need.containsKey(c1)){
                        if (right-left+1<min_length){
                            min_length=right-left+1;
                            index=left;
                        }
                        //获取所需当前字符的个数，如果为负数，说明是多余的，只需要修改need就好
                        Integer integer = need.put(c1, need.get(c1) + 1)+1;
                        //如果为正数，说明刚刚滑掉的字符是需要的，需要修改needCount
                        if (integer>0){
                            needCount++;
                        }
                    }
                    left++;
                }
            }
            right++;
        }
        //如果s不包含t的全部字符，则设min_length=0,返回空字符串"";
        if(min_length==Integer.MAX_VALUE){
            min_length=0;
        }
        return s.substring(index,min_length+index);
    }
}
