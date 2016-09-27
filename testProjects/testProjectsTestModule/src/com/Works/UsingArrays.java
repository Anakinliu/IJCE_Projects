package com.Works;

import java.util.Arrays;
import java.util.Scanner;


/**
 * Created by liu_y.
 * On 2016/9/22.
 */
public class UsingArrays {
    public static int[] setList(int length) {
        if (length <=0 ) {
            System.out.println("非法的数组长度");
            return null;
        }
        Scanner input = new Scanner(System.in);
        int[] a;
        a = new int[length];
        for (int i=0; i<a.length; i++) {
            a[i] = input.nextInt();
        }
        return a;
    }

    public static boolean haven(int[] a) {
        Scanner input = new Scanner(System.in);
        System.out.println("输入搜寻的元素值：");
        int searchFor = input.nextInt();
        //The array must be sorted (as by the sort(int[]) method) prior to making this call.

        if (Arrays.binarySearch(a,searchFor)>=0) {
            //Note that this guarantees that the return value will be >= 0
            // if and only if the key is found.
            return true;
        }
        else {
            return false;
        }

    }

    public static void printList(int[] a) {

        for (int i=0; i<a.length; i++) {
            System.out.print(a[i] + "\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] s;
        s = setList(10);
        Arrays.sort(s);
        System.out.println("Arrays.sort()排序后");
        printList(s);
        System.out.println("是否含有要寻找的元素：" + haven(s));
        String toS = Arrays.toString(s);
        //原数组s的内容没变！
        System.out.println("转换成字符串：");
        System.out.println(toS);
    }
}
