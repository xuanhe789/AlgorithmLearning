package leetcode每日一题;

public class _495_提莫攻击 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length==1){
            return duration;
        }
        int result=0;
        int cur=timeSeries[0];
        for (int i=1;i<timeSeries.length;i++){
            int timeSery=timeSeries[i];
            if (timeSery>=cur+duration){
                result+=duration;
            }else {
                result+=timeSery-cur;
            }
            cur=timeSery;
        }
        result+=duration;
        return result;
    }
}
