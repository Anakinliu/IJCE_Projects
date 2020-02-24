package kyu8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
    AUTHOR: linux
    TIME: 2020/2/24
    GOOD LUCK AND NO BUG.
*/
/*
给3个正整数a,b,c，1到10，包括1，10，
计算在所有在不同位置插入*，+和（）情况的最大值，
一个操作符可多次使用，3个操作符不必要全用
a,b,c值可能相等
a,b,c顺序不可动

1 * (2 + 3) = 5
1 * 2 * 3 = 6
1 + 2 * 3 = 7
(1 + 2) * 3 = 9

最大值 9


 */
public class Expressions_Matter {

    public static int expressionsMatter(int a, int b, int c)
    {
        // Your Code here... Happy Coding!
        List<Integer> results = new ArrayList<>();
        results.add(a + b + c);
        results.add(a + (b * c));
        results.add(a * (b + c));
        results.add(a * b * c);
        results.add(a * b + c);
        Collections.sort(results);
        Collections.reverse(results);
        return results.get(0);

    }

    public static void main(String[] args) {

    }
}
