package Generics;

/**
 * Created by Anakinliu on 2017/6/13.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
public class Holder3 <T>{
    private T a;

    /*

     */
    public Holder3(T a) {
        this.a = a;
    }

    public T getA() {
        return a;
    }

    public void setA(T a) {
        this.a = a;
    }

    public static void main(String[] args) {
        // 必须指明放入的类型是什么, 注意, 多肽与泛型可以结合
        Holder3<String> holder3 = new Holder3<>("");
        // 不需要强制转型
        // TODO 泛型核心概念: 泛型代码告诉编译器想用的类型, 编译器帮程序员处理细节.
        String test = holder3.getA();
        // ! Integer test_1 = (Integer)holder3.getA();

    }
}
