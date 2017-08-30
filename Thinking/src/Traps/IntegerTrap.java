package Traps;

/**
 * Created by Anakinliu on 2017/3/23.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */

/*
stack_over_flow :
https://stackoverflow.com/documentation/java/4388/java-pitfalls/8996/pitfall-using-to-compare-primitive-wrappers-objects-such-as-integer
 */
public class IntegerTrap {
    public static void main(String[] args) {
        //底层就是调用了valueOf()
        //而JVM一般会缓存了-128~127的Integer对象,这么做使得valueOf方法直接返回缓存的Integer
        Integer int_1 = 47;
        Integer int_2 = Integer.valueOf("47");
        System.out.println("int_1 == int_2: " + " " + (int_1 == int_2));
        System.out.println("equals: " + int_1.equals(int_2));

        System.out.println();

        int_1 = Integer.valueOf("1000");
        int_2 = 1000;

        System.out.println("int_1 == int_2: " + " " + (int_1 == int_2));
        System.out.println("equals: " + int_1.equals(int_2));

        /*
        The reason for this difference in behavior is, that the JVM maintains a cache of Integer objects for the range -128 to 127. (The upper value can be overridden with the system property "java.lang.Integer.IntegerCache.high" or the JVM argument "-XX:AutoBoxCacheMax=size"). For values in this range, the Integer.valueOf() will return the cached value rather than creating a new one.

Thus, in the first example the Integer.valueOf(1) and Integer.valueOf("1") calls returned the same cached Integer instance. By contrast, in the second example the Integer.valueOf(1000) and Integer.valueOf("1000") both created and returned new Integer objects.

The == operator for reference types tests for reference equality (i.e. the same object). Therefore, in the first example int1_1 == int2_1 is true because the references are the same. In the second example int2_1 == int2_2 is false because the references are different.
         */
    }
}
