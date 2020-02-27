package kyu6;

import java.util.Arrays;

/*
    AUTHOR: linux
    TIME: 2020/2/27
    GOOD LUCK AND NO BUG.
*/
/*
输入一个数组，返回依次去掉第一个元素的和
输入：ls = [0, 1, 3, 6, 10]

去掉第一个元素
ls = [0, 1, 3, 6, 10]
ls = [1, 3, 6, 10]
ls = [3, 6, 10]
ls = [6, 10]
ls = [10]
ls = []

输出
[20, 20, 19, 16, 10, 0]
*/
public class Sums_of_Parts {

    public static int[] sumParts(int[] ls) {
        // your code
        int len = ls.length;
        int[] result = new int[len + 1];
        int sum = 0;
        for (int e : ls) {
            sum += e;
        }
        result[0] = sum;
        for (int i = 1; i <= len; i++) {
            result[i] = result[i-1] - ls[i - 1];
        }
        return result;
    }

    // 大神的一个解，思路很好，从后往前数。
    public static int[] sumParts2(int[] ls) {
        int[] result = new int[ls.length+1];
        for(int i = ls.length-1; i >= 0; --i) {
            result[i] = result[i+1] + ls[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] test = new int[]{744125, 935, 407, 454, 430, 90, 144, 6710213, 889, 810, 2579358};
        System.out.println(Arrays.toString(sumParts(test)));
        System.out.println(Arrays.toString(sumParts2(test)));
    }
}
