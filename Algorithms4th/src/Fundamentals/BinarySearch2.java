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
public class BinarySearch2 {
    public static int rank(int[] a, int key) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (key < a[mid]) {
                high = mid - 1;
            } else if (key > a[mid]) {
                low = mid + 1;
            } else {
                return a[mid];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // 将不在白名单上的证书打印出来

        int[] whiteList = new In(args[0]).readAllInts();
        Arrays.sort(whiteList);
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            int result = rank(whiteList, key);
            if (result < 0) {
                StdOut.println("not in whitelist: " + key);
            }  {
                System.out.println("in whitelist: " + result);
            }
        }
    }
}
