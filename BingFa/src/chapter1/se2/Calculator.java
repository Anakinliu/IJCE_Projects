package chapter1.se2;

import com.sun.org.apache.xpath.internal.functions.FuncFalse;

public class Calculator implements Runnable{

    @Override
    public void run(){
        long current = 1L;
        long max = 20000L;
        long numPrimes = 0L;
        System.out.printf("In Thread %s's run(): START \n",
                Thread.currentThread().getName());
        while (current <= max) {
            if (isPrime(current)) {
                numPrimes ++;
            }
            current ++;
        }

        System.out.printf("Thread %s: END. Number of Primes: %d\n",
                Thread.currentThread().getName(), numPrimes);

    }

    public static boolean isPrime(long n) {
        if (n <= 2) {
            return false;
        }
        for (long i = 2; i < n; i++) {
            if ((n % i) == 0) {
                return false;
            }
        }
        return true;
    }


}
