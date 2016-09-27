package com.bilibili;

/**
 * Created by liu_y.
 * On 2016/9/11.
 */
public class MaoPao {
    private static void printArray(int[] array){
        for (int i=0;i<array.length;i++){
            System.out.println(array[i] + " ");
        }
        System.out.println("");
    }
    public static void main(String[] args) {
        int len = 10;
        int[] a;
        a = new int[len];
        for (int i=0;i<a.length;i++) {
            if (i == 0) {
                a[i] = 10;
            }
            else {
                if (i % 2 == 0) {
                    a[i] = i - 2;
                } else {
                    a[i] = i;
                }
            }
        }
        int i,j,temp;
//        for (i=0;i < len;i++) {
//            for (j=len - i - 1;j>i;j--) {
//                if (a[j] < a[j - 1] ) {
//                    temp = a[j];
//                    a[j] = a[j - 1];
//                    a[j - 1] = temp;
//                }
//            }
//        }
        for (i=len-1;i > 0;i--) {
            for (j=0;j<i;j++) {
                if (a[j] < a[j + 1] ) {
                    temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }

            }
        }
        printArray(a);
    }
}
