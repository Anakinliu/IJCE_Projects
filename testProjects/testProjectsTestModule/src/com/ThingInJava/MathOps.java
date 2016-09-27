package com.ThingInJava;

import java.util.Random;

/**
 * Created by liu_y.
 * On 2016/9/25.
 */
public class MathOps {
    public static void main(String[] args) {
        //create a seeded random number generator
        Random rand = new Random();
        int i,j,k;
        //Choose value from 1 to 100
        j = rand.nextInt(100) + 1;
        System.out.println("j = " + j);
        k = rand.nextInt(100) + 1;
        System.out.println("k = " + k);
        i = j + k;
        System.out.println("i = " + i);

    }
}
