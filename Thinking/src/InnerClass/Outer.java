package InnerClass;

/**
 * Created by Anakinliu.
 * On 2016/12/1.
 */
public class Outer {
    int i = 9;
     class Inner {


        class Ininer {

        }

        public void showInner() {
            System.out.println("I'am Outer.Inner.");
        }
    }
    public Inner returnInner() {
        return new Inner();
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        Inner inner = outer.returnInner();
        inner.showInner();

    }
}
