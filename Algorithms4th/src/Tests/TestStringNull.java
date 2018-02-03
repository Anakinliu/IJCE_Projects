package Tests;

/**
 * Created by Anakinliu on 17.12.22.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
public class TestStringNull {
    public static void main(String[] args) {
        String x = "";
        String xx = null;
        System.out.println(x.equals(xx));
        System.out.println(x == xx);
        System.out.println(xx.equals(x));
        System.out.println(xx == x);
    }
}
