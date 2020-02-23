package kyu7;

import java.util.Arrays;
import java.util.LinkedList;

/*
    AUTHOR: linux
    TIME: 2020/2/22
    GOOD LUCK AND NO BUG.
*/
/*
钟摆数组

数组个数大于等于3
若数组个数为偶数，最小元素应移至（n-1）/ 2索引（考虑到索引从0开始）
数组/列表中的数字可能会重复，因此（安排时包含重复项），不要删除他们。


pendulum ([6, 6, 8 ,5 ,10]) ==> [10, 6, 5, 6, 8]

5, 6, 6, 8, 10 ==> [10, 6, 5, 6, 8]

6, 6, 5, 8, 10



pendulum ([-9, -2, -10, -6]) ==> [-6, -10, -9, -2]

 */
public class The_Poet_And_The_Pendulum {

    public static int[] pendulum(final int[] values) {
        // 可以对final的values进行排序！！！！只是不能使values指向别的对象。
        Arrays.sort(values);
//        System.out.println(Arrays.toString(values));
        int myLength = values.length;
        int[] result = new int[myLength];
        int index = (myLength + 1) / 2 - 1;
        //System.out.println(index);
        int step = 0;
        for (int i = 0; i < myLength; i++) {
            if (i % 2 == 1) {
                step = i;
            }
            else {
                step = -i;
            }

//            if (index + step >= myLength
//                    || index + step < 0) {
//                System.out.println("break index");
//                continue;
//            }
            index = index + step;
            result[index] = values[i];
//            System.out.println(index);
//            System.out.println(step);
//            System.out.println(i);
//            System.out.println(Arrays.toString(result));
//            System.out.println("---");
        }

        return result; // Do your magic!
    }

    // 答案之一，使用了双向链表
    public static int[] pendulum2(final int[] values) {
        int[] arr1 = values;
        Arrays.sort(arr1);
        LinkedList<Integer> result = new LinkedList<>();
        for (int i = 0; i < arr1.length; i++) {
            if (i%2==0)
                result.addFirst(arr1[i]);
            else
                result.addLast(arr1[i]);
        }
        return  Arrays.stream(result.toArray()).mapToInt(x ->  (int)x).toArray();
    }

    public static void main(String[] args) {
        final int[] test = new int[]{6, 6, 8 ,5 ,10};
        test[0] = 99;

//        System.out.println(Arrays.toString(test));
//        System.out.println();
//        System.out.println(Arrays.toString(pendulum(test)));
//        System.out.println();
//        System.out.println(Arrays.toString(test));

        System.out.println(Arrays.toString(test));
        System.out.println();
        System.out.println(Arrays.toString(pendulum2(test)));
        System.out.println();
        System.out.println(Arrays.toString(test));

    }
}
