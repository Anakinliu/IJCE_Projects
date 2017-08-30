package Operators;

/**
 * Created by Anakinliu on 2017/3/22.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
public class test {
    public static void main(String[] args) {
        Integer s = new Integer(5);

        s = s << 16;
        System.out.println(s);

        System.out.println(8 >> 2);

        System.out.println("-8:       " + Integer.toBinaryString(-8) );

        System.out.println("-8 >>> 2: " + Integer.toBinaryString(-8 >>> 2));
    }
}
