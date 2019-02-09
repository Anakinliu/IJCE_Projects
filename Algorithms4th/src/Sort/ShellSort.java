package Sort;

import edu.princeton.cs.algs4.In;

import java.util.Arrays;

/*
    AUTHOR: linux
    TIME: 2018/5/21
    GOOD LUCK AND NO BUG.
*/
// https://zh.wikipedia.org/wiki/希尔排序
// TODO 插入排序 步长 是1, 希尔排序不断减少步长直到步长为1
public class ShellSort extends Example {

    // 升序排序
    @Override
    public void sort(Comparable[] a) {
        int length = a.length;
        int h = 1;

        // TODO 步长 的选择很重要
        while (h < length / 3) {
            h = 3 * h + 1;  // 1, 4, 13, 40, 121...
        }
        while (h >= 1) {
            // 将数组变为h有序
            for (int i = h; i < length; i++) {
                // 将a[i] 插入到 a[i-h], a[i-2*h], a[i-3*h]中
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    showWithGraphic(a, j, i);
                    exch(a, j, j - h);
                }
            }
            h = h / 3;
        }
    }

    public static void main(String[] args) {

        new ShellSort().sort(data);
        show(data);
    }
}
