package HoldingObjects;

/**
 * Created by Anakinliu on 2017/8/4.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
import java.util.*;

import static print.Print.print;


class Tester {
    public static int counter = 0;
    private int id = counter++;
    public String toString() { return String.valueOf(id); }
}

public class Ex7_2 {
    public static void main(String[] args) {
        Tester[] t = new Tester[10];
        for(int i = 0; i < t.length; i++)
            t[i] = new Tester();
        List<Tester> lt = new ArrayList<Tester>();
        for(Tester x : t) lt.add(x);
        print("list of Tester: " + lt);
        List<Tester> sub = lt.subList(2, 6);
        print("subList: " + sub);
        // 已经移除的再执行移除produces run time ConcurrentModificationException:
        lt.removeAll(sub);
        // so, first make copy, remove sub, re-assign lt:
        List<Tester> copy = new ArrayList<Tester>(lt);
        // copy的是引用
        //copy.removeAll(sub);
        print("copy: " + copy);
        lt = copy;
        print("list of Tester: " + lt);
    }
}
