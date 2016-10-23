package com.ThingInJava;

/**
 * Created by liu_y.
 * On 2016/10/21.
 */
public class ObjectArrays {
    public static void showArrays(String... x) {
        for (Object obj : x) {
            System.out.print(obj + " ");

        }
        System.out.println();
    }
    public static void showArrays(int... x) {
        for (int y : x) {
            System.out.print(y + " ");
        }
        System.out.println();
    }

    public static void main(String... args ) {
        Object[] x = new Object[]{new Integer(22), new String("liu"),new Double(9.9)};
        //showArrays(x);
        //showArrays(new ObjectArrays(),new ObjectArrays());//since jdk1.5
        //showArrays();
        for (String s : args) {
            System.out.println(s);
        }
        showArrays(1,2,4,5,7,8);
        showArrays("s","swe");
    }
}
