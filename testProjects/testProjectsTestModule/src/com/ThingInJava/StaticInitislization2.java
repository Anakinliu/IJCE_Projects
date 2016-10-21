package com.ThingInJava;

/**
 * Created by liu_y.
 * On 2016/10/16.
 */

class StringStatic {
    static String firstName = "liu ";
    static String lastName;
    static {
        //在静态块外定义，块内初始化。。。
        lastName = "yin quan";
    }
    static void printName() {
        System.out.println(firstName + lastName);
    }
}
public class StaticInitislization2 {
    public static void main(String[] args) {
        StringStatic ss1 = new StringStatic();
        StringStatic ss2 = new StringStatic();


    }
}
