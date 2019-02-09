package Sort;

import edu.princeton.cs.algs4.In;

import java.util.Arrays;

/*
    AUTHOR: linux
    TIME: 2018/5/20
    GOOD LUCK AND NO BUG.
*/
public class InsertionSort extends Example {

    // 升序排列
    @Override
    public void sort(Comparable[] a) {
        int length = a.length;
        for (int i = 0; i < length; i++) {

            // 将a[i]插入到a[i-1], a[i-2], api-3[之中
            for (int j = i; j > 0 && less(a[j], a[j-1]) ; j--) {
                showWithGraphic(a, j, i);
                exch(a, j-1, j);

            }
        }
    }

    public static void main(String[] args) {


        new InsertionSort().sort(data);

        show(data);
    }
}
