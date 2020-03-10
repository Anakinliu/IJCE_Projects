package kyu6;

import java.math.BigInteger;
import java.util.Arrays;

/*
    AUTHOR: linux
    TIME: 2020/3/10
    GOOD LUCK AND NO BUG.
*/
/*
化简shi一个分式

返回"[N, D]" in Java
若是整数，返回"n" Java
输入为空，返回null
 */
public class Irreducible_Sum_of_Rationals {

    public static int gcd(int x, int y) {
        int a = Math.max(x, y);
        int b = Math.min(x, y);
        int c = 0;
        while (a % b != 0) {
            c = b;
            b = a % b;
            a = c;
        }
        return b;
    }

    public static String sumFracts(int[][] l) {
        // your code
        if (l == null) {
            return null;
        }
        int lenL = l.length;
        int fm = 1;
        System.out.println(Arrays.deepToString(l));
        for (int i = 0; i < lenL; i++) {
            fm = fm * l[i][1];
        }
        int fz = 0;
        for (int i = 0; i < lenL; i++) {
            fz += fm / l[i][1] * l[i][0];
        }
        System.out.println(fz);
        System.out.println(fm);

        int gcd = gcd(fz, fm);
        System.out.println(gcd);
        fz = fz / gcd;
        fm = fm / gcd;
        if (fm == 1) {
            return Integer.toString(fz);
        } else {
            return "[" + fz + ", " + fm + "]";
        }
    }

    // API大佬解答，思路适合我一样的
    public static String sumFracts2(int[][] l) {
        if (l.length == 0) return null;

        final int D = Arrays.stream(l).mapToInt(ar -> ar[1]).reduce(1, (a, b) -> a * b);  // 分母
        final int N = Arrays.stream(l).mapToInt(ar -> ar[0] * D / ar[1]).sum();  // 分子

        int gcd = BigInteger.valueOf(D).gcd(BigInteger.valueOf(N)).intValue();
        return (D == gcd) ? String.valueOf(N / D) : String.format("[%d, %d]", N / gcd, D / gcd);
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{{1, 2}, {2, 9}, {3, 18}, {4, 24}, {6, 48}};
        a = new int[][]{{2, 6}, {2, 4}, {4, 6}};
        String r = "[85, 72]";
        System.out.println(sumFracts(a));
//        System.out.println(gcd(18, 6));
    }
}
