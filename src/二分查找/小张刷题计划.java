package 二分查找;
//为了提高自己的代码能力，小张制定了 LeetCode 刷题计划，他选中了 LeetCode 题库中的 n 道题，编号从 0 到 n-1，并计划在 m 天内按照题目编号顺序刷完所有的题目（注意，小张不能用多天完成同一题）。
//
//        在小张刷题计划中，小张需要用 time[i] 的时间完成编号 i 的题目。此外，小张还可以使用场外求助功能，通过询问他的好朋友小杨题目的解法，可以省去该题的做题时间。为了防止“小张刷题计划”变成“小杨刷题计划”，小张每天最多使用一次求助。
//
//        我们定义 m 天中做题时间最多的一天耗时为 T（小杨完成的题目不计入做题总时间）。请你帮小张求出最小的 T是多少。
//
//        示例 1：
//
//        输入：time = [1,2,3,3], m = 2
//
//        输出：3
//
//        解释：第一天小张完成前三题，其中第三题找小杨帮忙；第二天完成第四题，并且找小杨帮忙。这样做题时间最多的一天花费了 3 的时间，并且这个值是最小的。
//
//        示例 2：
//
//        输入：time = [999,999,999], m = 4
//
//        输出：0
//
//        解释：在前三天中，小张每天求助小杨一次，这样他可以在三天内完成所有的题目并不花任何时间。
//
//         
//
//        限制：
//
//        1 <= time.length <= 10^5
//        1 <= time[i] <= 10000
//        1 <= m <= 1000
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/xiao-zhang-shua-ti-ji-hua
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class 小张刷题计划 {
    //前言，这道题卡了我半天，明明思路很清晰就是写不出来，太菜了
    //思路，二分思路和410题一样，不一样的地方在于这道题得用一个指针来记录子数组的最大值
    public int minTime(int[] time, int m) {
        if (time.length<=m){
            return 0;
        }
        int left=0,right=0;
        for (int i:time){
            right+=i;
        }
        while (left<right){
            int mid=left+(right-left)/2;
            int days = getDays(time, mid);
            if (days>m){
                left=mid+1;
            }
            else {
                right=mid;
            }
        }
        return left;
    }
    //碰到sum>speed的时候，需要判断max与当前元素的大小
    public int getDays(int[] arr,int speed){
        int days=0;
        int sum=0;
        boolean flag=false;
        int max=0;
        for (int i=0;i<arr.length;i++){
            if (arr[i]+sum<=speed){
                //如果是最后一个元素，days得+1
                if (i==arr.length-1){
                    days++;
                    break;
                }
                //不断更新max的值
                max=Math.max(max,arr[i]);
                sum+=arr[i];
            }
            else {
                if (!flag){
                    flag=true;
                    //如果是最后一个元素，days得+1
                    if (i==arr.length-1){
                        days++;
                        break;
                    }
                    //进入到这里，说明sum+arr[i]>speed,并且还没有用过求助功能
                    //此时求助功能用掉，如果max小于等于当前值，则更新max值
                    if (arr[i]>=max){
                        max=arr[i];
                    }
                    //此时max大于当前值，sum需要减掉max，然后加上当前值
                    else{
                        sum=sum-max;
                        sum=sum+arr[i];
                    }
                }
                else {
                    //进入下一天，所有东西清零
                    max=0;
                    days++;
                    flag=false;
                    sum=0;
                    i--;
                }
            }
        }
        return days;
    }

    public static void main(String[] args) {
        小张刷题计划 a = new 小张刷题计划();
        int i = a.minTime(new int[]{82,35,6,53,37,75,69,69,53,18}, 4);
        System.out.println(i);;
    }
}
