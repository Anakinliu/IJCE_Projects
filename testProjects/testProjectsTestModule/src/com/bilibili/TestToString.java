package com.bilibili;

/**
 * Created by liu_y.
 * On 2016/9/11.
 */
public class TestToString {

    public String toString() {
        return "age = " + age;
    }
    int age;
    public void setAge(int age) {
        this.age = age;
    }
    public static void main(String[] args) {
        TestToString t = new TestToString();
        t.setAge(10);

        System.out.println(t.toString());
    }
}
