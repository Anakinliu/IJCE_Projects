package com.tudou.demo;

import com.youku.demo.*;
/**
 * Created by liu_y.
 * On 2016/8/9.
 */
public class Boolean {
    public static void main(String[] args) {

        boolean a,b,c;
        int x=9;
        a=true;
        b=false;
        c=a^b;
        System.out.println(x);
        c=b&&(x>(x=x-8));//短路与

        System.out.println(c);
        System.out.println(x);

        System.out.println("sssssssssssssssssss");
    }
}
