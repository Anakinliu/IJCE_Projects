package com.Works;

import java.util.*;
/**
 * Created by liu_y.
 * On 2016/9/22.
 */
public class Insert {
    public static void insertSort( int[] arr ) {
        for( int i=0; i<arr.length-1; i++ ) {
            for( int j=i+1; j>0; j-- ) {
                if( arr[j-1] <= arr[j] )
                    break;
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
            }
        }
    }
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

    public static void printList(int[] a) {
        for (int i=0; i<a.length; i++) {
            System.out.print(a[i] + "\t");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int s[];
        s = setList(10);
        insertSort(s);
        printList(s);
    }
}
