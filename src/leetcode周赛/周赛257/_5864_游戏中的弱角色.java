package leetcode周赛.周赛257;

import java.util.Arrays;
import java.util.Comparator;

//你正在参加一个多角色游戏，每个角色都有两个主要属性：攻击 和 防御 。给你一个二维整数数组 properties ，其中 properties[i] = [attacki, defensei] 表示游戏中第 i 个角色的属性。
//
//        如果存在一个其他角色的攻击和防御等级 都严格高于 该角色的攻击和防御等级，则认为该角色为 弱角色 。更正式地，如果认为角色 i 弱于 存在的另一个角色 j ，那么 attackj > attacki 且 defensej > defensei 。
//
//        返回 弱角色 的数量。
//
//         
//
//        示例 1：
//
//        输入：properties = [[5,5],[6,3],[3,6]]
//        输出：0
//        解释：不存在攻击和防御都严格高于其他角色的角色。
//        示例 2：
//
//        输入：properties = [[2,2],[3,3]]
//        输出：1
//        解释：第一个角色是弱角色，因为第二个角色的攻击和防御严格大于该角色。
//        示例 3：
//
//        输入：properties = [[1,5],[10,4],[4,3]]
//        输出：1
//        解释：第三个角色是弱角色，因为第二个角色的攻击和防御严格大于该角色。
//         
//
//        提示：
//
//        2 <= properties.length <= 105
//        properties[i].length == 2
//        1 <= attacki, defensei <= 105
public class _5864_游戏中的弱角色 {
    public int numberOfWeakCharacters(int[][] properties) {
        //根据攻击从大到小排序，如果攻击相同，再根据防御从小到大排序
        Arrays.sort(properties, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]!=o2[0]){
                    return o2[0]-o1[0];
                }
                return o1[1]-o2[1];
            }
        });
        //有序攻击从大到小排序，所以判断当前角色是不是弱角色，只需要判断防御是否比出现过的最大防御要小
        // 如果小，说明当前角色是弱角色
        int result=0,max_def=0;
        for (int[] property : properties) {
            result+=max_def>property[1]?1:0;
            max_def=Math.max(property[1],max_def);
        }
        return result;
    }
}
