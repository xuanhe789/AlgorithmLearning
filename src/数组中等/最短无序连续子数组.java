//package �����е�;
////����һ���������飬����ҪѰ��һ�������������飬���������������������������ô�������鶼���Ϊ��������
////
////        ���ҵ���������Ӧ����̵ģ���������ĳ��ȡ�
////
////        ʾ�� 1:
////
////        ����: [2, 6, 4, 8, 10, 9, 15]
////        ���: 5
////        ����: ��ֻ��Ҫ�� [6, 4, 8, 10, 9] ��������������ô���������Ϊ��������
////        ���ӣ�https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray
//public class ����������������� {
//    public int findUnsortedSubarray(int[] nums) {
//        int left=0,right=-1;
//        int max=nums[0],min=nums[nums.length-1];
//        for (int i=0;i<nums.length;i++){
//            if (max>nums[i]){
//                right=i;
//            }
//            else {
//                max=nums[i];
//            }
//            if (min<nums[nums.length-i-1]){
//                left=nums.length-i-1;
//            }
//            else {
//                min=nums[nums.length-i-1];
//            }
//        }
//        return right-left+1;
//    }
//}
