package com.Hexo;

/**
 * Created by liu_y.
 * On 2016/9/27.
 */
public class TestBitOperator {
    public static void main(String[] args) {
        int a = 0xaa;
        int b = 0x55;
        System.out.println(Integer.toBinaryString(a&b));
        System.out.println(Integer.toBinaryString(a|b));
        System.out.println(Integer.toBinaryString(a^b));
        System.out.println(true&false);
        System.out.println(true|false);
        System.out.println(true^true);
        //! System.out.println(~true);语法错误
    }
}
