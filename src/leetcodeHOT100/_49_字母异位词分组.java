package leetcodeHOT100;

import java.util.*;

//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
//
//        示例:
//
//        输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//        输出:
//        [
//        ["ate","eat","tea"],
//        ["nat","tan"],
//        ["bat"]
//        ]
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/group-anagrams
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class _49_字母异位词分组 {
    //思路：计数法，给字母异位词计算出同一份标志，存在map中
    //比如说"aac"、"caa"，生成的标志a2c1
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result=new ArrayList<>();
        if (strs==null||strs.length==0){
            return result;
        }
        Map<String,List<String>> map= new HashMap<>();
        for (String str : strs) {
            int[] array= new int[26];
            char[] chars = str.toCharArray();
            for (int i=0;i<chars.length;i++){
                array[chars[i]-'a']++;
            }
            //计算字符串的标志，作为hashmap的key
            StringBuilder stringBuilder = new StringBuilder();
            for (int i=0;i<array.length;i++){
                if (array[i]>0){
                    stringBuilder.append((char)(i+'a'));
                    stringBuilder.append(array[i]);
                }
            }
            String key = stringBuilder.toString();
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key,list);
        }
        result.addAll(map.values());
        return result;
    }

    //排序法
    public List<List<String>> groupAnagramsSort(String[] strs) {
        List<List<String>> result=new ArrayList<>();
        if (strs==null||strs.length==0){
            return result;
        }
        Map<String,List<String>> map=new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            List<String> list = map.getOrDefault(new String(chars), new ArrayList<>());
            list.add(str);
            map.put(new String(chars),list);
        }
        result.addAll(map.values());
        return result;
    }
}
