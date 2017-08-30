package InnerClass;

/**
 * Created by Anakinliu on 2017/2/9.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
public class TestClassInInterface implements ClassInInterface {

    //这种内部类可以用来临时测试代码
    public static class Tester {
        public static void main(String[] args) {
            String name =  TestClassInInterface.PublicImplements.getName();
            System.out.println("name");
        }
    }
}
