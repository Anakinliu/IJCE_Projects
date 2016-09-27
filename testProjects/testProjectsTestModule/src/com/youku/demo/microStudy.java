package com.youku.demo;

/**
 * Created by liu_y.
 * On 2016/8/7.
 */
public class microStudy {
    private double isMax(double a,double b){
        if (a>b)
            return a;
        else
            return b;
    }
    public static void main(String[] args) {
        int z=10;
        System.out.println(++z);

        System.out.println(0b10_010);
        double x;
        x = new microStudy().isMax(10,100);
        System.out.println(x);

        int i,j;
        for (i=1;i<=9;i++){
            for (j=1;j<=9;j++)
                if (j<i) {
                    System.out.print("       ");

                }
                else{
                    System.out.printf("%d*%d=%2d ",i,j,i*j);
                }
            System.out.println("");
        }
    }
}
