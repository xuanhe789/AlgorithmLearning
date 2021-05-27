package 剑指;
//知耻而后勇，知弱而图强
//输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
//
//         
//
//        示例 1:
//
//        输入: [10,2]
//        输出: "102"
//        示例 2:
//
//        输入: [3,30,34,5,9]
//        输出: "3033459"
//         
//
//        提示:
//
//        0 < nums.length <= 100
//        说明:
//
//        输出结果可能非常大，所以你需要返回一个字符串而不是整数
//        拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0。
public class _45_把数组排成最小的数 {
    String result=null;
    public String minNumber1(int[] nums) {
        if (nums.length==1){
            return String.valueOf(nums[0]);
        }
        result=String.valueOf(nums[0]);
        for (int i=1;i<nums.length;i++){
            String s1=result+nums[i];
            String s2=nums[i]+result;
            result=s1.compareTo(s2)<0?s1:s2;
        }
        return result;
    }

    //高复杂度解法，回溯法,leetCode过不了
    public String minNumber0(int[] nums) {
        if (nums.length==1){
            return String.valueOf(nums[0]);
        }
        StringBuilder sb = new StringBuilder();
        boolean[] flag=new boolean[nums.length];
        dfs(nums,sb,flag,0);
        return result;
    }

    public void dfs(int[] nums,StringBuilder sb,boolean[] flag,int deep){
        if(deep==nums.length){
            String s = sb.toString();
            if (result==null){
                result=s;
                return;
            }
            result=s.compareTo(result)<0?s:result;
            return;
        }
        for (int i=0;i<nums.length;i++){
            if (flag[i]){
                continue;
            }
            int first = sb.length();
            sb.append(nums[i]);
            int last = sb.length();
            flag[i]=true;
            dfs(nums,sb,flag,deep+1);
            sb.delete(first,last);
            flag[i]=false;
        }
    }
}
