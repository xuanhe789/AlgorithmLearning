package leetcode每日一题;

import java.util.Arrays;

public class _867_重新排序得到2的幂_med {
    //思路：dfs回溯+排序剪枝
    public boolean reorderedPowerOf2(int n) {
        if (n==1){
            return true;
        }
        char[] chars = String.valueOf(n).toCharArray();
        Arrays.sort(chars);
        String s = new String(chars);
        boolean[] visited=new boolean[s.length()];
        return dfs(s,new StringBuilder(),visited);
    }

    public boolean dfs(String s, StringBuilder sb, boolean[] visited ){
        if (sb.length()==s.length()){
            Integer value = Integer.valueOf(sb.toString());
            return valid(value);
        }
        for (int i=0;i<s.length();i++){
            if (visited[i]){
                continue;
            }
            char c = s.charAt(i);
            if ((c=='0'&&sb.length()==0)||(i!=0&&c==s.charAt(i-1)&&!visited[i-1])){
                continue;
            }
            sb.append(c);
            visited[i]=true;
            boolean flag = dfs(s, sb, visited);
            if (flag){
                return true;
            }
            sb.deleteCharAt(sb.length()-1);
            visited[i]=false;
        }
        return false;
    }

    public boolean valid(int n){
        while (n!=0){
            if (n%2!=0){
                return false;
            }
            n/=2;
        }
        return true;
    }
}
