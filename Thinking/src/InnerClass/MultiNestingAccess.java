package InnerClass;

import polymorphismANDinterface.AbstractExtendsInterface;

/**
 * Created by Anakinliu on 2017/2/9.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
interface  Inner1 {

}
interface Inner2 {

}
public class MultiNestingAccess {

    public void outer() {}

    class A extends MultiNestingAccess implements Inner1, Inner2{

        public void a() {}

        class B {

            public void b(){}
            class C {
                public void c() {
                    outer();
                    a();
                    b();
                }
            }
        }
    }

    public static void main(String[] args) {
        MultiNestingAccess mna = new MultiNestingAccess();
        MultiNestingAccess.A mnaa = mna.new A();
        MultiNestingAccess.A.B mnaab = mnaa.new B();
        MultiNestingAccess.A.B.C mnaabc = mnaab.new C();
    }
}
