package com.tudou.demo;

import java.io.PrintStream;

/**
 * Created by liu_y.
 * On 2016/8/6.
 */
public class OtherMean {
    protected String name="liu";
    private static String name1="mmm";
    public double salary=10;



    private static int numINstance=0;

    protected static int getCount(){
        return numINstance;
    }

    public void addSalary(){
        salary=salary*99;
    }

    private static void addInstance(){
        numINstance++;

    }

    public OtherMean(){
        OtherMean.addInstance();

    }




    public static void main(String[] arguments) {


        System.out.println(OtherMean.getCount());

        for (int i=0;i<500;++i){
            new OtherMean();
        }

        System.out.println(OtherMean.getCount());


        OtherMean oneMean = new OtherMean();
        System.out.println(oneMean.name);
        oneMean.addSalary();
        System.out.println(oneMean.salary);//对于实例变量，没创建一个实例，就会为实例变量分配一次内存，实例变量可以在内存中有多个拷贝，互不影响（灵活）。

        OtherMean twoMean = new OtherMean();
        System.out.println(twoMean.salary);//对于实例变量，没创建一个实例，就会为实例变量分配一次内存，实例变量可以在内存中有多个拷贝，互不影响（灵活）。



        System.out.println(name1);


        System.out.println(OtherMean.getCount());

        System.out.println(OtherMean.getCount());

        oneMean.finalCanShu(OtherMean.i);

        //new OtherMean().finalCanShu(OtherMean.i);

        System.out.println(OtherMean.getCount());


    }
    final static int i=128;
    public void finalCanShu(final int i){
        System.out.println(i);;
    }
}
