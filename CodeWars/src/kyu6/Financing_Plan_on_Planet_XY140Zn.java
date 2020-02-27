package kyu6;

import java.math.BigInteger;

/*
    AUTHOR: linux
    TIME: 2020/2/26
    GOOD LUCK AND NO BUG.
*/
/*
0 3 9 18 30
0 1+1*2 2+2*2+3 3+3*2
 */
public class Financing_Plan_on_Planet_XY140Zn {

    public static BigInteger finance(int n) {
        // your code
        if (n == 0) {
            return BigInteger.ZERO;
        }

        BigInteger sum = new BigInteger("0");

//        for (int i = n ; i <= 2 * n; i++) {
//            sum = sum.add(new BigInteger(Integer.toString(i)));
//        }

        for (int i = 1; i <= n; i++) {
            int single = i * 3;
            int test = 0;
            if (i % 2 == 0) {
                // valueOf方法接收long，自然可以接收int
                sum = sum.add(
                        BigInteger.valueOf(single * (i / 2) + i + (i / 2))
                );
            } else {
                System.out.println(test);
                sum = sum.add(
                        BigInteger.valueOf(single * (int) Math.ceil(i / 2.0))
                );
            }
        }
//        return sum.add(finance(n-1));
        return sum;
    }



    public static void main(String[] args) {
        System.out.println(finance(6));
//        finance(6);
    }
}
