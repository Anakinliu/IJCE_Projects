package Fundamentals;
// http://introcs.cs.princeton.edu/java/stdlib/javadoc/
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.io.File;
import java.util.Arrays;
public class BinarySearch {
    public static int rank(long key, long[] a) {
       // System.out.println("the key is " + key);
        int low = 0;
        int high = a.length - 1;
        int mid = 0 ;
        int steps = 0;
        while (low <= high) {
            mid = low + (high - low) / 2;
            System.out.println( "==" + a[mid] + "==");
            if (a[mid] == key || a[low] == key || a[high] == key) {
                System.out.println("found , use " + (steps + 1));
                return 1;
            }
            else if (a[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
            steps++;
        }
        return -1;
    }
    private static int slowRank(long key, long[] a) {
        int length = a.length;
        for (int i = 0; i < length; i++) {
            if (a[i] == key) {
                System.out.println("finally, i found");
                return i;
            }
        }
        System.out.println("sorry....");
        return -1;
    }
    public static void main(String[] args) {
        // int[] a = new int[100];
        // for (int i=0; i < a.length; i++) {
        // 	a[i] = i;
        // }

        // if (rank(99, a) == -1) {
        // 	System.out.println("filed");
        // }
        In in = new In("F:\\IJCE\\Algorithms4th\\src\\Fundamentals\\in.txt");
        long[] list = in.readAllLongs();
        Arrays.sort(list);

        System.out.println(4.1 >= 4);
        while (!StdIn.isEmpty())
        {
            long key = StdIn.readLong();
            if (slowRank(key, list) == -1)
                StdOut.println("sorry, i can't find the " + key);
        }
    }
}
