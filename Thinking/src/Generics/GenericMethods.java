package Generics;

import java.util.LinkedList;

/**
 * Created by Anakinliu on 2017/4/22.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
public class GenericMethods<E> {
    private static int ioo = 0;

    public int x = 9;


    public GenericMethods () {

    }


    static {
        ioo++;
        System.out.println("before main Loading..." + ioo);
        try {
            Class.forName("Generics.GenericMethods");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static <E> E f(E t) {
        if (t.getClass().getSimpleName().equals("Object")) {
            System.out.println("Object in");
            return t;
        }

        // ??????????????
        if (t.getClass().getSuperclass().getSimpleName().equals("Number")) {
            System.out.println("???????:");
        } else {
            System.out.println("?????????:");
        }
        return t;
    }
    public static <A, B, C> void f3(A a, B b, C c) {
        System.out.println("=============");
        System.out.println(a.getClass().getSimpleName());
        System.out.println(b.getClass().getSimpleName());
        System.out.println(c.getClass().getSimpleName());
        System.out.println("=============");
    }

    public static void main(String[] args) {
        System.out.println("main start");

        System.out.println(f("s"));
        System.out.println(f(3));
        f3("sss", 11, 22.22F);
        LinkedList<String> linkedList = new LinkedList<>();
        //char[] chars = {2, 's', };

//        if (chars instanceof Object) {
//            System.out.println(chars.length + " ge" + new String(chars));
//        }
        //new GenericMethods(); //???static??????????
       // System.out.println("---");
       // System.out.println(new Integer(chars[0]));
    }
}
