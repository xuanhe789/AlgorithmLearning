package leetcodeHOT100;
//给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
//
//        示例 1:
//
//        输入: 2
//        输出: [0,1,1]
//        示例 2:
//
//        输入: 5
//        输出: [0,1,1,2,1,2]
//        进阶:
//
//        给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
//        要求算法的空间复杂度为O(n)。
//        你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/counting-bits
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class _338_比特位计数 {
//    状态定义:
//
//    dp[i]dp[i] 表示数字 ii 对应的二进制表示中 11 的数量。
//    状态转移:
//
//    当 ii 为偶数时：由二进制表示规则我们可以知道，二进制表示的最后一位为0，也就是说删去这个0，对 dp[i]dp[i] 也不会有任何影响。因此 dp[i] = dp[i / 2]
//    当 ii 为奇数时：由二进制表示规则我们可以知道，二进制表示的最后一位为1，也就是说数字 ii 因为这个1，比数字 (i-1)/2(i−1)/2 最终结果多1。因此 dp[i] = dp[(i - 1) / 2] + 1
    public int[] countBits(int num) {
        int[] result=new int[num+1];
        for (int i=1;i<=num;i++){
            if (i%2==0){
                result[i]=result[i/2];
            }
            else {
                result[i]=result[i/2]+1;
            }
        }
        return result;
    }
    //其实上述方法只需要判断最低位是否为1即可
    public int[] countBits2(int num) {
        int[] result=new int[num+1];
        for (int i=1;i<=num;i++){
            result[i]=result[i/2]+(i&1);
        }
        return result;
    }
}
