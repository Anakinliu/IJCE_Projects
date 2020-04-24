package com.yy.utils;

/*
    AUTHOR: linux
    TIME: 2020/4/21
    GOOD LUCK AND NO BUG.
*/
/*
曲线参数换行
 */
public class FormatText {
    public static String format(String s) {
        int l = s.length();
        int left = 0;
        int step = 71;
        StringBuilder sb = new StringBuilder();
        while (left + step < l) {
            sb.append(s.substring(left, 71 + left) );
            sb.append("\n");
            left += (step + 1);
        }
        System.out.println(sb.toString());
        return sb.toString();
    }
}
