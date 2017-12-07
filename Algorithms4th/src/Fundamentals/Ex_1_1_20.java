package Fundamentals;

/**
 * Created by Anakinliu on 17.11.29.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
/*
编写一个递归的静态方法计算ln(N!) 的值。
logM * N = logM + logN
 */
public class Ex_1_1_20 {
    public static double ln(double N) {
        if (N == 1) {
            return 0;
        }
        return Math.log(N) + Math.log(N - 1);
    }
    public static void main(String[] args) {
        System.out.println(ln(9));
    }
}
