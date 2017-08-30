package Generics;

/**
 * Created by Anakinliu on 2017/6/13.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
public class Holder2 {
    // 想要持有不同类型而无需建立多个类似的类,
    // 类型需要使用 Object
    private Object a;

    Holder2(Object a) {
        this.a = a;
    }

    public Object getA() {
        return a;
    }

    public void setA(Object a) {
        this.a = a;
    }

    public static void main(String[] args) {
        Holder2 holder2 = new Holder2("");
        // 必须强制转型
        String test = (String)holder2.getA();
        // 编译错误
        Integer test_1 = (Integer)holder2.getA();

    }
}
