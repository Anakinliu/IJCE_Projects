package HoldingObjects;

/**
 * Created by Anakinliu on 2017/8/5.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
import java.util.*;

import static print.Print.print;

public class Ex11 {
    public static void printAny(Collection c) {
        Iterator it = c.iterator();
        while(it.hasNext())
            print(it.next() + " ");
        System.out.println();
    }
    public static void main(String[] args) {
        ArrayList<Integer> al =
                new ArrayList<Integer>(Arrays.asList(1, 2, 3));
        LinkedList<Character> ll =
                new LinkedList<Character>(Arrays.asList('a', 'b', 'c'));
        HashSet<Float> hs =
                new HashSet<Float>(Arrays.asList(1.1f, 2.2f, 3.3f));
        TreeSet<Double> ts =
                new TreeSet<Double>(Arrays.asList(1.11, 2.22, 3.33));
        LinkedHashSet<Integer> lhs =
                new LinkedHashSet<Integer>(Arrays.asList(11, 22, 33));
        printAny(al);
        printAny(ll);
        printAny(hs);
        printAny(ts);
        printAny(lhs);
    }
}
