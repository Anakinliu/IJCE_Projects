package Tests;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

/*
    AUTHOR: linux
    TIME: 2018/5/1
    GOOD LUCK AND NO BUG.
*/

public class DrawIt {
    /**
     * 函数
     */
    private static void ex1() {
        int N = 200;
        StdDraw.setXscale(0, N);
        StdDraw.setYscale(0, N);
        StdDraw.setPenRadius(.01);
        // 三个不同增长率的函数
        for (int i = 1; i <= N; i++) {
            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.point(i, i);
            StdDraw.setPenColor(StdDraw.GREEN);
            StdDraw.point(i, i * i);
            StdDraw.setPenColor(StdDraw.BLUE);
            StdDraw.point(i, i * Math.log(i));
        }

    }

    private static void ex2() {
        StdDraw.setXscale(0, 1);
        StdDraw.setYscale(0, 1);
        int N = 50;
        double[] a = new double[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform();
        }
        for (int i = 0; i < N; i++) {
            double x = 1.0 * i / N;  // 0.0, 0.02, 0.04, 0.06
            double y = a[i] / 2.0;  // 高度随机, 纵坐标随机
            double rw = 0.5 / N;  // 0.01 宽度固定
            double rh = a[i] / 2.0;  // 高度随机
            System.out.println(x + " " + y);

            StdDraw.setPenRadius(0.02);
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.filledRectangle(x, y, rw, rh);

            StdDraw.setPenColor(StdDraw.GREEN);
            StdDraw.setPenRadius(0.05);
            StdDraw.text(x, y, Integer.toString(i));
        }
    }

    private static void ex3() {
        StdDraw.setXscale(0, 1);
        StdDraw.setYscale(0, 1);
        int N = 50;
        double[] a = new double[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform();
        }
        Arrays.sort(a);
        for (int i = 0; i < N; i++) {
            double x = 1.0 * i / N;  // 0.0, 0.02, 0.04, 0.06
            double y = a[i] / 2.0;  // 高度随机, 纵坐标随机
            double rw = 0.5 / N;  // 0.01 宽度固定
            double rh = a[i] / 2.0;  // 高度随机
            System.out.println(x + " " + y);

            StdDraw.setPenRadius(0.02);
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.filledRectangle(x, y, rw, rh);

            StdDraw.setPenColor(StdDraw.GREEN);
            StdDraw.setPenRadius(0.05);
            StdDraw.text(x, y, Integer.toString(i));
        }
    }

    public static void main(String[] args) {
//        StdDraw.setXscale(0, 100);  // x范围区间
//        StdDraw.setYscale(0, 100);  // y范围区间
//
//        StdDraw.setPenColor(0, 255, 0);
//
//        StdDraw.line(0, 0, 100, 100);
//        StdDraw.filledCircle(50, 50, 10);
//        StdDraw.square(50, 50, 40);  // 正方形, x y为正方形中心点坐标, halfLength为边长一半

//        ex1();
//        StdDraw.clear();
//        ex2();
        StdDraw.clear();
        ex3();
    }
}
