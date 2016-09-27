package com.bilibili;

import jdk.nashorn.internal.parser.Scanner;

/**
 * Created by liu_y.
 * On 2016/9/11.
 */
public class ValueOf {
    public static void main(String[] args) {
        int[] x;
        x = new int[args.length];
        for (int i=0;i<args.length;i++){
            x[i] = Integer.parseInt(args[i]);
        }
        printArray(x);
    }
    private static void printArray(int[] array){
        for (int i=0;i<array.length;i++){
            System.out.println(array[i] + " ");
        }
    }
}
