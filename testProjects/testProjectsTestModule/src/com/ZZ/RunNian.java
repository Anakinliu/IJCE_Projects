package com.ZZ;

import java.util.Scanner;

/**
 * Created by liu_y.
 * On 2016/9/14.
 */
public class RunNian {
    public static void main(String[] args) {
        int year;
        Scanner input = new Scanner(System.in);
        year = input.nextInt();
        if (year%4==0&&year%100!=0) {
            System.out.println("是闰年");
        }
        else if (year%400==0&&year%100==0) {
            //这是四百
            System.out.println("是闰年");
        }
        else {
            System.out.println("不是闰年");
        }

    }
}
