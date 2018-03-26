package Array;

import java.util.Arrays;

/**
 * Author: Anakinliu
 * Date: 2018/03/07
 * Time: 16:27
 * You may be disappointed if you fail,
 * but you are doomed if you don't try.
 */
public class Ex4 extends Ex3 {
    private double[][][] getDouble3DArray(
            int s1, int s2, int s3,
            double s, double e
    ) {
        if (s1 < 1 || s2 < 1 || s3 < 1) {
            throw new IllegalArgumentException();
        }
        double[][][] a = new double[s1][][];
        for (int i = 0; i < a.length; i++) {
            a[i] = new double[s2][];
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = new double[s3];
                for (int k = 0; k < a[i][j].length; k++) {
                    // 值在数值l和r之间
                    a[i][j][k] = Math.min(s, e) +
                            rand.nextDouble() *
                                    Math.abs(s - e);
                }
            }
        }

        return a;
    }

    public void print(Object[] a) {
        System.out.println(Arrays.deepToString(a));
    }

    public static void main(String[] args) {
        Ex4 ex4 = new Ex4();
        ex4.print(ex4.getDouble3DArray(2, 3, 4, 1, 2));
    }
}
