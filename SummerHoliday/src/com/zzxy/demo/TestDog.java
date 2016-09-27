package com.zzxy.demo;

/**
 * Created by liu_y.
 * On 2016/8/18.
 */
class Dog{
    private String name;
    private int age;
    Dog(String name,int age){
        this.name = name;
        this.age = age;
    }
    public String info(){
        return "name: " + name + "\nage: " + age;
    }
}

class HaBa extends Dog{
    private int height;
    HaBa(String n, int a ,int height){
        super(n,a);
        this.height = height;
    }
    HaBa(String n){
        this(n,10,40);
        // 使用  this(参数)  调用本类之外的构造方法
    }
    public String info(){
        return super.info() + "\nheifht: " + height + "cm";
    }
}



public class TestDog {
    public static void main(String[] args) {
        HaBa h = new HaBa("ww",5,50);

        HaBa z = new HaBa("zz");

        System.out.println(h.info());

        System.out.println(z.info());
    }
}
