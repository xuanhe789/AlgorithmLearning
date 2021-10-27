package leetcodeHOT100;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _301_删除无效的括号_hard {
    Set<String> result=new HashSet<>();
    int size=0;
    public List<String> removeInvalidParentheses(String s) {
        int lremove=0,rremove=0;
        for (char c : s.toCharArray()) {
            if (c=='('){
                lremove++;
            }else if (c==')'){
                if (lremove==0){
                    rremove++;
                    continue;
                }
                lremove--;
            }
        }
        size=s.length()-lremove-rremove;
        dfs(s,0,0,0,lremove,rremove);
        ArrayList<String> list = new ArrayList<>(result);
        return list;
    }

    private void dfs(String s, int start, int leftCount, int rightCount, int lremove, int rremove) {
        if (lremove==0&&rremove==0&&s.length()==size){
            if (isValid(s)){
                result.add(s);
            }
            return;
        }
        if (start>=s.length()){
            return;
        }
        char c = s.charAt(start);
        if (c=='('){
            if (lremove>0){
                //删除当前左括号
                dfs(s.substring(0,start)+s.substring(start+1),start,leftCount++,rightCount,lremove--,rremove);
            }
            //保留当前左括号
            dfs(s,start+1,leftCount++,rightCount,lremove,rremove);
        }else if (c==')'){
            if (rremove>0){
                dfs(s.substring(0,start)+s.substring(start+1),start,leftCount,rightCount++,lremove,rremove--);
            }
            dfs(s,start+1,leftCount,rightCount++,lremove,rremove);
        }else {
            dfs(s,start+1,leftCount,rightCount,lremove,rremove);
        }
    }

    private  boolean isValid(String s) {
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            int curr = s.charAt(i);
            if (curr == '(') {
                left++;
            } else if (curr == ')') {
                if (left != 0) {
                    left--;
                } else {
                    return false;
                }
            }
        }
        return left == 0;
    }
}
