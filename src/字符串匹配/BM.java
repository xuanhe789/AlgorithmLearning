package 字符串匹配;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

public class BM {
    /*
    * 坏字符规则，将模式串的每个字符存到散列表中，减少判断坏字符的时间复杂度
    * */
    //key是模式串中存在的字符，value是该字符在
    public void generateBC(char[] b, int length, Map<Character,Integer> bcMap){
        if (b==null||b.length==0){
            return;
        }
        for (int i = 0; i < b.length; i++) {
            bcMap.put(b[i],i);
        }
    }


//    originalStr是原始字符串，patternStr是模式串
    public int bm(char[] originalStr, int orignalLength, char[] patternStr ,int patternLength){
        Map<Character, Integer> bcMap = new HashMap<>();
        //1.先初始化与坏字符相关的散列表
        generateBC(patternStr,patternLength,bcMap);
        //2.初始化suffix和prefix数组
        int[] suffix=new int[patternLength];
        boolean[] prefix=new boolean[patternLength];
        generateGS(patternStr,patternLength,suffix,prefix);
        //3.从模式串的最后一个下标开始遍历
        int firstIndex=0;
        while (firstIndex<=orignalLength-patternLength){
            int curIndex;
            for (curIndex=patternLength-1;curIndex>=0;curIndex--){
                if (originalStr[firstIndex+curIndex]!=patternStr[curIndex]){
                    break;
                }
            }
            //如果当前下标指针<0，说明模式串全都匹配了，返回模式串第一个字符对应原始串的下标
            if (curIndex<0){
                return firstIndex;
            }
            //使用坏字符规则计算模式串往后移的位数
            int bcCount=curIndex-bcMap.getOrDefault(originalStr[firstIndex+curIndex],-1);
            int gsCount=0;
            //如果下标指针不是指向模式串最后一个下标，说明存在'好后缀'
            if (curIndex!=patternLength-1){
                //计算好后缀规则往后移动的位数
                gsCount=movebyGS(curIndex,patternLength,suffix,prefix);
            }
            //在bcCount和gsCount选取最大，往后移动的位数也多，效率也高，也能避免坏字符规则可能导致往前移动的场景
            firstIndex=firstIndex+Math.max(gsCount,bcCount);
        }
        return -1;
    }

    /*
    * 好后缀原则,从模式串中截取0到i的子串（i从0取到m-2），然后求子串和模式串的'公共后缀子串'
    * suffix 数组的下标 k，表示好后缀的长度，下标对应的数组值存储的是，在模式串中跟好后缀{u}相匹配的子串{u*}的起始下标值。
    * prefix数组的下标k，表示后缀子串的长度，存储的是boolean类型，true代表长度为k的后缀子串有与之匹配的前缀子串
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
    //firstIndex为'坏字符'在模式串中的下标
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

//    public int bmBad(char[] originalStr, int orignalLength, char[] patternStr ,int patternLength){
//        int firstIndex=0;
//        generateBC(patternStr,patternLength);
//        while (firstIndex<=orignalLength-patternLength){
//            int curIndex;
//            for (curIndex=patternLength-1;patternLength>=0;patternLength--){
//                if (originalStr[firstIndex+curIndex]!=patternStr[curIndex]){
//                    break;
//                }
//            }
//            if (curIndex<0){
//                return firstIndex;
//            }
//            firstIndex=firstIndex+(curIndex-bcMap.getOrDefault(originalStr[firstIndex+curIndex],-1));
//        }
//        return -1;
//    }
}
