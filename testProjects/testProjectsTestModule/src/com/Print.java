package com;

import com.ThingInJava.ObjectArrays;
import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.*;
/**
 * Created by liu_y.
 * On 2016/10/22.
 */
public class Print {
    public static void print(Object obj) {
        System.out.println(obj);
    }//print with a newline

    public static void print() {
        System.out.println();
    }//print with a white line

    public static void printnb(Object obj) {
        System.out.print(obj);
    }//print with no line break;

    public static PrintStream
    printf(String format, Object... args) {
        return System.out.printf(format,args);
    }

}
