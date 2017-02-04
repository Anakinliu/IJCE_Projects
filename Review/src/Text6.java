/**
 * Created by Anakinliu on 2017/1/6.
 *
 * 写一个名叫Square的类用于求一个数的平方。
 类里面提供两个静态方法，名字都叫square。
 其中一个方法的参数和返回值都是long型，另一个方法的参数和返回值都是double型

 */
class Square {
    public static long square(long n) {
        return n*n;
    }

    public static double square(double n) {
        return Math.pow(n,2.0);
    }
}
public class Text6 {
}
