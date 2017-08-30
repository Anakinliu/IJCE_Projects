package InnerClass;

/**
 * Created by Anakinliu on 2017/2/6.
 * GO! GO! GO!
 */
interface Destination {

}
public class Parcel5 {

    //方法内部定义类


    public void change(String string) {

        string = null;
    }
    public Destination destination(String s) {
        class PDestination implements Destination {
            private String label;
            private PDestination(String whereTo) {
                label = whereTo;
            }
            public String readLabel() {
                return label;
            }

        }
        String string = "liu";
        for(int i=0; i< 10; ) {
            class S {
                public S (int i) {
                    System.out.println(i);
                }
            }
            i++;
            new S(i);
        }
        change(string);
        System.out.println(string);
        return new PDestination(s);
    }

    /*
    *PDestination 是destination方法的一部分，而不是Parcel5类的一部分。所以在destination方法之外不能访问PDestination这个类。
    * 注意return语句是向上转型，返回的是基类Destination的引用.
    *在任何作用域内都可以定义一个类，这个类只在此域内可用，比如下面的if内的域
    *
     */


    public static void main(String[] args) {
        Parcel5 parcel5 = new Parcel5();
        Destination destination = parcel5.destination("Beijing");

    }
}
