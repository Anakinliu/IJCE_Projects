package Generics;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Anakinliu on 2017/8/30.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
/*
SET的集合运算
*/
public class Sets {
    /*
    并集
     */
    public static <T> Set<T> union(Set<T> a, Set<T> b) {
        Set<T> result = new HashSet<>(a);
        result.addAll(b);
        return result;
    }

    /*
    交集
     */
    public static <T> Set<T> intersection(Set<T> a, Set<T> b) {
        Set<T> result = new HashSet<>(a);
        result.retainAll(b); //保留a,b的交集
        return result;
    }

    // 从父Set中减去子Set
    public static <T> Set<T> difference(Set<T> superSet, Set<T> subSet) {
        Set<T> result = new HashSet<>(superSet);
        result.removeAll(subSet);
        return result;
    }

    // 从并集中出去交集
    public static <T> Set<T> complement(Set<T> a, Set<T> b) {
        return difference(union(a, b), intersection(a, b));
    }

}




