package Concurrency;

/**
 * Created by Anakinliu on 2017/7/29.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
interface AAA {

}
interface AAAA extends AAA {

}
public class Test implements AAAA {
    private static AAA returnInterface() {
        return new Test();
    }
}
