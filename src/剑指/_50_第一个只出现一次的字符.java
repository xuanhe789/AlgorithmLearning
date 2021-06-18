package 剑指;

import java.util.HashMap;

public class 第一个只出现一次的字符 {
    //为什么我这么傻逼，这么简单的一道题没想出来
    //先遍历一次存到Hashmap里面，在遍历一次找到第一个没有重复的数
    public char firstUniqChar(String s) {
        int length = s.length();
        HashMap<Character, Boolean> map = new HashMap();
        for (int i = 0; i < length; i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), false);
            } else {
                map.put(s.charAt(i), true);
            }
        }

        for (int i = 0; i < length; i++) {
            if (map.get(s.charAt(i)) == true) {
                return s.charAt(i);
            }
        }
        return ' ';

    }
}
