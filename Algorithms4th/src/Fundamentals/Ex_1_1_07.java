package Fundamentals;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by Anakinliu on 17.10.26.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
public class Ex_1_1_07 {
    /*
    斐波那契数列
     */
    private static void a() {
        double t = 9.0;
        int times = 0;
        while (Math.abs(t - 9.0/t) > .001) {
            t = (9.0 / t + t) / 2.0;
            times ++;
        }
        StdOut.printf("t = %.5f\n%d times\n", t, times);
    }

    /*
    前 n 个数的和
     */
    private static void b() {
        int sum = 0;
        for (int i = 1; i < 1000; i++) {
            for (int j = 0; j < i; j++) {
                sum ++;
            }
        }
        StdOut.println(sum);
    }

    private static void c() {
        int sum = 0;
        for (int i = 1; i < 1000; i *= 2) {
            for (int j = 0; j < 1000; j++) {
                sum++;
            }
        }
        StdOut.println(sum);
    }

    public static void main(String[] args) {
        a();
        b();
        System.out.println("======");
        c();
    }
}
