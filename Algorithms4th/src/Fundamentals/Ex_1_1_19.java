package Fundamentals;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by Anakinliu on 17.11.29.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
public class Ex_1_1_19 {
    static class Fibonacci {
        public static long FF(int N) {
            if (N == 0) {
                return 0;
            }
            if (N == 1) {
                return 1;
            }
            return FF(N - 1) + FF(N - 2);
        }
        static long[] stored = new long[101];
        // 计算第N个fibonacci数
        public static long F(int N) {
            if (N == 0) {
                return 0;
            }
            if (N == 1) {
                return 1;
            }
            if (stored[N] != 0) {
                return stored[N];
            } else {
                stored[N] = F(N - 1) + F(N - 2);
            }
            return stored[N];
        }
    }

    public static void main(String[] args) {

        for (int N=0; N < 100; N++) {
            StdOut.println(N + " " + Fibonacci.FF(N));
        }
    }
}
