package InnerClass;

/**
 * Created by Anakinliu on 2017/2/4.
 * GO! GO! GO!
 */
public class Pratice7 {
    private String s = "F";

    private String toString(String s) {
          return s;
    }

    private void changeS() {
        s = "C";
    }

    class Inner {
        void changeS () {
            s = "G";
            System.out.println(Pratice7.this.toString(s));
//            //直接写changeS()会产生递归。。。
//            Pratice7.this.changeS();
        }
    }

    void changer() {
        Inner inner = new Inner();
        inner.changeS();
    }

    public static void main(String[] args) {
        Pratice7 pratice7 = new Pratice7();
        pratice7.changer();
    }
}
