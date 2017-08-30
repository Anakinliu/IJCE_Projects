package InnerClass;

/**
 * Created by Anakinliu on 2017/2/6.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */

//定义一个匿名内部类，希望引用外部的对象.
public class Parcel9 {
    String special = "liu";
    public Contents show(String s) {
        return new Contents() {

            @Override
            public int value() {

                //如果要改变参数s，需要s是final的,因为不确定s是那个类的参数
                //！s = "sss";
                System.out.println(s + "!");
                //改变special
                special = "sss";
                System.out.println(special);
                return 0;
            }
        };
    }

    public static void main(String[] args) {
        Parcel9 parcel9 = new Parcel9();
        Contents contents = parcel9.show("sss");
        contents.value();
        System.out.println("change?" + parcel9.special);
    }

}
