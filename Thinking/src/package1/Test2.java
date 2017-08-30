package package1;

/**
 * Created by Anakinliu on 2017/2/7.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
class BBase {
    String b = "ASD";
    public BBase () {
        b = "BBB";
    }
    void show() {
        System.out.println("BBBBBBBase");
    }
}
class Base extends BBase {
    public int i = 9;
    String s[];
    public Base() {
        s = new String[1];
        s[0] = "liu";
    }

    void show() {
        super.show();
        System.out.println(s.length);
    }
}
public class Test2 extends Base {

    String s = "sss";

    public Test2() {

    }

    @Override
    void show() {
        super.show();
        System.out.println("It's ti=urn to me.");
    }

    public static void main(String[] args) {
        Test2 test2 = new Test2();
        test2.show();
    }
}
