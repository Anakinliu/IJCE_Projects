package com.Works;

/**
 * Created by liu_y.
 * On 2016/10/20.
 */
class StudentX {
    private String name;
    private int age;

    public StudentX(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int hashCode() {

        return 31 * age + (name == null ? 0: name.hashCode());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }

        else if (((StudentX)obj).getName().equals(this.getName()) && ((StudentX)obj).getAge() == this.getAge()) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Student"  + "\nname:" + name + "\nage" + age +"\n";
    }
}
public class TestObjects {
    public static void main(String[] args) {

        StudentX s1 = new StudentX("m",6);
        StudentX s2 = new StudentX("l",6);
        System.out.println("s1: " + s1);
        System.out.println("s2: " + s2);
        System.out.println("s1.equals(s1): " + s1.equals(s1));
        System.out.println("s2.equals(s2): " + s2.equals(s2));
        System.out.println("s1.equals(s2): " + s1.equals(s2));
        System.out.println("s2.equals(s1): " + s2.equals(s1));


    }
}
