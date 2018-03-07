package AnalysisOfAlgorithm;

import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by Anakinliu on 18.2.5.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */

/**
 * 时间与平台相关
 */
public class AddOpTime {
    private static void add1M() {
        int result;
        for (int i=0; i<1000000; i++) {
            result = 33 + 66;  // 3ns/次常数级
        }
    }

    private static void multiply1M() {
        int result;
        for (int i=0; i<1000000; i++) {
            result = 333 * 666;  // 常数级2ns/次
        }
    }

    private static void variableDeclaration() {
        for (int i=0; i<1000000; i++) {
            int x = 0;  // 常数级2ns/次
        }
    }

    private static void concatenation() {
        String z = "";
        for (int i=0; i<1000; i++) {
            z += "z";  //随N呈线性增长2000ns/次
        }
    }

    public static void main(String[] args) {
        Long startTime = System.nanoTime();
        variableDeclaration();
        Long endTime = System.nanoTime();
        System.out.println("one time nanotime: " + (endTime - startTime)/1000000.0);
    }
}
