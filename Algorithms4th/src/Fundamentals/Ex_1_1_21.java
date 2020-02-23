package Fundamentals;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;

import java.util.Arrays;

/**
 * Created by Anakinliu on 17.12.7.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
/*
编写一段程序，从标准输入按行读取数据，其中每行都包含一个名字和两个整数。然后用
printf() 打印一张表格，每行的若干列数据包括名字、两个整数和第一个整数除以第二个整数
的结果，精确到小数点后三位。可以用这种程序将棒球球手的击球命中率或者学生的考试分数
制成表格。

 */
public class Ex_1_1_21 {
    public static void main(String[] args) {
        In sheet = new In(args[0]);
        String raw = sheet.readLine();
        System.out.println("name\t\tscore\t\tfull");
        System.out.println("----------------------");
        while (raw != null) {
            String[] r = raw.split(" ");
            System.out.printf("%-8s\t%-8s\t%-8s\n", r[0], r[1], r[2]);
            System.out.println("----------------------");
            raw = sheet.readLine();
        }
    }
}
