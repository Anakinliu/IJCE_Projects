package com.Hexo;
import static com.Print.*;
/**
 * Created by liu_y.
 * On 2016/9/27.
 */
public class BitMoveTest {
    public static void main(String[] args) {

        int b = (int)Math.pow(2,31) + 1;
        int c = 0;
        System.out.println(Integer.toBinaryString(c));
        System.out.println(b);
        b = b - 1;
        System.out.println(b);
        System.out.println(Integer.toBinaryString(b));
        int a = -1;
        System.out.println("a :" + Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(a >> 1));
        a = (a >> 10);
        System.out.println(Integer.toBinaryString(a));
        print(a);
    }
}
