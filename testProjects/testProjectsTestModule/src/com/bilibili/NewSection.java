package com.bilibili;

/**
 * Created by liu_y.
 * On 2016/9/11.
 */
public class NewSection {
    public static void main(String[] args) {
        int[] arr;
        arr = new int[9];
        for (int i=0;i<arr.length;i++) {
            if (i == 0) {
                arr[i] = 10;
            }
            else {
                if (i % 2 == 0) {
                    arr[i] = i - 2;
                } else {
                    arr[i] = i;
                }
            }
        }
        printArray(arr);
        sortArray(arr);
       printArray(arr);
    }
    private static void sortArray(int[] array){
        int argeLen = array.length;
        int i,j,temp,minIndex;
//优化的选择排序
        for (i=0;i<argeLen - 1 ;i++) {
            minIndex = i;
            for (j = i + 1;j<argeLen;j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
        System.out.println("");
    }
    private static void printArray(int[] array){
        for (int i=0;i<array.length;i++){
            System.out.println(array[i] + " ");
        }
        System.out.println("");
    }
    private static int findMinIndex(int[] array,int index) {
        int min = array[index];
        int minIndex = index;
        for (int i=index + 1;i<array.length;i++) {
            if (array[i] < min) {
                min = array[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
    private static int findMax(int[] array,int index) {
        int max = array[index];
        for (int i=index + 1;i<array.length;i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
}
