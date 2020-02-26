package kyu6;

import java.math.BigInteger;

/*
    AUTHOR: linux
    TIME: 2020/2/26
    GOOD LUCK AND NO BUG.
*/
public class Financing_Plan_on_Planet_XY140Zn {

    public static BigInteger finance(int n) {
        // your code
        if (n == 1) {
            return BigInteger.ZERO;
        }
        StringBuilder sb = new StringBuilder();
        while (n > 1) {
            for (int i = n - 1; i <= 2 * (n - 1); i++) {
                sb.append(i);
            }

            n--;
        }

        return new BigInteger(sb.toString());
    }

    public static void main(String[] args) {
        System.out.println(finance(7));
    }
}
