package leetcode周赛;

import java.util.HashSet;
import java.util.Set;

public class _5850_最大公约数_easy {
    public int findGCD(int[] nums) {
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for (int num : nums) {
            if (num<min){
                min=num;
            }
            if (num>max){
                max=num;
            }
        }
        for (int i=min;i>=1;i--){
            if (max%i!=0&&min%i!=0){
                return i;
            }
        }
        return 0;
    }
//    给你一个字符串数组 nums ，该数组由 n 个 互不相同 的二进制字符串组成，且每个字符串长度都是 n 。请你找出并返回一个长度为 n 且 没有出现 在 nums 中的二进制字符串。如果存在多种答案，只需返回 任意一个 即可。
//
//
//
//    示例 1：
//
//    输入：nums = ["01","10"]
//    输出："11"
//    解释："11" 没有出现在 nums 中。"00" 也是正确答案。
//    示例 2：
//
//    输入：nums = ["00","01"]
//    输出："11"
//    解释："11" 没有出现在 nums 中。"10" 也是正确答案。
//    示例 3：
//
//    输入：nums = ["111","011","001"]
//    输出："101"
//    解释："101" 没有出现在 nums 中。"000"、"010"、"100"、"110" 也是正确答案。
//
//
//    提示：
//
//    n == nums.length
//1 <= n <= 16
//    nums[i].length == n
//    nums[i] 为 '0' 或 '1'
    String result;
    public String findDifferentBinaryString(String[] nums) {
        Set<String> set = new HashSet<>();
        for (String num : nums) {
            set.add(num);
        }
        int length=nums[0].length();
        StringBuilder sb = new StringBuilder();
        dfs(sb,set,length);
        return result;
    }

    public void dfs(StringBuilder sb,Set<String> set,int length){
        if (sb.length()==length&&!set.contains(sb.toString())){
            result=sb.toString();
            return;
        }
        if (sb.length()==length){
            return;
        }
        for (int i=0;i<=1;i++){
            sb.append(i);
            dfs(sb,set,length);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    int absmin=Integer.MAX_VALUE;
    boolean flag=false;
    public int minimizeTheDifference(int[][] mat, int target) {
        dfs(mat,target,0,0);
        return absmin;
    }

    public void dfs(int[][] mat,int target,int num,int length){
        if (flag==true){
            return;
        }
        if (length==mat.length){
            int abs = Math.abs(num - target);
            if (abs==0){
                flag=true;
            }
            absmin=Math.min(absmin, abs);
            return;
        }
        for (int i=0;i<mat[0].length;i++){
            num+=mat[length][i];
            dfs(mat,target,num,length+1);
            num-=mat[length][i];
        }
    }

}
