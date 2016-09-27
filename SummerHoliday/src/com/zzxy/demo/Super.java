package com.zzxy.demo;

/**
 * Created by liu_y.
 * On 2016/8/17.
 */
class FatherCalss{
    protected int value;
    public void f(){
        value = 100;
        System.out.println("FatherClass value = " + value);
    }
}

class ChildCalss extends  FatherCalss{
    protected int value;
    public void f(){
        super.f();
        value = 200;
        System.out.println("ChildClass value = " + value);
        System.out.println(super.value);
    }
}
public class Super {
    public static void main(String[] args) {
        ChildCalss cc = new ChildCalss();
        cc.f();
    }
}
