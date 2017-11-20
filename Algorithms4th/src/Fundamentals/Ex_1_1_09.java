package Fundamentals;

/**
 * Created by Anakinliu on 17.10.28.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
public class Ex_1_1_09 {
    private static String toBinary(int N) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int n = N ; n > 0; n /= 2) {
                stringBuilder.append(n % 2);
        }

        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(toBinary(128));
    }
}
