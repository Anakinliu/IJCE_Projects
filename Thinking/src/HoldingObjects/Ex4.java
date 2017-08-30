package HoldingObjects;

import java.util.*;

/**
 * Created by Anakinliu on 2017/8/3.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
public class Ex4 {
    private static int index = 0;
    private static String next() {
        switch(index) {
            case 0: index++;
                return "mov1";
            case 1: index++;
                return "mov2";
            case 2: index++;
                return "mov3";
            case 3: index = 0;
                return "mov4";
        }
        return null;
    }
    private static Collection fill(Collection<String> collection, int n) {
        for (int i = 0; i < n; i++) {
            collection.add(next());
        }
        return collection;
    }

    public static void main(String[] args) {
        System.out.println(fill(new Vector<>(), 10));
    }
}
