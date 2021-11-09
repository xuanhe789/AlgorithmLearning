package 字符串匹配;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

public class BM {
    /*
    * 坏字符规则，将模式串的每个字符存到散列表中，减少判断坏字符的时间复杂度
    * */
    //key是模式串中存在的字符，value是该字符在
    Map<Character,Integer> bcMap= new HashMap<>();
    public void generateBC(char[] b, int length){
        if (b==null||b.length==0){
            return;
        }
        for (int i = 0; i < b.length; i++) {
            bcMap.put(b[i],i);
        }
    }


    //originalStr是原始字符串，patternStr是模式串
//    public int bm(char[] originalStr, int orignalLength, char[] patternStr ,int patternLength){
//
//    }

    /*
    * 好后缀原则,从模式串中截取0到i的子串（i从0取到m-2），然后求子串和模式串的'公共后缀子串'
    * 如果存在'公共后缀子串'就表明了一定存在不同的地方存在这个'公共后缀子串'，'公共后缀子串'长度为k，因此suffix[k]=j，j为'公共后缀子串'在截取的子串中第一个字符的下标
    * 如果j为0，说明是前缀子串，因此prefix[k]=true
    * */
    private void generateGS(char[] a, int length, int[] suffix, boolean[] prefix){
        for (int i = 0; i < length; ++i) { // 初始化
             suffix[i] = -1;
             prefix[i] = false;
        }
        for (int i=0;i<length-1;i++){
            int k=0;//公共后缀子串的长度
            //
            while (k<=i&&a[i-k]==a[length-k-1]) {
                k++;
                //i-k+1表示公共后缀子串在b[0, i]中的起始下标
                suffix[k] = i - k + 1;
            }
            //如果k>i，表示整个截取子串刚好就是模式串的'公共后缀子串'，也就是前缀子串，因此prefix[k]=true
            if (k>i){
                prefix[k]=true;
            }
        }
    }
    //firstIndex为'好后缀'在模式串中第一个字符的下表
    private int movebyGS(int firstIndex, int patternLength, int[] suffix, boolean[] prefix){
        //计算好后缀的长度
        int length=patternLength-firstIndex-1;
        if (suffix[length]!=-1){
            //firstIndex+1表示'好后缀'第一个字符的下标
            return (firstIndex+1)-suffix[length];
        }
        for (int i=firstIndex+2;i<patternLength;i++){
            //从'好后缀'的第二个字符开始截取子串，如果和模式串的前缀匹配，那么移动的位数就是模式串第一个字符移动到第i个字符，也就是返回i
            if (prefix[patternLength-firstIndex]){
                return i;
            }
        }
        //如果好后缀不存在，以及模式串没有'前缀子串'和'好后缀'相匹配，则往右移动模式串的长度
        return patternLength;
    }

    public int bmBad(char[] originalStr, int orignalLength, char[] patternStr ,int patternLength){
        int firstIndex=0;
        generateBC(patternStr,patternLength);
        while (firstIndex<=orignalLength-patternLength){
            int curIndex;
            for (curIndex=patternLength-1;patternLength>=0;patternLength--){
                if (originalStr[firstIndex+curIndex]!=patternStr[curIndex]){
                    break;
                }
            }
            if (curIndex<0){
                return firstIndex;
            }
            firstIndex=firstIndex+(curIndex-bcMap.getOrDefault(originalStr[firstIndex+curIndex],-1));
        }
        return -1;
    }
}
