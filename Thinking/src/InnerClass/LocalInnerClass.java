package InnerClass;

/**
 * Created by Anakinliu on 2017/3/8.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
public class LocalInnerClass {

    private int x;

    public QQQ getABC() {

        class QQT extends QQQ {
            public QQT(int x) {
                super(x);
                //局部内部类与匿名了内部类的区别是,
                //局部内部类可以有构造器,可以简单构建多个对象.
            }

            public QQT () {

            }
        }

        return new QQT(9) ;
    }

    public QQQ getABC(int x) {
        return new QQQ(x) {

        };
    }

}
