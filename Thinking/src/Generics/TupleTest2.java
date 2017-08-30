package Generics;

/**
 * Created by Anakinliu on 2017/8/29.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
public class TupleTest2 {
    static TwoTuple<String, Integer> f() {
        return Tuple2.tuple("hi", 233);
    }

    // 对这个函数, 虽然没有将返回值做参数化处理,  但是编译器没有任何警告
    // 可以当作是"向上转型"为了 非参数化的TwoTuple
    static TwoTuple f2() { //如果硬将返回值参数化处理, 则编译错误
        return Tuple2.tuple("hi", 666);
    }

    public static void main(String[] args) {
        TwoTuple<String, Integer>twoTuple1 = f();
        TwoTuple<String, Integer>twoTuple2 = f2(); // 编译器警告, 黄色波浪线
        TwoTuple twoTuple3 = f2();
    }
}
