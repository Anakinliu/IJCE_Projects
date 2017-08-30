package InnerClass;

/**
 * Created by Anakinliu on 2017/2/8.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
interface iPractice13 {
    String show(int i);
}
public class Practice13 {
    public void change(iPractice13 iPractice13) {
        getPractice13().show(6);
    }

    public iPractice13 getPractice13() {
        /*
        * 格式：形参 -> 方法体
        * 形参的类型一般不用说明
        * 方法体可以是简单的语句或者代码块
        * */
        return (int i) -> "Interface iPractice13.show()" + i;
    }

    public static void main(String[] args) {
        Practice13 practice13 = new Practice13();
        System.out.println(practice13.getPractice13().show(6));
    }
}
