package Tests;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by Anakinliu on 17.10.18.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
public class TestStdRandom {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++)
            StdOut.printf("%2$.15s\n", StdRandom.bernoulli(0.5), "i'm the second argument");

        double N = 50.0;
        StdDraw.setXscale(0.0, N);
        StdDraw.setYscale(0.0, N);
        StdDraw.setPenRadius(0.01);
        StdDraw.setPenColor(StdDraw.RED);
        // StdDraw.clear(StdDraw.BLACK);
        StdDraw.circle(20.0, 20.0, 20.0);
    }
}
