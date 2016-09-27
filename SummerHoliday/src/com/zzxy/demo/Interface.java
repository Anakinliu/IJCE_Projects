package com.zzxy.demo;

/**
 * Created by liu_y.
 * On 2016/8/24.
 */
interface Painter{
    void painting();
    void name(double n);

}

interface Singer{
    void singering();
    void name(int n);
}

interface Arter extends Painter{
    //接口继承接口

}
class Stu implements Painter,Singer{

    public void name(double n){

    }
    public void name(int n){

    }
    @Override
    public void painting() {
        System.out.println("the stu can paint");
    }

    @Override
    public void singering() {
        System.out.println("the stu can sing");
    }
}

public class Interface {
    public static void main(String[] args) {

    }
}
