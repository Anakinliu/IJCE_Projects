package HoldingObjects;

/*
    AUTHOR: linux
    TIME: 2018/4/11
    GOOD LUCK AND NO BUG.
*/

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SetOperations {
    public static void main(String[] args) {
        Set<String> set1 = new HashSet<>();
        Collections.addAll(set1, "A B C D E F G".split(" "));
        set1.add("H");
        System.out.println("F: " + set1.contains("F"));
        System.out.println("I: " + set1.contains("I"));

        Set<String> set2 = new HashSet<>();
        Collections.addAll(set2, "A B C D E F G".split(" "));
        System.out.println(set1.containsAll(set2));

        set2.removeAll(set2);
    }
}
