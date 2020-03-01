package kyu6;

import java.math.BigInteger;

/*
    AUTHOR: linux
    TIME: 2020/3/1
    GOOD LUCK AND NO BUG.
*/
/*

Given
u0 = 1,
u1 = 2
and the relation
6(Un)(Un+1)-5(Un)(Un+2)+(Un+1)(Un+2) = 0
calculate un for any integer n >= 0.

 */
public class A_disguised_sequenceI {
    public static BigInteger fcn(int n) {
        // your code
        if (n == 0) {
            return BigInteger.ONE;
        }
        if (n == 1) {
            return BigInteger.valueOf(2);
        }
//        BigInteger s1 = BigInteger.valueOf(6).multiply(fcn(n - 2)).multiply(fcn(n - 1));
//        BigInteger s2 = BigInteger.valueOf(5).multiply(fcn(n - 2)).subtract(fcn(n - 1));

        return BigInteger.valueOf(6).multiply(fcn(n - 2)).multiply(fcn(n - 1)).divide(BigInteger.valueOf(5).multiply(fcn(n - 2)).subtract(fcn(n - 1)));
    }

    public static void main(String[] args) {
        System.out.println(fcn(21));
    }
}
