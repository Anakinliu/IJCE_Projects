//package Generics
//
///**
// * Created by Anakinliu on 2017/6/14.
// * If you only do what you can do,
// * you'll never be more than you are now.
// */
//object TupleTest {
//    internal fun f1(): TwoTuple<String, String> {
//        return TwoTuple("ss", "dd")
//    }
//
//    // 想要使用心得对象类型, 必须使用心得TwoTuple对象
//    internal fun f2(): TwoTuple<Int, Double> {
//        return TwoTuple(22, 33.0)
//    }
//
//    @JvmStatic fun main(args: Array<String>) {
//        println(f1())
//        println(f2())
//    }
//
//}
