package 字符串匹配;

public class KMP {
    public static int kmp(char[] mainStr, int mainStrLength, char[] patternStr, int patternStrLength) {
        //next数组存储的是模式串中每个前缀的最长可匹配前缀子串的结尾字符下标
        //next[i],i表示模式串前缀的结尾字符下标
        int[] next=getNext(patternStr,patternStrLength);
        //j为当前模式串与主串对比的字符的指针
        int j=0;
        for (int i = 0; i < mainStr.length; i++) {
            //当j>0时，也就是说从模式串第二个字符开始才需要用到next数组
            while (j>0&&mainStr[i]!=patternStr[j]){
                //不满足条件，寻找最后一个字符符合好前缀最后一个字符的可匹配前缀
                //然后j往后移一位，与主串i下标的字符比较
                j=next[j-1]+1;
            }
            //如果模式串j下标的字符匹配主串i下标的字符，那么往后移一位j+1，进入下一轮循环i+1，继续比较
            if (mainStr[i]==patternStr[j]){
                j++;
            }
            if (j==patternStrLength){
                return i-patternStrLength+1;
            }
        }
        return -1;
    }

    private static int[] getNext(char[] patternStr, int patternStrLength) {
        int[] next=new int[patternStrLength];
        next[0]=-1;
        int k=-1;
        for (int i = 1; i < patternStr.length; i++) {
            while (k>=0&&patternStr[k+1]!=patternStr[i]){
                k=next[k];
            }
            if (patternStr[k+1]!=patternStr[i]){
                k++;
            }
            next[i]=k;
        }
        return next;
    }
}
