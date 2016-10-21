package com.ThingInJava;

/**
 * Created by liu_y.
 * On 2016/10/1.
 */
public class Forceah {
    public static void main(String[] args) {
        int[] a;

        a = new int[10];

        for (int x : a) {
            System.out.println(x);
        }
        for (char c : "I'm a Human".toCharArray()) {
            //77将此字符串转换为一个新的字符数组。
            System.out.print(c);
        }
        return;
    }
}
