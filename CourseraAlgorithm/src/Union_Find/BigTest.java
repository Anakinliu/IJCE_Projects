package Union_Find;

import java.util.Random;

/**
 * Created by Anakinliu on 18.1.27.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
public class BigTest {
    public static void QF() {
        Random random = new Random(66);
        Quick_Find qf = new Quick_Find(1000000);
        // 10000次随机union
        long sTime = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            qf.union(random.nextInt(10000), random.nextInt(10000));
        }
        long eTime = System.currentTimeMillis();
        System.out.println(eTime - sTime);
    }

    public static void QU() {
        Random random = new Random(66);
        Quick_Union qu = new Quick_Union(1000000);
        // 10000次随机union
        long sTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            qu.union(random.nextInt(1000000), random.nextInt(1000000));
        }
        long eTime = System.currentTimeMillis();
        System.out.println(eTime - sTime);
//        for (int i = 0; i < 10000; i++) {
//            System.out.println(qu.a[i]);
//        }
    }

    public static void QUW() {
        Random random = new Random(66);
        Quick_Union_Weight quw = new Quick_Union_Weight(1000000);
        // 10000次随机union
        long sTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            quw.union(random.nextInt(1000000), random.nextInt(1000000));
        }
        long eTime = System.currentTimeMillis();
        System.out.println(eTime - sTime);
    }
    public static void main(String[] args) {
//        QF();
        QU();
//        QUW();  // 百万级别只用了185毫秒
    }

}
