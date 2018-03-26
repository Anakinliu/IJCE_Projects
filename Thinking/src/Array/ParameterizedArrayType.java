package Array;

/**
 * Author: Anakinliu
 * Date: 2018/03/25
 * Time: 09:59
 * You may be disappointed if you fail,
 * but you are doomed if you don't try.
 */
/*
数组不能与泛型完美结合, 因为数组必须知道确切类型, 以保证类型安全
但是, 可以
 */

/*
一, 参数化数组的类型
    使用时需要实例化类
 */
class ClassParameter<T> {
    public T[] f(T[] arg) {
        return arg;
    }
}

/*
二, 使用时直接使用方法即可
 */
class MethodParameter {
    public static  <T> T[] f(T[] args) {
        return args;
    }
}


public class ParameterizedArrayType {
    public static void main(String[] args) {
        Integer[] ints = new Integer[]{1, 2, 3};
        Integer[] classParameterInts = new ClassParameter<Integer>().f(ints);
        Integer[] methodInts = MethodParameter.f(ints);
    }
}
