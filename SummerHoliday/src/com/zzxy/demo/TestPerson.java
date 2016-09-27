package com.zzxy.demo;

/**
 * Created by liu_y.
 * On 2016/8/15.
 */
class Person{
    private String name;
    private byte age;
    private int x;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }
}

class Student extends Person{
    private String school;

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getInfo(){
        return " Name: " + getName() + "\n Age: " + getAge() + "\n School: " + getSchool();
    }
}
public class TestPerson {

    public static void main(String[] args) {
        Student studentOne = new Student();

        studentOne.setAge((byte)19);
        studentOne.setName("l");
        studentOne.setSchool("zz");

        System.out.println(studentOne.getInfo());



    }
}
