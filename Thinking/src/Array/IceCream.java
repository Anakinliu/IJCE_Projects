package Array;

import java.util.Arrays;
import java.util.Random;

/**
 * Author: Anakinliu
 * Date: 2018/03/07
 * Time: 14:26
 * You may be disappointed if you fail,
 * but you are doomed if you don't try.
 */
public class IceCream {
    private static Random rand = new Random(23);
    static final String[] FLAVORS = {
            "Chop", "Straw", "Rum", "Praline",
            "Mocha", "Kala", "Mint"
    };

    public static String[] flavorSet(int n) {
        if (n > FLAVORS.length) {
            throw new IllegalArgumentException("Set too big!");
        }
        String[] results = new String[n];
        boolean[] picked = new boolean[FLAVORS.length];  // 确保"味道"不会被重复选择
        for (int i = 0; i < n; i++) {
            int t;
            do {
                t = rand.nextInt(FLAVORS.length);
            } while (picked[t]);
            results[i] = FLAVORS[t];
            picked[t] = true;
        }
        return results;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 9; i++) {
            System.out.println(Arrays.toString(flavorSet(7)));
        }
    }
}
