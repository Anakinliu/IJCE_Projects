package DSAA;

import Generics.GenericMethods;

/**
 * Created by Anakinliu on 2017/4/22.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
public class test {
    private static GenericMethods gm  ;
    static {
        System.out.println("before");
        gm = new GenericMethods();
        System.out.println("after");
    }
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        System.out.println("main");
        try {
            GenericMethods genericMethods = gm.getClass().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        /*
        虚拟构造器
         */
        System.out.println("---");

        try {
            Shape shape = Rectangle.class.newInstance();
            System.out.println(shape.getClass().getSimpleName());
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
