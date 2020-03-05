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

(Un+2) = 6(Un)(Un+1) / (5(Un) - (Un+1))
calculate un for any integer n >= 0.

 */
public class A_disguised_sequenceI {
//    public static ArrayList<BigInteger> se(int n) {
//        ArrayList<BigInteger> arrayList = new ArrayList<>();
//        arrayList.add(BigInteger.ONE);
//        arrayList.add(BigInteger.valueOf(2));
//        for (int i = 2; i <= n; i++) {
//
//        }
//        return arrayList;
//    }

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

        //(Un) = 6(Un-2)(Un-1) / (5(Un-2) - (Un-1))
        BigInteger[] bigIntegers = new BigInteger[n + 1];
        bigIntegers[0] = BigInteger.ONE;
        bigIntegers[1] = BigInteger.valueOf(2);
        for (int i = 2; i <= n; i++) {
            bigIntegers[i] = BigInteger.valueOf(6).multiply(bigIntegers[i - 2]).multiply(bigIntegers[i - 1])
                    .divide((bigIntegers[i - 2].multiply(BigInteger.valueOf(5)).subtract(bigIntegers[i - 1])));
        }
        return bigIntegers[n];
    }

    // 答案一  我太菜了，没看出来原来是2的n次方。。。
    public static BigInteger fcn2(int n) {
        return BigInteger.valueOf(2).pow(n);
    }

    // 答案二
    public static BigInteger fcn3(int n) {
        return BigInteger.ONE.shiftLeft(n);
    }

    public static void main(String[] args) {
        System.out.println(fcn(3));
    }
}
