package com.ThingInJava;

/**
 * Created by liu_y.
 * On 2016/10/23.
 */
public class A {
    A () {
        System.out.println("A constructor");
    }
    public static void main(String[] args) {
        C c = new C();
    }
}
class B {
    B () {
        System.out.println("B constructor");
    }
}
class C extends A{
    B b = new B();

}
