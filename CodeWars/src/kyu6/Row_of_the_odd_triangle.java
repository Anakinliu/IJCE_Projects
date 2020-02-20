package kyu6;

import java.util.Arrays;

/*
    AUTHOR: linux
    TIME: 2020/2/19
    GOOD LUCK AND NO BUG.
*/
/*
             1
          3     5
       7     9    11
   13    15    17    19
21    23    25    27    29

odd_row(1)  ==  [1]
odd_row(2)  ==  [3, 5]
odd_row(3)  ==  [7, 9, 11]

注意！需要处理大的输入
 */
public class Row_of_the_odd_triangle {
    public static long[] oddRow(int n) {
        long n1 = (long)(n) * (long)(n - 1) + 1;
        long[] result = new long[n];
        for (int i = 0; i < n; i++) {
            result[i] = n1 + i * 2;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(oddRow(3)));
    }
}
