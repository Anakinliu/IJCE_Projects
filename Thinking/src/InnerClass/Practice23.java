package InnerClass;

/**
 * Created by Anakinliu on 2017/2/14.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
interface U {
    void method1 () ;
    void method2 () ;
    void method3 () ;
}

class A {

    public static  int i=1;

    public U u;

    public U getUInA(final int i) {
        if (i >0 ) {
            return new U() {
                @Override
                public void method1() {
                    //外部类和匿名内部类的描述是一样的???
                    u = this;
                    // i need to be final
                    System.out.println(A.this.getClass() + "m1: " + (i));
                }

                @Override
                public void method2() {
                    System.out.println(this.getClass().getSimpleName() + "m2: " + (i));
                }

                @Override
                public void method3() {
                    System.out.println(this.getClass().getSimpleName() + "m3: " + (i));
                }
            };
        } else {
            return null;
        }

    }
}

class B {
    public U[] uArray;

    private int i = 0;

    public B (int n) {
        uArray = new U[n];
    }

    public void add(U u) {
        if (i<uArray.length && i> -1) {
            uArray[i] = u;
            i++;
        }
    }

    public void clear() {
        int i = 0;
        for (U u : uArray) {
            uArray[i++] = null;
        }
    }

    public void show() {
        for (U u : uArray) {
            System.out.println(u);
//            u.method1();
//            u.method2();
//            u.method3();
        }
    }


}
public class Practice23 {
    public static void main(String[] args) {
        A a1 = new A();
        A a2 = new A();
        A a3 = new A();
        B b = new B(9);
        U u1 = a1.getUInA(1);
        U u2 = a2.getUInA(1);
        U u3 = a3.getUInA(1);
        b.add(u1);
        b.add(u2);
        b.add(u3);
        //下面用匿名内部类参数
        b.add(a1.getUInA(1));
        b.add(a1.getUInA(0));
        b.add(a1.getUInA(0));

        b.show();
        b.clear();

    }
}
