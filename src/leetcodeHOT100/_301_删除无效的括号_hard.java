package leetcodeHOT100;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _301_删除无效的括号_hard {
    Set<String> result=new HashSet<>();
    int size=0;
    //思路：dfs回溯暴力搜索
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
//        dfs(s,0,lremove,rremove);
        dfs2(s,0,0,0,lremove,rremove);
        ArrayList<String> list = new ArrayList<>(result);
        return list;
    }

    private void dfs(String s, int start, int lremove, int rremove) {
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
                dfs(s.substring(0,start)+s.substring(start+1),start,lremove-1,rremove);
            }
            //保留当前左括号
            dfs(s,start+1,lremove,rremove);
        }else if (c==')'){
            if (rremove>0){
                dfs(s.substring(0,start)+s.substring(start+1),start,lremove,rremove-1);
            }
            dfs(s,start+1,lremove,rremove);
        }else {
            dfs(s,start+1,lremove,rremove);
        }
    }

    private void dfs2(String s, int start, int leftCount, int rightCount, int lremove, int rremove){
        if (lremove==0&&rremove==0){
            if (isValid(s)){
                result.add(s);
            }
            return;
        }
        for (int i=start;i<s.length();i++){
            if (i!=start&&s.charAt(i)==s.charAt(i-1)){
                continue;
            }
            if (lremove>0&&s.charAt(i)=='('){
                //尝试去掉一个左括号
                dfs2(s.substring(0,start)+s.substring(start+1),i,leftCount++,rightCount,lremove-1,rremove);
            }
            if (rremove>0&&s.charAt(i)==')'){
                //尝试去掉一个右括号
                dfs2(s.substring(0,start)+s.substring(start+1),i,leftCount,rightCount++,lremove-1,rremove-1);
            }
            //如果当前右括号的数量大于左括号的数量，说明肯定不是合法的字符串，直接返回
            if (leftCount<rightCount){
                return;
            }
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
