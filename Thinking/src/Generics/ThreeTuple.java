package Generics;

/**
 * Created by Anakinliu on 2017/6/14.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
public class ThreeTuple<A, B, C> extends TwoTuple<A, B>{
    public final C third;

    public ThreeTuple(A a, B b, C third) {
        super(a, b);
        this.third = third;
    }
}
