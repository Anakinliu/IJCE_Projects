package Fundamentals;

/**
 * Created by Anakinliu on 17.11.20.
 * If you only do what you can do,
 * you'll never be more than you are now.
 *
 * TODO 1.1.14 编写一个静态方法lg()，接受一个整型参数N，返回不大于log2N 的最大整数。
 * TODO 不要使用Math 库。

 */
public class Ex_1_1_14 {
    public static int lg(int N) {
        int result = 0;
        while (N != 1) {
            N = N >> 1;
            result++;
        }
        return result;
    }

    public static int lgNormal(int N) {
        int i = 1;
        int result = 0;
        while (i <= N) {
            i *= 2;
            result++;
        }
        return --result;
    }

    public static void main(String[] args) {
        System.out.println(lg(128));
        System.out.println(lgNormal(10));
    }
}
