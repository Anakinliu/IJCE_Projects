package Fundamentals;

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
    }
}
