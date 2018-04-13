package HelloWorld;

/**
 * Created by Anakinliu on 18.1.3.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
public class OctalLiterals {
    public static void main(String[] args) {
        int x = 010;
        System.out.println("oct: " + x);
        int x2 = 0x10;
        System.out.println("hex: " + x2);
        int x3 = 0b10;
        System.out.println("bin: " + x3);
        int x4 = 1_1_1_1_0;
        System.out.println("Underscores is available: " + x4);
    }
}
