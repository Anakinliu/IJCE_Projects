package Fundamentals;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/*
    AUTHOR: linux
    TIME: 2018/5/4
    GOOD LUCK AND NO BUG.
*/
public class BinarySearch3 {
    public static int rank(int[] a, int key) {
        return rank(a, key, 0, a.length - 1, 1);
    }

    // 返回结果在已排序数组的位置
    private static int rank(int[] a, int key, int low, int high, int level) {
        for (int i = 0; i < level; i++) {
            System.out.print("\t");
        }
        int result = -1;
        System.out.printf("low: %s high: %s \n", low, high);  // 自动装箱
        if (low > high) {
            return -1;
        }
        int mid = low + (high - low) / 2;
        if (key < a[mid]) {
            result = rank(a, key, low, mid - 1, ++level);
        } else if (key > a[mid]) {
            result = rank(a, key, mid + 1, high, ++level);
        } else {
            return mid;
        }
        return result;

    }

    public static void main(String[] args) {
        int[] whiteList = new In(args[0]).readAllInts();
        Arrays.sort(whiteList);
        System.out.println(Arrays.toString(whiteList));
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            System.out.println("your key is " + key);
            int result = rank(whiteList, key);
            if (result >= 0) {
                StdOut.println(key + " is exist at sorted arrays " + result + ".");
            }
        }
//        int[] a = new int[]{1, 2, 3, 4, 5, 6};
//        int key = 2;
//        System.out.println(rank(a, key));
    }
}
