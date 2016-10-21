package com.ThingInJava;

/**
 * Created by liu_y.
 * On 2016/10/3.
 */
public class Fib {
    int m = 1;
    int n = 1;
    int c;
    public void fib(int length) {

        if (length==0) {
            return;
        }
        length--;
        System.out.print(m + " ");
        c=m+n;
        n=m;
        m=c;
        fib(length);
    }

    public static void main(String[] args) {
        int a = 10;
        Fib f = new Fib();
        f.fib(a);
    }
}
