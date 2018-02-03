package AnalysisOfAlgorithm;

import edu.princeton.cs.algs4.Out;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by Anakinliu on 17.10.24.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
public final class GenerateNumberTxt {

    private static Out out =
            new Out("F:\\IJCE\\CourseraAlgorithm\\src\\AnalysisOfAlgorithm\\in.txt");

    /*
    write int from [0 ~ basicNumber] in counts times
    if number is int, short, long, byte, then generate some int
    if number is float or double, then generate some x.xx
     */
    public static void generateAllNumber(int counts, Number number) {
        if (counts <= 0) {
            return;
        }

        for (int i = 1; i <= counts; i++) {
            if (i % 2 == 0) {
                out.printf("%d ", StdRandom.uniform(100) * -1);
                continue;
            }
            out.printf("%d ", StdRandom.uniform(100));

        }
    }

    private GenerateNumberTxt() {
    }

    public static void main(String[] args) {
        generateAllNumber(4000, 100L);
    }
}
