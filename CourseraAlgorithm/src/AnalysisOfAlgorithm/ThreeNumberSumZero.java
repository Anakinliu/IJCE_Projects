package AnalysisOfAlgorithm;


import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by Anakinliu on 18.2.3.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
public class ThreeNumberSumZero {
    public static double jieC(int n) {
        if (n <= 1) {
            return 1;
        }
        return jieC(n - 1) * n;
    }
    public static double zuHeShu(int N, int R) {
        return jieC(N) / (jieC(N - R) * jieC(R));
    }
    /***
     *
     * @param a 大的整数数组
     * @return 数组中任意三个整数和为0的计数
     */
    private static int find(int a[]) {
        int N = a.length;
        System.out.println("length: " + N);
        int count = 0;
        for (int i=1; i<N; i++) {
            for (int k=i+1; k<N; k++) {
                for (int j=k+1; j<N; j++) {
                    if (a[i] + a[j] + a[k] == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
//        System.out.println(jieC(4000));
        int a[] = new In("F:\\IJCE\\CourseraAlgorithm\\src\\AnalysisOfAlgorithm\\in.txt").
                readAllInts();
        Stopwatch time = new Stopwatch();
        System.out.println(find(a));
        System.out.println(time.elapsedTime());
    }
}
