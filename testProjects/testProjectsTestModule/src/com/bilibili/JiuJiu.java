package com.bilibili;

/**
 * Created by liu_y.
 * On 2016/9/14.
 */
public class JiuJiu {
    public static void main(String[] args) {
      //  System.out.println(String.format("%-6d",5));
        int i,j;
        for (i=1;i<=9;i++) {
            for (j = 1; j <= i; j++) {
                System.out.print(i + "*" + j + "=" + (i*j) + "\t");
            }
            System.out.println("");
        }
        System.out.println(" \tb\t");
    }
}
