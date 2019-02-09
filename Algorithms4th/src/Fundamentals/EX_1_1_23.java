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
public class EX_1_1_23 {
    public static void main(String[] args) {
        int[] whiteList = new In(args[0]).readAllInts();
        Arrays.sort(whiteList);
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            int result = BinarySearch2.rank(whiteList, key);
            if (result < 0 && args[1].equals("+")) {
                StdOut.println("not in whitelist: " + key);
            }
            if (result >= 0 && args[1].equals("-")) {
                System.out.println("in whitelist: " + result);
            }
        }
    }
}
