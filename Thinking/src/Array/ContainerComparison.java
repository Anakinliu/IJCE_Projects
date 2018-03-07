package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author: Anakinliu
 * Date: 2018/03/07
 * Time: 10:53
 * You may be disappointed if you fail,
 * but you are doomed if you don't try.
 */
class E {
    private static int counter = 0;
    private final int id = counter++;

    @Override
    public String toString() {
        return "E: " + id;
    }
}
public class ContainerComparison {
    public static void main(String[] args) {
        E[] es = new E[10];
        for (int i = 0; i < 10; i++) {
            es[i] = new E();
        }
        System.out.println(Arrays.toString(es));
        System.out.println(es[4]);

        List<E> eList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            eList.add(new E());
        }
        System.out.println(eList.toString());
        System.out.println(eList.get(4));

        char[] chares = new char[22];
        for (int i = 0; i < chares.length; i++) {
            System.out.print(chares[i] + ",");
        }

        boolean[] bools = new boolean[22];
        for (int i = 0; i < bools.length; i++) {
            System.out.print(bools[i]);
        }
    }
}
