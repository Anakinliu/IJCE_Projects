package HoldingObjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by Anakinliu on 2017/8/2.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
public class AddingGroups {
    public static void main(String[] args) {
        Collection<String> collection =
                new ArrayList<String>(Arrays.asList("sd", "dsd"));
        String[] arggs = {"ss", "SSR"};
        Collections.addAll(collection, arggs);
        System.out.println(collection);

        Collection<Integer> col2 = Arrays.asList(1, 2);
        // ! col2.add(3); // 运行时错误！ 底层是数组， 无法进行改变大小操作！

        Collection<Integer> col3 = new ArrayList<>(Arrays.asList(1, 2));
        col3.add(3); // 现在可以了。
    }
}
