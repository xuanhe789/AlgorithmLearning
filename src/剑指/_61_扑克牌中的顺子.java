package 剑指;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//知耻而后勇，知弱而图强
//从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
//
//         
//
//        示例 1:
//
//        输入: [1,2,3,4,5]
//        输出: True
//         
//
//        示例 2:
//
//        输入: [0,0,1,2,5]
//        输出: True
//         
//
//        限制：
//
//        数组长度为 5 
//
//        数组的数取值为 [0, 13] .
public class _61_扑克牌中的顺子 {
    //Set+遍历
    public boolean isStraightSet(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max=0;
        int min=Integer.MAX_VALUE;
        for (int num : nums) {
            if (num==0){
                continue;
            }
            if (set.contains(num)){
                return false;
            }
            set.add(num);
            max=Math.max(max,num);
            min=Math.min(min,num);
        }
        return max-min<5;
    }
    //排序加遍历
    public boolean isStraight(int[] nums) {
        //记录0的个数，0可以变成任何数，如果最终0的个数大于interval，那么可以构成顺子
        int zeroNum=0;
        //记录这个5个数中，要构成顺子差了多少个数
        int interval=0;
        //先排序
        Arrays.sort(nums);
        if (nums[0]==0){
            zeroNum++;
        }
        for (int i=1;i<nums.length;i++) {
            //如果为0，zeroNum++
            if (nums[i]==0){
                zeroNum++;
                continue;
            }
            //如果两个数不为0，并且相等，说明这五个数无法构成顺子
            if (nums[i]-nums[i-1]==0){
                return false;
            }
            //如果上一个树为0，没有比较的必要
            if(nums[i-1]!=0){
                interval+=nums[i]-nums[i-1]-1;
            }
        }
        if (zeroNum>=interval){
            return true;
        }
        return false;
    }


}
