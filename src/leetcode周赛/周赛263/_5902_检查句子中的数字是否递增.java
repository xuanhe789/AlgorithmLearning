package leetcode周赛.周赛263;

//示例 1：
//
//
//
//        输入：s = "1 box has 3 blue 4 red 6 green and 12 yellow marbles"
//        输出：true
//        解释：句子中的数字是：1, 3, 4, 6, 12 。
//        这些数字是按从左到右严格递增的 1 < 3 < 4 < 6 < 12 。
//        示例 2：
//
//        输入：s = "hello world 5 x 5"
//        输出：false
//        解释：句子中的数字是：5, 5 。这些数字不是严格递增的。
//        示例 3：
//
//
//
//        输入：s = "sunset is at 7 51 pm overnight lows will be in the low 50 and 60 s"
//        输出：false
//        解释：s 中的数字是：7, 51, 50, 60 。这些数字不是严格递增的。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/check-if-numbers-are-ascending-in-a-sentence
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class _5902_检查句子中的数字是否递增 {
    public boolean areNumbersAscending(String s) {
        String[] strs = s.split(" ");
        int max=0;
        for (String str : strs) {
            if (!str.matches("[0-9]+")){
                continue;
            }
            Integer value = Integer.valueOf(str);
            if (value>max){
                max=value;
            }else {
                return false;
            }
        }
        return true;
    }
}
