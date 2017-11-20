package Fundamentals;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by Anakinliu on 17.10.26.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
public class EX_1_1_06 {
    public static void main(String[] args) {
        int f = 0;
        int g = 1;
        for (int i=0; i <= 15; i++) {
            StdOut.println(f);
            f += g;
            g = f - g;
        }
    }
}
