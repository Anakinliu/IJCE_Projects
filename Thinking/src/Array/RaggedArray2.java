package Array;

import java.util.Arrays;

/**
 * Author: Anakinliu
 * Date: 2018/03/07
 * Time: 14:49
 * You may be disappointed if you fail,
 * but you are doomed if you don't try.
 */
public class RaggedArray2 {
    public static void main(String[] args) {
        E[][] es = new E[][]{
                {new E(), new E()},
                {new E()},
                {new E(), new E(), new E()}

        };

        // 自动包装
        Integer[][][] integers = {
                {{1, 2, 3}, {3, 4}},
                {{2, 3}},
                {{45, 657, 234}, {32, 4}, {234, 879}}
        };
        System.out.println(Arrays.deepToString(integers));

        System.out.println(Arrays.deepToString(es));
    }
}
