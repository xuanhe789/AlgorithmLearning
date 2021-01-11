package 日期;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class 计算两个日期相差多少天 {
    /**
     * JAVA计算两个日期相差多少天(by date)
     * @author zhengkai.blog.csdn.net
     */
    public static int daysBetween(Date date1, Date date2){
        Calendar instance = Calendar.getInstance();
        instance.setTime(date1);
        long time1=instance.getTimeInMillis();
        instance.setTime(date2);
        long time2=instance.getTimeInMillis();
        long days=(time2-time1)/(1000*60*24);
        return Integer.parseInt(days+"");
    }

    /**
     * JAVA计算两个日期相差多少天(by Date String with format "yyyy-MM-dd")
     * @author zhengkai.blog.csdn.net
     */
    public static int daysBetween(String date1str,String date2str) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = format.parse(date1str);
        Date date2 = format.parse(date2str);
        int a = (int) ((date1.getTime() - date2.getTime()) / (1000*3600*24));
        return a;
    }
}
