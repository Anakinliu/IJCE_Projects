package main;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Anakinliu
 * Date: 2018/03/19
 * Time: 19:13
 * You may be disappointed if you fail,
 * but you are doomed if you don't try.
 */

/**
 * Fizz Buzz 问题
 * 给你一个整数n. 从 1 到 n 按照下面的规则打印每个数：

 如果这个数被3整除，打印fizz.
 如果这个数被5整除，打印buzz.
 如果这个数能同时被3和5整除，打印fizz buzz.

 样例
 比如 n = 15, 返回一个字符串数组：
 [
 "1", "2", "fizz",
 "4", "buzz", "fizz",
 "7", "8", "fizz",
 "buzz", "11", "fizz",
 "13", "14", "fizz buzz"
 ]
 */
public class Quiz9 {
    /**
     * @param n: An integer
     * @return: A list of strings.
     */
    public static List<String> fizzBuzz(int n) {
        // write your code here
        List<String> list = new ArrayList<>();
        int i = 1;
        for (;i <= n; i++) {
            if (i % 15 == 0) {
                list.add("fizz buzz");
                continue;
            }
            if (i % 3 == 0) {
                list.add("fizz");
            } else if (i % 5 == 0) {
                list.add("buzz");
            } else {
                list.add(Integer.toString(i));
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(fizzBuzz(100).toString());
    }
}
