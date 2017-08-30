/**
 * Created by Anakinliu on 2017/1/23.
 */
interface A {
    void show();
}
interface N extends A {
    void gan();
}
interface B extends A {
    void fuck();
}
interface V extends B,N {
    void hhh();
}

class C implements V {

    @Override
    public void hhh() {

    }

    @Override
    public void show() {

    }

    @Override
    public void gan() {

    }

    @Override
    public void fuck() {

    }
}
public class LingXingWenTi  {
    public static void show(A a) {

    }

    public static void main(String[] args) {
        C c = new C();
        show(c);
    }
}
