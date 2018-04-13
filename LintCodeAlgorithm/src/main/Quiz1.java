package main;

/**
 * Author: Anakinliu
 * Date: 2018/03/28
 * Time: 16:08
 * You may be disappointed if you fail,
 * but you are doomed if you don't try.
 */

/*
使用位运算实现两数相加
 */
public class Quiz1 {
    public static int sumTwo(int a, int b) {
        if (b == 0) {
            return a;
        }
        return sumTwo(a ^ b, (a & b) << 1);
    }

    public static void main(String[] args) {
        System.out.println(sumTwo(1, 9));
    }
}
