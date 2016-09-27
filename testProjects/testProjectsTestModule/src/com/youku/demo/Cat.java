package com.youku.demo;

/**
 * Created by liu_y.
 * On 2016/8/12.
 */
public class Cat {
    public static int id;
    public String catName;
    int realId;
    int legs;
    public Cat(String catName){
        realId = ++id;
        this.catName = catName;
    }

    public void getInfo(){

        System.out.println("Cat Name :" + catName + "Id : "+ realId);
    }


    public static void main(String[] args) {

        Cat.id = 10;

        Cat wang = new Cat("wang cai");
        wang.id = 100000;
        Cat miao = new Cat("miao");

        miao.catName = "xxxx";

        wang.getInfo();
        miao.getInfo();

    }
}
