package 动态规划从0开始;

import java.util.ArrayList;
import java.util.List;

public class _26_杨辉三角II {
    /*
    * 动态规划
    * */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result=new ArrayList<>(rowIndex+1);
        result.add(1);
        for (int i=1;i<=rowIndex;i++){
            for (int j=i; j>=1;j--){
                if (j==i){
                    result.add(1);
                    continue;
                }
                result.set(j,result.get(j)+result.get(j-1));
            }
        }
        return result;
    }
}
