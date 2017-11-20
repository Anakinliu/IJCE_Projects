package Fundamentals;

import java.util.Arrays;

/**
 * Created by Anakinliu on 17.11.20.
 * If you only do what you can do,
 * you'll never be more than you are now.
 *
 * TODO 编写一个静态方法histogram()，接受一个整型数组a[] 和一个整数M 为参数并返回一个大小
 * TODO 为M的数组，其中第i个元素的值为整数i在参数数组中出现的次数。如果a[]中的值均在0到M-1
 * TODO 之间，返回数组中所有元素之和应该和a.length 相等。
 */
public class Ex_1_1_15 {
    private static int[] histogram(int[] a, int M) {
        int[] result = new int[M];
        for (int i = 0, j; i < M; i++) {
            //result[i] = 0;
            for (j = 0; j < a.length; j++) {
                if (a[j] == i) {
                    result[i]++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 2, 3, 4, 0};
        System.out.println(Arrays.toString(histogram(a, 5)));
    }
}
