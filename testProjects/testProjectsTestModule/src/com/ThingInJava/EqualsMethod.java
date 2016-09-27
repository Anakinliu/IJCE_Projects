package com.ThingInJava;

/**
 * Created by liu_y.
 * On 2016/9/25.
 */
class Value {
    int i;
}
public class EqualsMethod {

    public static void main(String[] args) {
        Integer n1 = new Integer(47);
        Integer n2 = new Integer(47);
        Value v2 = new Value();
        Value v1 = new Value();
        v1.i = v2.i = 47;

        Value v3 = new Value();
//Constructs a newly allocated Integer object that represents the specified int value.
        //n1,n2都指向数字47，则n1.equals(n2)为true
        System.out.println("n1.equals(n2) : " + n1.equals(n2));
        System.out.println("n1 == n2 : " + (n1 == n2));
        System.out.println("n1 : " + n1);
        System.out.println("n2 : " + n2);

        //v1,v2指向了内存中的不同位置
        System.out.println("v1.equals(v2) : " + v1.equals(v2));

        v3 = v1;
        System.out.println("After     \"v3 = v1\"");
        System.out.println("v3.i = " + v3.i);
        System.out.println("v3.equals(v2) :" + v3.equals(v2));
        System.out.println("v3.equals(v1) :" + v3.equals(v1));

        v3.i = 99;
        System.out.println(v3);
        System.out.println(v1);
    }
}
