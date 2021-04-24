package leetcodeHOT100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//知耻而后勇
//给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
//
//        字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
//
//        说明：
//
//        字母异位词指字母相同，但排列不同的字符串。
//        不考虑答案输出的顺序。
//        示例 1:
//
//        输入:
//        s: "cbaebabacd" p: "abc"
//
//        输出:
//        [0, 6]
//
//        解释:
//        起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
//        起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
//         示例 2:
//
//        输入:
//        s: "abab" p: "ab"
//
//        输出:
//        [0, 1, 2]
//
//        解释:
//        起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
//        起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
//        起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
public class _438_找到字符串中所有字母异位词 {
    //思路：双指针，计算唯一标识，和字母异位词分组很像
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result=new ArrayList<>();
        if (p == null || "".equals(p)||p.length()>s.length()) {
            return result;
        }
        //计算字符串的唯一标识，如abc -> 1a1b1c ,aac -> 2a1c
        int[] cpArray=new int[26];
        for (char c : p.toCharArray()) {
            cpArray[c-'a']++;
        }
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<cpArray.length;i++){
            if (cpArray[i]>0){
                sb.append(cpArray[i]);
                sb.append((char)('a'+i));
            }
        }
        String answer = sb.toString();
        int length=p.length();
        int start=0,end=p.length()-1;
        while (start<=s.length()-p.length()){
            if (end-start+1==length&&verify(s.substring(start,end+1),answer)){
                result.add(start);
            }
            start++;
            end++;
        }
        return result;
    }

    /*
    * 计算截取字符串的唯一标识，然后对比
    * */
    public boolean verify(String s,String answer){
        int[] array=new int[26];
        for (char c : s.toCharArray()) {
            array[c-'a']++;
        }
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<array.length;i++){
            if (array[i]>0){
                sb.append(array[i]);
                sb.append((char)('a'+i));
            }
        }
        s=sb.toString();
        return s.equals(answer);
    }
}
