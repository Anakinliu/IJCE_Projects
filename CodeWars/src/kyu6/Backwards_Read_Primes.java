package kyu6;

import java.util.stream.Collectors;
import java.util.stream.LongStream;

/*
    AUTHOR: linux
    TIME: 2020/2/20
    GOOD LUCK AND NO BUG.
*/
/*
正反都是素数的元素, 3，5，7不是，因为正反是同一个数
backwardsPrime(2, 100) => "13 17 31 37 71 73 79 97"
backwardsPrime(9900, 10000) => "9923 9931 9941 9967"
 */
public class Backwards_Read_Primes {

    private static long reverseLong(long x) {
        String xStr = Long.toString(x);
        int xStrLen = xStr.length();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0; i < xStrLen; i++) {
            stringBuilder.append(xStr.subSequence(xStrLen-1-i, xStrLen-i));
        }
        return new Long(stringBuilder.toString());
    }

    private static boolean isPrime(long x) {
        long sqrtX = (long)Math.sqrt(x);
        for (long i = 2; i <= sqrtX; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static String backwardsPrime(long start, long end) {
        if (start < 0 || end <= 0) {
            return "";
        }
        // 包括start和end
        StringBuilder stringBuilder = new StringBuilder();
        for (; start <= end; start += 1) {
            if (start != reverseLong(start)
                    && isPrime(start)
                    && isPrime(reverseLong(start))
            ) {
                stringBuilder.append(start);
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString().trim();
    }

    // 答案之一  管道大神
    public static String backwardsPrime2(long start, long end) {
        return LongStream.range(start, end + 1).parallel()
                .filter(x -> !isPalidrome(x))
                .filter(x -> isPrime2(x))
                .filter(x -> isPrime2(backwards(x)))
                .boxed().map(String::valueOf).collect(Collectors.joining(" "));
    }

    private static boolean isPrime2(long number) {
        if (number % 2 == 0) return false;
        for (long i = 2; i < number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static long backwards(long number) {
        return Long.parseLong(new StringBuffer(String.valueOf(number)).reverse().toString());
    }

    private static boolean isPalidrome(long number) {
        return number == backwards(number);
    }



    public static void main(String[] args) {
//        System.out.println(isPrime(9));
        System.out.println(backwardsPrime(2, 100));
//        System.out.println(reverseLong(12345));
    }
}
