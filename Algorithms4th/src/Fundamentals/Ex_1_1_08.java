package Fundamentals;

/**
 * Created by Anakinliu on 17.10.28.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
public class Ex_1_1_08 {
    public static void main(String[] args) {
        // char, byte, short 都会转型为int
        int x = 'b' + 'c';
        System.out.println('b' + 'c'); //197
        System.out.println(x); //197
        System.out.println("b" + 'c'); //bc
        System.out.println((char)('b' + 5));
        System.out.println((char)107);

    }
}
