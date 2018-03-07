package ClassDetails;

import Generics.GenericMethods;

import java.util.Arrays;

/**
 * Created by Anakinliu on 2017/4/23.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
public class ShowAll {
    /*
    打印出参数类的继承体系中的所有类
     */

    public static void recursive(Object o) {
        if (o.getClass().getSimpleName().equals("Object")) {
            System.out.println("I'm Object, Game Over!");
            return;
        }
        Object[] fileds = o.getClass().getDeclaredFields();
        if (fileds.length == 0) {
            System.out.println("no fields");
        }
        if (fileds.length > 0) {
            System.out.println(Arrays.toString(o.getClass().getDeclaredFields()));
        }
        try {
            System.out.println(o.getClass().getSimpleName());
            recursive(o.getClass().getSuperclass().newInstance());
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        recursive(new GenericMethods());
    }
}
