package com.youku.demo;

/**
 * Created by liu_y.
 * On 2016/8/11.
 */
public class ChongZai {
    void max(byte a, byte b){
        System.out.println(a > b ? a : b);
    }

    void max(int a, int b){
        System.out.println(a > b ? a : b);
    }

    public static void main(String[] args){
        ChongZai z = new ChongZai();

        z.max(3,4);
        //调用的是void max(int a, int b)

        byte a=3;
        byte b=4;
        z.max(a,b);
        //这里调用的则是void max(short a, short b)

        z.max(128,128);
        //


    }
}
