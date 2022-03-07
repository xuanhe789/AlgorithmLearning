package 动态规划从0开始;

import java.util.ArrayList;
import java.util.List;

public class _25_杨辉三角 {
    /*
    * 动态规划，第j层第i个位置的元素值由第j-1层的【第i个元素的值】+【第i-1个元素的值的来】
    * */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> first=new ArrayList<Integer>(){
            {
                this.add(1);
            }
        };
        result.add(first);
        for (int i = 1; i < numRows; i++) {
            List<Integer> list=new ArrayList<>(i+1);
            for (int j=0;j<=i;j++){
                if (j==0||j==i){
                    list.add(1);
                    continue;
                }
                List<Integer> preList = result.get(i - 1);
                list.add(preList.get(j-1)+preList.get(j));
            }
            result.add(list);
        }
        return result;
    }
}
