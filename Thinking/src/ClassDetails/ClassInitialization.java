package ClassDetails;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Anakinliu on 2017/7/17.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
class Initable2 {
    static final int staticFinal = 47;

    static final int getStaticFinal2 =
            ClassInitialization.rand.nextInt(1000);
    static {
        System.out.println("Initializing Initable2. ");
    }
}
class Initablw3 {
    static int dtaticNOFinal = 33;
    static  {
        System.out.println("Initializing Initable3");
    }
}

class Initable4 {
    static final int staticfinalconstant = 233;
    static {
        System.out.println("Initializing Immediately after Class.forName()!");
    }
}
public class ClassInitialization {
    public static Random rand = new Random(47);
    public static void main(String[] args) {
        Class initable = Initable2.class;
        System.out.println("After creating Initable ref");
        // 只有static final是编译常量时, 才不会对类进行初始化
        System.out.println(Initable2.staticFinal);
        System.out.println(Initable2.getStaticFinal2); //非常量

        System.out.println("========================");
        //如果static域不是final, 那么在它被访问前, 就进行类的链接(为域分配存储空间)和初始化
        System.out.println(Initablw3.dtaticNOFinal);

        System.out.println("========================");
        // Class.forName()立即初始化!
        try {
            Class.forName("ClassDetails.Initable4");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
