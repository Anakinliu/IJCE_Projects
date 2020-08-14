package cn.anakinliu.address.util;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtil {
    private static final String LIKE_PATTERN = "yyyy.MM.dd";

    private static final DateTimeFormatter DATE_FORMATTER =
            DateTimeFormatter.ofPattern(LIKE_PATTERN);

    /*
     * 返回给定日期的格式化后的string
     * */
    public static String format(LocalDate date) {
        if (date == null) {
            return null;
        }
        return DATE_FORMATTER.format(date);
    }

    /*
     * 转换String为定义的格式的对象，如果无法转换返回null
     * */
    public static LocalDate parse(String dateString) {
        try {
            return DATE_FORMATTER.parse(dateString, LocalDate::from);
        } catch (DateTimeException e) {
            return null;
        }
    }

    /*
     * 检查String是否合法Date
     * */
    public static boolean validDate(String dateString) {
        return DateUtil.parse(dateString) != null;
    }

}
