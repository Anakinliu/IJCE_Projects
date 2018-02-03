package Sort;

/**
 * Created by Anakinliu on 18.1.24.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */

import edu.princeton.cs.algs4.StdOut;

/**
 * 模板类
 * 任何实现了Comparable的类都可以进行排序
 */
public class Example {
    /***
     * 排序数组
     * @param a 实现了Comparable的对象数组
     */
    public static void sort(Comparable[] a) {
        // 每种排序算法的具体实现
    }

    /***
     * 比较两个实现了Comparable对象
     * @param v 对象一
     * @param w 对象二
     * @return true:对象一小于对象二 false:对象一大于对象二
     */
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    /***
     *
     * @param a 交换数组的两个元素
     * @param i 元素一
     * @param j 元素二
     */
    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    /***
     * 单行打印数组
     * @param a 要打印的数组
     */
    private static void show(Comparable[] a) {
        for (Comparable anA : a) {
            StdOut.print(anA + " ");
        }
        StdOut.println();
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
