package ccreate.base.java;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Yestaday {


    //是不是昨天
    public static boolean isYesToday(String dateStr) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        Date date = new Date();
        try {
            date = format.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date date2 = new Date(System.currentTimeMillis());
        date2.setHours(0);
        date2.setMinutes(0);
        date2.setSeconds(0);
        int tmp = 86400000;

        long day1 = date.getTime() / tmp;
        long day2 = date2.getTime() / tmp;

        if (day2-day1 == 1) {
            return true;
        } else {
            return false;
        }
    }

    //时间戳转化为时间（毫秒）
    public static String getDateToString(long milSecond) {
        try {
            String pattern = "yyyy-MM-dd HH:mm:ss";
            Date date = new Date(milSecond*1000);
            SimpleDateFormat format = new SimpleDateFormat(pattern);
            return format.format(date);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }

}
