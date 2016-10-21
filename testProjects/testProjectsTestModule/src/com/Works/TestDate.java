package com.Works;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by liu_y.
 * On 2016/10/21.
 */
public class TestDate {
    public static void main(String[] args) {
        //“XX年XX月XX日XX时XX分XX秒 X午 星期X”
        SimpleDateFormat date = new SimpleDateFormat("yy年MM月dd日HH时mm分ss秒 a E");
        Date now = new Date();
        System.out.println("今天：" + date.format(now));
        System.out.println("当前毫秒数: " + now.getTime());
        Calendar cal = new GregorianCalendar();
        cal.set(Calendar.DAY_OF_MONTH,1);
        System.out.println("明天：" + date.format((cal.getTime())));
//XX年XX月XX日星期X
        date.applyPattern("yy年MM月dd日 E");
        System.out.println("今天：" + date.format(now));
    }
}
