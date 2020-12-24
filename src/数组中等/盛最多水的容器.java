package 数组中等;
//给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，
//        垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，
//        使得它们与 x 轴共同构成的容器可以容纳最多的水。
//
//        说明：你不能倾斜容器。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/container-with-most-water
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class 盛最多水的容器 {
    //思路：双指针，短的那一端向内移动
//    在每一个状态下，无论长板或短板收窄 11 格，都会导致水槽 底边宽度 -1−1：
//    若向内移动短板，水槽的短板 min(h[i], h[j])min(h[i],h[j]) 可能变大，因此水槽面积 S(i, j)S(i,j) 可能增大。
//    若向内移动长板，水槽的短板 min(h[i], h[j])min(h[i],h[j]) 不变或变小，下个水槽的面积一定小于当前水槽面积。
    public int maxArea1(int[] height) {
        int value;
        int max=0;
        int left=0;
        int right=height.length;
        while (left!=right){
            value=Math.min(height[left],height[right]) *(right-left);
            if (max<value){
                max=value;
            }
            if (height[left]>height[right]){
                right--;
            }
            else {
                left++;
            }
        }
        return max;
    }
    //垃圾解法，暴力法
    public int maxArea(int[] height) {
        int max=0;
        for (int i=0;i<height.length;i++){
            for (int j=i+1;j<height.length;j++){
                int value=Math.min(height[i],height[j]) * (j-i);
                if (value>max){
                    max=value;
                }
            }
        }
        return max;
    }
}
