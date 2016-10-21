package com.Works;

/**
 * Created by liu_y.
 * On 2016/10/9.
 */

/**
 * 定义一个Person类，含:姓名、性别、年龄等字段；
 * 继承Person类设计Teacher类，增加：职称、部门等字段；
 * 继承Person类设计Student类，增加：学号、入学时间、专业等字段。
 * 定义各类的构造方法，并分别创建对象进行测试。
 */
public class Person {
    protected String name;
    protected String sex;
    protected int age;

    public Person(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }
    public String toString() {
        return "Person";
    }

    public void show(Person p) {
        System.out.println(p.toString());
        System.out.println("name: " + p.getName());
        System.out.println("sex: " + p.getSex());
        System.out.println("age: " + p.getAge());
    }
}
class Teacher extends Person {
    private String post;
    private String department;

    public Teacher(String name, String sex, int age, String post, String department) {
        super(name, sex, age);
        this.post = post;
        this.department = department;
    }

    public String getPost() {
        return post;
    }

    public String getDepartment() {
        return department;
    }
    public String toString() {
        return "Teacher";
    }

    public void show(Teacher p) {
        System.out.println(p.toString());
        System.out.println("name: " + p.getName());
        System.out.println("sex: " + p.getSex());
        System.out.println("age: " + p.getAge());
        System.out.println("post: " + p.getPost());
        System.out.println("department: " + p.getDepartment());
    }

}
class Student extends Person {
    private int number;
    private String admissionTime;
    private String major;

    public Student(String name, String sex, int age, int number, String admissionTime, String major) {
        super(name, sex, age);
        this.number = number;
        this.admissionTime = admissionTime;
        this.major = major;
    }

    public int getNumber() {
        return number;
    }

    public String getAdmissionTime() {
        return admissionTime;
    }

    public String getMajor() {
        return major;
    }
    public String toString() {
        return "Student";
    }

    public  void show(Student p) {
        System.out.println(p.toString());
        System.out.println("name: " + p.getName());
        System.out.println("sex: " + p.getSex());
        System.out.println("age: " + p.getAge());
        System.out.println("number: " + p.getNumber());
        System.out.println("admission tome: " + p.getAdmissionTime());
        System.out.println("major: " + p.getMajor());
    }
}
class TestIt {

    public static void main(String[] args) {
        Person p = new Person("person 1","man or woman",100);
        Teacher t = new Teacher("teacher 1","woman",22,"teacher","computer science");
        Student s = new Student("student 1","man",20,6,"2015.9.1","computer science");
        p.show(p);
        System.out.println("*-----------------------*");
        t.show(t);
        System.out.println("*-----------------------*");
        s.show(s);
    }
}