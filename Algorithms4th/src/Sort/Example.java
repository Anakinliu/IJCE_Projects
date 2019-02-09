package Sort;

/**
 * Created by Anakinliu on 18.1.24.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * 模板类
 * 任何实现了Comparable的类都可以进行排序
 */
public abstract class Example {

    static Double[] data;

    Example() {
        String path = "E:\\IJCE\\Algorithms4th\\src\\Fundamentals\\in.txt";
        data = Arrays.stream(new In(path).readAllDoubles()).boxed().toArray(Double[]::new);;
    }

    /***
     * 排序数组
     * @param a 实现了Comparable的对象数组
     */
    public abstract void sort(Comparable[] a);

    /***
     * 比较两个实现了Comparable对象
     * @param v 对象一
     * @param w 对象二
     * @return true:对象一小于对象二 false:对象一大于对象二
     */
    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    /***
     *
     * @param a 交换数组的两个元素
     * @param i 元素一
     * @param j 元素二
     */
    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    /***
     * 单行打印数组
     * @param a 要打印的数组
     */
    public static void show(Comparable[] a) {
        for (Comparable anA : a) {
            StdOut.print(anA + " ");
        }
        StdOut.println();
    }

    /**
     *
     * @param comparables
     * @param j j=-1则不特别显示j, 否则绘制第 j 个矩形时为红色
     * @param _i i=-1则不特别显示i, 否则绘制第 j 个矩形时为绿色
     */
    public static void showWithGraphic(Comparable[] comparables, int j, int _i) {
        // 100 以内的整数为样本
        int scale = 100;
        StdDraw.setXscale(0, scale);
        StdDraw.setYscale(0, scale);
        StdDraw.clear(StdDraw.BLACK);
        int length = comparables.length;

        for (int i = 0; i < length; i++) {
            double x = scale * i / length;
            double y = (double) comparables[i] / 2.0;
            double rw = 1.0;
            double rh = y;

            StdDraw.setPenRadius(0.02);

            if (j == i && j == _i) {
                // j 与 _i 相等时是 蓝色
                StdDraw.setPenColor(StdDraw.BLUE);
                StdDraw.filledRectangle(x, y, rw, rh);
            } else {
                if (j != -1 && j == i) {
                    // 标注 j 下标的矩形为红色
                    StdDraw.setPenColor(StdDraw.RED);
                    StdDraw.filledRectangle(x, y, rw, rh);
                } else if (_i != -2 && i == _i) {
                    // 标注 _i 下表的矩形为绿色
                    StdDraw.setPenColor(StdDraw.GREEN);
                    StdDraw.filledRectangle(x, y, rw, rh);
                } else {
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledRectangle(x, y, rw, rh);
                }
            }
        }
        StdDraw.pause(1000);
//        try {
//            Thread.sleep(400);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        StdDraw.clear(StdDraw.BLACK);
    }

    /***
     * 检查数组a是否完全按照升序
      * @param a
     * @return 未完全按照升序排序就返回false
     */
    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }
}
