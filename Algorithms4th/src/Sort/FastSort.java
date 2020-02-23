package Sort;

import java.util.Arrays;

/*
    AUTHOR: linux
    TIME: 2018/5/14
    GOOD LUCK AND NO BUG.
*/
public class FastSort {
    public static void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(int[] a, int low, int high) {
        if (high <= low) {
            return;
        }
        int j = partition(a, low, high);
        sort(a, low, j - 1);
        sort(a, j + 1, high);

    }
    /*
    return true if a < b
     */
    public static boolean less(int a, int b) {
        return a < b;
    }

    // x, y参数试为数组索引, 交换值
    public static void exch(int[] a, int x, int y) {
        int c = a[x];
        a[x] = a[y];
        a[y] = c;
    }

    /*
    返回a[low]在排序后的数组中的正确位置
     */
    public static int partition(int[] a, int low, int high) {

        int i = low, j = high + 1;  // 左, 右扫描指针
        int v = a[low];  // 取a[low]为切分数

        while (true) {
            // 扫描l左侧元素, 直到出现大于a[low]或者 i==high
            while (less(a[++i], v)) {
                if (i == high) {  // 因为可能碰巧 j 一直没动
                    break;
                }
            }
            // 扫描l左侧元素, 直到出现小于a[low]或者 j==low
            while (less(v, a[--j])) {
                if (j == low) {  // // 因为可能碰巧 i 一直没动
                    break;
                }
            }

            // 循环结束的条件
            if (i >= j) {
                System.out.print(String.format("flag! i = %d , j = %d", i, j));
                System.out.println(" | a : " +  Arrays.toString(a));
                break;
            }
            // 注意, 不要写在 if(i >= j) 前面 !
            exch(a, i, j);

        }

        // 将 v, 即 a[j] 放到已找到的 正确的位置 j 处
        exch(a, j, low);

        return j;
    }

    public static void main(String[] args) {
        int[] a = new int[]{2, 2, 3, 1, 5, 6, 2, 3, 4, 8, 0, 0, 7};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
