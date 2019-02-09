package Containers;

import java.util.LinkedHashSet;
import java.util.Set;

/*
    AUTHOR: linux
    TIME: 2018/5/7
    GOOD LUCK AND NO BUG.
*/
class Goverment implements Generator<String> {

    private String[] foundation = ("strange women lying in ponds " +
    "distributing swords is no basis for a system of " +
    "government").split(" ");

    private int index;

    @Override
    public String next() {
        return foundation[index++];
    }
}
public class CollectionDataTest {
    public static void main(String[] args) {
        Set<String> set = new LinkedHashSet<>(
                new CollectionData<>(new Goverment(), 15)
        );
        System.out.println(set);
        // 因为是hashSet, 所以重复添加会比较Hash值
        set.addAll(CollectionData.list(new Goverment(), 15));
        System.out.println(set);
    }
}
