package com.ThingInJava;

/**
 * Created by liu_y.
 * On 2016/10/5.
 */

class Person {
    public void eat(Apple apple) {
        Apple peeled = apple.getPelled();
        System.out.println("Yummy");//yummy  好吃的
    }
}

class Peller {
    //削皮吃。。。
    static Apple peel (Apple apple) {
        //...... remove peel
        System.out.println("remove peel");
        return apple;//peeled
    }
}

class Apple {
    Apple getPelled() {
        return Peller.peel(this);
    }
}
public class TestThis {
    public static void main(String[] args) {
        new Person().eat(new Apple());
    }
}
