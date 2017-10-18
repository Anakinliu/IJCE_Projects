package ShiYanLou;

import java.lang.reflect.Constructor;

/**
 * Created by Anakinliu on 2017/9/3.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
public class DynamicClass {
    public static void main(String[] args) {
        try {
            Constructor<String> constructor =
                    String.class.getDeclaredConstructor(String.class);
            String s = constructor.newInstance("QAQ");
            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
