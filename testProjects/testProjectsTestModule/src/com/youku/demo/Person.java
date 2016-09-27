package com.youku.demo;

/**
 * Created by liu_y.
 * On 2016/8/11.
 */
public class Person {
    int age;
    int id;
    Person(int a,int i){
        age=a;
        id=i;
    }
    public void showPerson(){
        System.out.println("age=" + age);
        System.out.println("id=" + id);

    }
    public static void main(String[] args) {
        Person p1 = new Person(19,11);

        p1.showPerson();
    }


}
