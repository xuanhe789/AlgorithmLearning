package 剑指;
//知耻而后勇，知弱而图强
//输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
//
//        例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
//
//         
//
//        示例 1：
//
//        输入：n = 12
//        输出：5
//        示例 2：
//
//        输入：n = 13
//        输出：6
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class _43_1到n整数中1出现的次数 {
    public int countDigitOne(int n) {
        if (n==0){
            return 0;
        }
        int result=0;
        int cur=n%10,high=n/10,low=0,dight=1;
        while (high!=0||cur!=0){
            if (cur==0){
                result+=high*dight;
            }else if (cur==1){
                result+=high*dight+(low+1);
            }else {
                result+=(high+1)*dight;
            }
            low=cur*dight+low;
            dight*=10;
            cur=high%10;
            high=high/10;
        }
        return result;
    }
}
