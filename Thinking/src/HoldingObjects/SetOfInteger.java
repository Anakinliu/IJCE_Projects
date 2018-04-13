package HoldingObjects;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class SetOfInteger {
    public static void main(String[] args) {
        Random rand = new Random();

        // HashSet会排序, 与Thinking里写的相反, JDK原因?
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 10000; i++) {
            set.add(rand.nextInt(30));
        }
        System.out.println(set );

        // 保持插入顺序
        set = new LinkedHashSet<>();
        for (int i = 0; i < 10000; i++) {
            set.add(rand.nextInt(30));
        }
        System.out.println(set);
    }
}
