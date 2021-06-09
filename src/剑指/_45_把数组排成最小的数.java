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
    /*
    * 此题求拼接起来的最小数字，本质上是一个排序问题。设数组 numsnums 中任意两数字的字符串为 xx 和 yy ，则规定 排序判断规则 为：

       若拼接字符串 x + y > y + xx+y>y+x ，则 xx “大于” yy ；
       反之，若 x + y < y + xx+y<y+x ，则 xx “小于” yy ；
       xx “小于” yy 代表：排序完成后，数组中 xx 应在 yy 左边；“大于” 则反之。
    * */
    public String minNumber1(int[] nums) {
        if (nums.length==1){
            return String.valueOf(nums[0]);
        }
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);
        quickSort(strs,0,nums.length-1);
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
        }
        return sb.toString();
    }

    public void quickSort( String[] strs,int low,int high){
        if (low>=high){
            return;
        }
        String priot=strs[low];
        int left=low;
        int right=high;
        while (left<right){
            while (left<right &&(priot+strs[right]).compareTo(strs[right]+priot)<=0){
                right--;
            }
            while (left<right &&(priot+strs[left]).compareTo(strs[left]+priot)>=0){
                left++;
            }
            if (left<right){
                String temp=strs[left];
                strs[left]=strs[right];
                strs[right]=temp;
            }
        }
        strs[low]=strs[left];
        strs[left]=priot;
        quickSort(strs,low,left-1);
        quickSort(strs,left+1,high);
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
