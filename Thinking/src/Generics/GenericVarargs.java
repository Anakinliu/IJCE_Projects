package Generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Anakinliu on 2017/8/12.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
/*
泛型结合可变参数
 */
public class GenericVarargs {
    /*
    与Arrays.asList方法相同, 返回一个装着
    可变参数这个数组的ArrayList
     */
    public static <T> List<T> makeList(T... args) {
        // 将可变参数参数列表做成List
        List<T> result = new ArrayList<>();
        result.addAll(Arrays.asList(args));
        return result;
    }

    public static void main(String[] args) {
        List<String> stringList = makeList("L", "Y", "Q");
        System.out.println(stringList);
        stringList = makeList("ABCDEFGHIJKLMNOPQRSTUVWXYZ".split(""));
        stringList.add("!");
        System.out.println(stringList);
        System.out.println("=================");
        List<String> test = Arrays.asList("ABCDEFGHIJKLMNOPQRSTUVWXYZ".split(""));
        System.out.println(test);
    }
}
