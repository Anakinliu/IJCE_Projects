package Generics;
import java.util.EnumSet;
import java.util.Set;

import static Generics.Sets.*;
import static Generics.Watercolors.*;
/**
 * Created by Anakinliu on 2017/8/30.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
public class WatercolorSets {
    public static void main(String[] args) {
        Set<Watercolors> set1 =
                EnumSet.range(BLACK, BLUE);
        Set<Watercolors> set2 =
                EnumSet.range(RED, GREEN);
        System.out.println("set1: " + set1);
        System.out.println("set2: " + set2);
        System.out.println(union(set1, set2).equals(EnumSet.range(RED, BLUE)));
        System.out.println(intersection(set1, set2));
        System.out.println(difference(union(set1, set2), intersection(set1, set2)));

    }
}
