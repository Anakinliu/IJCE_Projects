package package1;

import java.util.function.Function;

/**
 * Created by Anakinliu on 2017/2/9.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
class Hey {
    public static double square (double num) {
        return Math.pow(num, 2);
    }
}



public class TestLamdba {
    static Function<Double, Double> square = Hey::square;
    static double answer = square.apply(7d);

    public static void main(String[] args) {
        System.out.println(answer);
    }
}
