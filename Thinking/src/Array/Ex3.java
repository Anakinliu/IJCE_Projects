package Array;

import java.util.Arrays;
import java.util.Random;

/**
 * Author: Anakinliu
 * Date: 2018/03/07
 * Time: 16:02
 * You may be disappointed if you fail,
 * but you are doomed if you don't try.
 */
public class Ex3 {
    protected final static Random rand = new Random(23);
    protected double[][] getDouble2DArray(int s1, int s2, double s, double e) {
        if (s1 < 1 || s2 < 1) {
            throw new IllegalArgumentException();
        }
        double[][] a = new double[s1][];
        for (int i = 0; i < a.length; i++) {
            a[i] = new double[s2];
            for (int j = 0; j < a[i].length; j++) {
                // 值在数值l和r之间
                a[i][j] = Math.min(s, e) + rand.nextDouble() * Math.abs(s - e);
            }
        }
        return a;
    }

    public void print(Object[] a) {
        System.out.println(Arrays.deepToString(a));
    }

    public static void main(String[] args) {
        Ex3 ex3 = new Ex3();
        ex3.print(ex3.getDouble2DArray(2, 4, 1.2, 2.2));
    }
}
