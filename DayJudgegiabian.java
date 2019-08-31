package ccreate.base.java;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Description：判断距离现在状态
 * @Author: lishaopeng
 * @CreateDate: 2019/8/28 12:01
 * @Company: 青岛云创智能集团
 * @Version: 1.0
 */
public class DayJudgegiabian {
    private static double day;

    public static String dateTime(Date oldTime, Date nowsDate) throws ParseException {

        day = (double) (nowsDate.getTime() - oldTime.getTime()) / (1000 * 3600 * 24);
        DateFormat timeInstance = DateFormat.getTimeInstance();
        String dayTime = timeInstance.format(oldTime);
        DateFormat dateTimeInstance = DateFormat.getDateTimeInstance();
        String dateTime = dateTimeInstance.format(oldTime);
        boolean sameDate = isSameDate(oldTime, nowsDate);
        Boolean yeaterday = isYeaterday(oldTime, nowsDate);
        if (0 <= day && day < 1 && sameDate) {
            return ("今天" + dayTime);
        } else if (0 < day && day < 2 && yeaterday) {
            return ("昨天" + dayTime );
        } else if (-1 < day && day < 0 && sameDate) {
            return ("今天-未来" + dayTime);
        }
        return dateTime;
    }

    /**
     * 判断两个日期是否是同一天
     *
     * @param oldTime
     * @param nowsDate
     * @return
     */

    public static boolean isSameDate(Date oldTime, Date nowsDate) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(oldTime);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(nowsDate);
        boolean isSameYear = cal1.get(Calendar.YEAR) == cal2
                .get(Calendar.YEAR);
        boolean isSameMonth = isSameYear
                && cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH);
        boolean isSameDate = isSameMonth
                && cal1.get(Calendar.DAY_OF_MONTH) == cal2
                .get(Calendar.DAY_OF_MONTH);
        return isSameDate;
    }

    /**
     * 判断时间是否属于昨天
     * @param oldTime
     * @param newTime
     * @return
     * @throws ParseException
     */
    public static Boolean isYeaterday(Date oldTime, Date newTime) throws ParseException {
        if (newTime == null) {
            newTime = new Date();
        }
        //将下面的 理解成  yyyy-MM-dd 00：00：00 更好理解点
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String todayStr = format.format(newTime);
        Date today = format.parse(todayStr);
        //昨天 86400000=24*60*60*1000 一天
        if ((today.getTime() - oldTime.getTime()) >=1000 && (today.getTime() - oldTime.getTime()) <= 86400000) {
            return true;
        }
            return false;
    }

    /**
     * 判断时间是否属于前天
     * @param oldTime
     * @param newTime
     * @return
     * @throws ParseException
     */
    public static Boolean isBefore(Date oldTime, Date newTime) throws ParseException {
        if (newTime == null) {
            newTime = new Date();
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String todayStr = format.format(newTime);
        Date today = format.parse(todayStr);
        System.out.println(todayStr);
        if ((today.getTime() - oldTime.getTime()) >=86401000 &&   ((today.getTime() - oldTime.getTime())<=172800000)){
            return true;
        }
        return false;
    }
}