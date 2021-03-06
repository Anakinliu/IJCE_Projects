package com.Works;

import java.util.Calendar;
import java.util.Scanner;

/**
 * Created by liu_y.
 * On 2016/10/21.
 */
public class ACalendar {
    public static void show(int year, int month) {
        Calendar rightNow = Calendar.getInstance();//获得一个日历
        rightNow.set(Calendar.YEAR,year);//设置年份为所输入的年份
        rightNow.set(Calendar.MONTH,month - 1);
        System.out.print(rightNow.get(Calendar.YEAR) + "年");
        System.out.println(rightNow.get(Calendar.MONTH)+1 + "月：");
        System.out.println("日\t一\t二\t三\t四\t五\t六");
        rightNow.set(Calendar.DAY_OF_MONTH,1);
        int day;
        for (int i=1;i <=rightNow.getActualMaximum(Calendar.DAY_OF_MONTH ); i++) {

            day = rightNow.get(Calendar.DAY_OF_WEEK);
            if (i == 1) {
                for (int j=1;j<day;j++) {
                    System.out.print("\t");
                }
            }
            System.out.print(i+ "\t");

            if (day == 7) {
                System.out.println();
            }
            rightNow.roll(Calendar.DAY_OF_MONTH,1);
        }
    }
    public static void main(String[] args) {

        System.out.println("输入年份，月份：");
        Scanner input = new Scanner(System.in);
        try {
            show(input.nextInt(),input.nextInt());
        }
        catch (Exception e) {
            System.out.println("输入有误！");
        }
    }
}
