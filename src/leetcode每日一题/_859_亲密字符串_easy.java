package leetcode每日一题;

import java.util.HashMap;
import java.util.Map;

public class _859_亲密字符串_easy {
    //分情况讨论的题，难度不大，就是我的写法判断比较多，耗时比较久，第二种是官方写法，极大的减少了
    public boolean buddyStrings(String s, String goal) {
        if (s.length()!=goal.length()){
            return false;
        }
        //如果s和goal匹配，只需要判断s中有没有两个相同字符
        if (s.equals(goal)){
            Map<Character,Integer> map=new HashMap<>();
            for (char c : s.toCharArray()) {
                if (map.get(c)!=null){
                    return true;
                }
                map.put(c,1);
            }
            return false;
        }else {
            //如果s和goal不匹配时，必须符合一下条件才能返回ture
            //1.s和goal匹配，有且仅有两个不相同的字符left和right
            //2.s.left==goal.right 并且goal.left==s.right
            Integer left = null;
            Integer right= null;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i)!=goal.charAt(i)){
                    if (left!=null&&right!=null){
                        return  false;
                    }
                    if (left!=null){
                        if (s.charAt(left)!=goal.charAt(i)||s.charAt(i)!=goal.charAt(left)){
                            return false;
                        }
                        right=i;
                    }else {
                        left=i;
                    }
                }
            }
            if (left!=null&&right!=null){
                return true;
            }
            return false;
        }
    }
}
