package com.zzxy.demo;

/**
 * Created by liu_y.
 * On 2016/8/26.
 */
public class Error {
    public static void main(String[] args) {
        try{
        System.out.println(2 / 0);
        }
        catch (ArithmeticException ae){
            System.out.println("不能除0");
        }
    }
}
