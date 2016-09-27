package com.tudou.demo;

/**
 * Created by liu_y.
 * On 2016/8/10.
 */
public class DiGui {
    public static int jie(int x){
        if (x==1)
            return 1;
        else
            return x*jie(x-1);
    }

    public static long fib(int n){
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return fib(n-1) + fib(n-2);
        }
    }
    public static void main(String[] args) {

        System.out.println(jie(5));

        int n=-40;
        long f=0L;
        long j=1L;
        long k=1L;
        if (n == 1 || n == 2)
            f=1;
        else if (n>=2) {
            for (int i = 3; i <= n; i++) {

                f = j + k;
                j = k;
                k = f;

            }
        }
        else
            System.out.println("no normal number");
        System.out.println(fib(40));
        System.out.println(f);
    }
}
