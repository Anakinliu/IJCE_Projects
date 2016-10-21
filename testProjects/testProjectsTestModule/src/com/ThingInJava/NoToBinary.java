package com.ThingInJava;





/**
 * Created by liu_y.
 * On 2016/10/1.
 */
public class NoToBinary {
    public static void main(String[] args) {
        int a = 0xaa;
        for (;a != 0; ) {
            if (a%2 == 0) {
                System.out.print(0 + "");
            }
            else {
                System.out.print("" + 1);
            }
            a = a/2;
        }
        System.out.println();
        int b = 0xffffffff;
        System.out.println("b = " + b);
        System.out.println(Integer.toBinaryString(b));
        int c = 0x7fffffff;
        System.out.println("c =" + c);
        System.out.println("0" + Integer.toBinaryString(c));
        int d = c + 2;
        System.out.println("d= " + d);
        System.out.println(Integer.toBinaryString(d));
        int e = d+c;
        System.out.println("e = " + e);
        System.out.println(Integer.toBinaryString(e));
//        System.out.println(a);
    }
}
