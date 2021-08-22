package leetcode周赛;
//给你一个字符串数组 nums ，该数组由 n 个 互不相同 的二进制字符串组成，且每个字符串长度都是 n 。请你找出并返回一个长度为 n 且 没有出现 在 nums 中的二进制字符串。如果存在多种答案，只需返回 任意一个 即可。
//
//
//
//        示例 1：
//
//        输入：nums = ["01","10"]
//        输出："11"
//        解释："11" 没有出现在 nums 中。"00" 也是正确答案。
//        示例 2：
//
//        输入：nums = ["00","01"]
//        输出："11"
//        解释："11" 没有出现在 nums 中。"10" 也是正确答案。
//        示例 3：
//
//        输入：nums = ["111","011","001"]
//        输出："101"
//        解释："101" 没有出现在 nums 中。"000"、"010"、"100"、"110" 也是正确答案。
//
//
//        提示：
//
//        n == nums.length
//        1 <= n <= 16
//        nums[i].length == n
//        nums[i] 为 '0' 或 '1'

import java.util.HashSet;
import java.util.Set;

public class _5851_找出不同的二进制字符串_med {
    //康托对角线：构建一个字符串result，使result的第i个字符和第i个串的第i个字符不一样，那么result就和所有的字符串都不一样
    //比如，和第0个串的[0]不同，和第1个串的[1]不同，和第2个串的[2]不同，……
    //由此构造出来的串就和所有的串都不同了
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<nums.length;i++){
            if (nums[i].charAt(i) == '0') {
                //取反
                sb.append('1');
            }else {
                sb.append('0');
            }
        }
        return sb.toString();
    }
    //回溯法，垃圾解法
    String result;
    boolean flag=false;
    public String findDifferentBinaryStringTrash(String[] nums) {
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
        //剪枝
        if (flag){
            return;
        }
        if (sb.length()==length&&!set.contains(sb.toString())){
            result=sb.toString();
            flag=true;
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
}
