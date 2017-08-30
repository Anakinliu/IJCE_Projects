package Generics;

/**
 * Created by Anakinliu on 2017/6/14.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
public class TwoTuple<A, B> {

    //  有了final和构造器, 就不用担心public导致的引用被修改
    public final A first;
    public final B second;
    public TwoTuple (A a, B b) {
        first = a;
        second = b;
    }

    @Override
    public String toString() {
        return "(" + first + "," + second + ")";
    }

    public static void main(String[] args) {
        // 元组, 将一组对象直接打包存储于一个对象中. 放入某种对象后, 不能再放入其他类型对象.
        TwoTuple<String, Integer> twoTuple = new TwoTuple<>("ss", 2);
    }
}
