package com.tudou.demo;

/**
 * Created by liu_y.
 * On 2016/8/9.
 */
public class TestBreak {
    public static void main(String[] args) {
        long result = 0;
        for (int i=0; i<=99;i+=10) {

            result += i;
            if (i == 30);
                break;
        }
        System.out.println(result);
    }
}
