package ClassDetails;

import java.util.Arrays;

/**
 * Created by Anakinliu on 2017/7/18.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
public class Exercise8 {
    static void showClassFather(Object o) {
        if (o.getClass().getSuperclass()!=null) {
            System.out.println(o.getClass() + "is a subclass of "
                    + o.getClass().getSuperclass());
            Object[] fileds = o.getClass().getDeclaredFields();
            for (Object f : fileds) {
                System.out.println(f + " ");
            }

            try {
                showClassFather(o.getClass().getSuperclass().newInstance());
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        showClassFather(new Triangle());
    }
}
