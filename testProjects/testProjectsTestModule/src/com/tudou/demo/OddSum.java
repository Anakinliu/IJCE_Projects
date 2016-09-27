package com.tudou.demo;

/**
 * Created by liu_y.
 * On 2016/8/9.
 */
public class OddSum {
    public static void main(String[] args) {
        long result = 0;
        for (int i=1; i<=99;i+=2){
            result +=i;
        }

        System.out.println(result);
    }
}
