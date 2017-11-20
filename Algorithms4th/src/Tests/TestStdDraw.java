package Tests;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

/**
 * Created by Anakinliu on 17.10.24.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
public class TestStdDraw {
    public static void main(String[] args) {
        int N = 100;
        double[] randomNum =
                new double[N];
        for (int i = 0; i < N; i++)
            randomNum[i] = StdRandom.uniform();
        Arrays.sort(randomNum);
        for (int i = 0; i < N; i++) {
            double x = 1.0 * i / N;
            double y = randomNum[i] / 2.0;
            double rw = 0.2 / N;
            double rh = randomNum[i] / 2.0;
            StdDraw.filledRectangle(x, y, rw, rh);
        }
    }
}
