import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
//
//        给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
//
//
//
//        示例:
//
//        输入："23"
//        输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
//        说明:
//        尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class 电话号码的字母组合 {
    //回溯法
    //最终输出结果的list
    public List<String> result=new ArrayList<>();
    //映射表，存储数字对应的字母
    Map<Character,String> map;
    public List<String> letterCombinations(String digits) {
        map=initMap();
        if (digits.length()==0){
            return result;
        }
        StringBuilder stringBuilder = new StringBuilder();
        dfs(digits,stringBuilder,0);
        return result;
    }

    public void dfs(String digits,StringBuilder stringBuilder,int index){
        //递归终止条件，index值等于输入数字字符串的长度时
        //将字符串加到结果集
        if (index==digits.length()){
            result.add(stringBuilder.toString());
            return;
        }
        char c=digits.charAt(index);
        String s = map.get(c);
        for (int i=0;i<s.length();i++){
            //调用下一层递归，用文字很难描述
            stringBuilder.append(s.charAt(i));
            dfs(digits,stringBuilder,index+1);
            //每有一个字符串加入结果集后，就清除stringbuilder中的数据
            //防止影响后面的字符串
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
    }

    public Map<Character,String> initMap(){
        Map<Character,String> map=new HashMap<>();
        map.put('1',"");
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        return map;
    }

}
