package Array;
import static java.lang.System.out;
/**
 * Author: Anakinliu
 * Date: 2018/03/07
 * Time: 14:12
 * You may be disappointed if you fail,
 * but you are doomed if you don't try.
 */
import java.util.*;

class A { public String toString() { return "A Object"; } }

public class Ex1 {
    // Method that takes E[] as argument
    // and prints the argument as array elements and as List or String:
    public static void test(E[] a) {
        System.out.print(Arrays.asList(a));
    }
    // Generic version:
    public static <T> void test(T[] t) {
        System.out.print(Arrays.asList(t));
    }
    // int version:
    public static void test(int[] ia) {
        System.out.print(Arrays.toString(ia));
    }

    public static void main(String[] args) {
        System.out.print("For objects, e.g., Es:");
        // Array is created and initialized (aggregate initialization)
        // but all elements are null, not Es:
        test(new E[3]);
        // Dynamic aggregate initialization works;
        // elements are now Es:
        test(new E[]{
                new E(), new E() });
        // Aggregate initialization this way works:
        E[] a = { new E(),
                new E(), new E() };
        test(a);
        // Elements initialized to null:
        E[] bsa = new E[2];
        test(bsa);
        bsa = a;
        test(bsa);
        System.out.print("-------------");
        System.out.print("For primitives, e.g., int:");
        // Dynamic aggregate initialization works:
        test(new int[]{ new Integer(0), new Integer(0) });
        // But may be considered redundant, since
        // aggregate initialization works:
        // elements initialized to zero (not null):
        test(new int[2]);
        // Ordinary aggregate initialization this way also works:
        int[] ia = { 1, 2, 3, };
        test(ia);
    }
}