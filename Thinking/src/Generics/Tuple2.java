package Generics;

/**
 * Created by Anakinliu on 2017/8/29.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */

// 元组, 将一组对象直接打包存储于一个对象中. 放入某种对象后, 不能再放入其他类型对象.
public class Tuple2 {
    public static <A, B> TwoTuple<A, B> tuple(A a, B b) {
        return new TwoTuple<>(a, b);
    }
}
