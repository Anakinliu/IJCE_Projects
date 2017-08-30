package HoldingObjects;

/**
 * Created by Anakinliu on 2017/8/4.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
public class Test {
    public static void main(String[] args) {
        int a=10, b = 39;
        int c = a;
        a = b;
        b = c;
        //a = a ^ b;
        System.out.println(a + " " + b);
    }
}
