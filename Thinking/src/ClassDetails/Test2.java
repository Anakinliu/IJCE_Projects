package ClassDetails;

import java.util.EnumSet;

/**
 * Created by Anakinliu on 2017/7/18.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
public class Test2 {
    public Test2() {
    }
    public Test2(int a, String b) {
    }
    public Test2(String b, int a) {
    }
    static void test(String name) {
        switch (name) {
            case "liu": break;
            case "yin":
            default:
                System.out.println("Nothing...");
        }
    }
    public static void main(String[] args) {
        int[] a = {1+2, 3+4};
        System.out.println(a[1]);
        Class<?> c = int.class;
        System.out.println(c.getCanonicalName());
        c = Double.TYPE;
        System.out.println(c.getCanonicalName());
        Class b = Boolean.TYPE;
        System.out.println(b.getCanonicalName());
        System.out.println(b.getName()  );
        Boolean.valueOf(true);
        test("sss");
    }
}
