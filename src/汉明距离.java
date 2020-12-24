//两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
//
//        给出两个整数 x 和 y，计算它们之间的汉明距离。
public class 汉明距离 {
    //思路：实际上汉明距离就是两个整数异或后的数的1的位数
    public int hammingDistance(int x, int y) {
        //先异或
        int XOR=x^y;
        int distance=0;
        while (XOR!=0){
            if (XOR%2!=0){
                distance++;
            }
            //像右移动一位，等价于XOR/2
            XOR=XOR >> 1;
        }
        return distance;
    }
}
