package Fundamentals;

/**
 * Created by Anakinliu on 17.11.21.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
public class Ex_1_1_16 {
    /*
    此函数在参数过大时, 只会导致内存溢出
     */
    public static String r1(int n) {
        if (n <= 0)
            return "";
        else
            return r1(n - 3) + n + r1(n - 2) + n;
    }

    /*
    有问题的递归函数, 会导致 堆栈 溢出!!!
     */
    private static String r2(int n) {
        if (n <= 0)
            return "";
        String s = r2(n - 3) + n +
                r2(n - 2) + n;
//        if (n <= 0)
//            return "";
        return s;
    }

    public static void main(String[] args) {
        System.out.println(r1(7));
        System.out.println(r1(6));
        System.out.println(r1(5));
        System.out.println(r1(4));
        //==============
        System.out.println(r2(7));
    }
}
