package Fundamentals;

/**
 * Created by Anakinliu on 17.10.28.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
public class EX_1_1_12 {
    public static void main(String[] args) {
        int[] a = new int[10];
        // 9-0
        for (int i = 0; i < 10; i++)
            a[i] = 9 - i;

        // 0-9
        for (int i = 0; i < 10; i++)
            a[i] = a[a[i]];

        for (int i = 0; i < 10; i++)
            System.out.println(i);

    }
}
