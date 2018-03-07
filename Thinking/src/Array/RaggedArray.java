package Array;

import polymorphismANDinterface.RandomWords;

import java.util.Arrays;
import java.util.Random;

/**
 * Author: Anakinliu
 * Date: 2018/03/07
 * Time: 14:37
 * You may be disappointed if you fail,
 * but you are doomed if you don't try.
 * 数组矩阵中的每个向量可以有任意长度( 0无意义 ) 这被称为粗糙数组
 */

public class RaggedArray {
    public static void main(String[] args) {
        Random rand = new Random(23);

        //3-D array
        int[][][] a = new int[rand.nextInt(7)][][];
        for (int i = 0; i < a.length; i++) {
            a[i] = new int[rand.nextInt(5)][];
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = new int[rand.nextInt(5)];
                for (int k = 0; k < a[i][j].length; k++) {
                    a[i][j][k] = 8;
                }
            }
        }
        System.out.println(Arrays.deepToString(a));
    }
}
