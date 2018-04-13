package Basic;

/**
 * Created by Anakinliu on 18.1.26.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
class Person{

}
class Emplouee extends Person {

}
class Student extends Person {

}
public class PSE {
    public static void main(String[] args) {
        Person[] a = new  Emplouee[2];
//        a[0] = new Emplouee();
        a[0] = new Student();
    }
}
