package Generics;

import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by Anakinliu on 2017/8/30.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
/*
比较子类与父类之间的差异
 */
public class ContainerMethodDifferences {
    /*
    得到一个类方法名并放到Set, 注意, Set无重复元素, 所以重载方法只显示一个!
    打印的方法包括父类的方法, 沿着继承路径一直向上直到Object!!!
     */
    static Set<String> methodSet(Class<?> type) {
        Set<String> result =
                new TreeSet<>();
        for (Method m: type.getMethods()) {
            result.add(m.getName());
        }
        return result;
    }

    static void interfaces(Class<?> type) {
        System.out.println("Interfaces in " + type.getSimpleName());
        List<String> result = new ArrayList<>();
        for (Class<?> c : type.getInterfaces())
            result.add(c.getSimpleName());
        System.out.println(result);
    }

    static Set<String> object = methodSet(Object.class);
    static {
        object.add("clone");
    }
    static void difference (Class<?> subSet, Class<?> superSet) {
        System.out.println(subSet.getSimpleName() + " extends " + superSet.getSimpleName()
                + ", adds: ");
        Set<String> comp = Sets.difference(methodSet(subSet), methodSet(superSet));
        comp.removeAll(object); //dont show object method
        System.out.println(comp);
        interfaces(superSet);
    }

    public static void main(String[] args) {
        //System.out.println("Collection: " + methodSet(String.class));
        //interfaces(String.class);
        //difference(Collection.class, Set.class);
        difference(LinkedHashSet.class, HashSet.class);
        System.out.println("LinkedHashSet: " + methodSet(String.class));
    }
}
