package leetcodeHOT100;
//给你一个以字符串表示的非负整数 num 和一个整数 k ，移除这个数中的 k 位数字，使得剩下的数字最小。请你以字符串形式返回这个最小的数字。
//
//         
//        示例 1 ：
//
//        输入：num = "1432219", k = 3
//        输出："1219"
//        解释：移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219 。
//        示例 2 ：
//
//        输入：num = "10200", k = 1
//        输出："200"
//        解释：移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
//        示例 3 ：
//
//        输入：num = "10", k = 2
//        输出："0"
//        解释：从原数字移除所有的数字，剩余为空就是 0 。
//         
//
//        提示：
//
//        1 <= k <= num.length <= 105
//        num 仅由若干位数字（0 - 9）组成
//        除了 0 本身之外，num 不含任何前导零
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/remove-k-digits
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class _402_移掉K个数字 {
    //贪心算法，从数字的第二位开始，与高一位比较，如果低位比高位小，删除高位
    //如果低位比高位大，则高低位都往右移一位，继续比较
    public String removeKdigits(String num, int k) {
        if (num.length()==1){
            return "0";
        }
        StringBuilder sb = new StringBuilder(num);
        int deleteNum=0;
        int low=0;
        while (low!=sb.length()&&deleteNum<k){
            //如果low==0，说明这是第一个数字，前面没有高位，要往后移
            if (low==0){
                low++;
                continue;
            }
            char lowc = sb.charAt(low);
            char highc = sb.charAt(low-1);
            //如果高位大于低位，则删除高位
            if (lowc<highc){
                sb.deleteCharAt(low-1);
                deleteNum++;
                low--;
            }else {
                low++;
            }
        }
        String result;
        int n=k-deleteNum;
        if (n!=0){
            //如果n不为0，说明删除的数字还不足k个，这时要从末尾删除n个数字
            sb.delete(sb.length()-n,sb.length());
        }
        //消除掉最前面的0，比如说0200，要消掉第一个0
        while(sb.length()>0&&sb.charAt(0)=='0'){
            sb.deleteCharAt(0);
        }
        if (sb.length()==0){
            return "0";
        }
        return sb.toString();
    }
}
