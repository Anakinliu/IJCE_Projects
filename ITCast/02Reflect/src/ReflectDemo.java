import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/*
    AUTHOR: linux
    TIME: 2020/2/26
    GOOD LUCK AND NO BUG.
*/
public class ReflectDemo {

    /*
    1. 获取Class对象的3种方式
     */
    public static Class show1() throws Exception{
        // 方式一
        Class clsO = Class.forName("IAmAClass");
        // 方式二
        Class cls1 = IAmAClass.class;
        // 方式三
        Class cls2 = new IAmAClass().getClass();

        // 比较内存地址，是指向同一个class对象的
        System.out.println(clsO == cls1);  //true
        System.out.println(cls1 == cls2);  //true
        return clsO;
    }

    /*
    2. 获取类的组成部分：
        成员变量
        成员方法
        构造方法
        类名
        。。。
     */
    public static void show2() throws Exception{
        Class<IAmAClass> cls = show1();
        /*
        成员变量
         */
        cls.getField("xxx");
        cls.getFields();
        cls.getDeclaredField("xxx");
        cls.getDeclaredFields();

        /*
        成员方法
         */
        cls.getMethod("xxxx");
        cls.getMethods();
        cls.getDeclaredMethod("xxxx");
        cls.getDeclaredMethods();

        /*
        构造方法
         */
        cls.getConstructor();
        cls.getConstructors();
        cls.getDeclaredMethod("xxxx");
        cls.getDeclaredMethods();

        /*
        类名
         */
        cls.getName();
        cls.getSimpleName();
        cls.getCanonicalName();
        cls.getTypeName();

    }

    public static void main(String[] args) throws Exception{
        Class<IAmAClass> cls = IAmAClass.class;

        // 成员变量
//        Field pubField = cls.getField("pub");  // 无异常
//        System.out.println(pubField.get(new IAmAClass()));  // 根据不同的对象，得到不同的值，所以要传入对象
//        pubField.set(new IAmAClass(), 9);  // 根据不同的对象，设置值，所以要传入具体哪个对象
//        Field proField = cls.getField("pro");  // java.lang.NoSuchFieldException
//        Field defField = cls.getField("def");  // java.lang.NoSuchFieldException
//        Field priField = cls.getField("pri");  // java.lang.NoSuchFieldException
//        Field[] fields = cls.getFields();

//        IAmAClass inst = new IAmAClass();
//        Field priField = cls.getDeclaredField("pri");
//        priField.setAccessible(true);
//        System.out.println(priField.get(inst));  // ok
//        priField.set(inst, 9);
//        System.out.println(inst.getPri());  // 9

        //构造方法
//        Constructor<IAmCLass> cons = cls.getConstructor();
//        System.out.println(cons);

//        Constructor<IAmAClass> cons = cls.getConstructor(String.class);
//        System.out.println(cons);
//        IAmAClass newIns = cons.newInstance("678");  //要使用对应的构造器参数！！！

        //成员方法
        Method method1 = cls.getMethod("getID");
        System.out.println(method1);

        Method method2 = cls.getDeclaredMethod("proMethod", String.class);  // 参数写TYPE.class
        method2.setAccessible(true);  // 忽视
        System.out.println(method2);

        method2.invoke(new IAmAClass(), "world");  // 执行方法

        for (Method method : cls.getMethods()) {
            System.out.println(method.getName());  // 会把父类符合条件的包括进来
        }
    }
}
