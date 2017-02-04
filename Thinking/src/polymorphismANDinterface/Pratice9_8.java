package polymorphismANDinterface;

/**
 * Created by Anakinliu on 2017/1/29.
 */
class A { //在类中嵌套接口或类
    private interface D {
        void Df();
    }
    public class ImpD implements D {
        @Override
        public void Df() {
            System.out.println("ImpD.Df()");
        }
    }

    public D getD() {
        return new ImpD();
    }


    public D d;

    public D receiveD (D d) {
        this.d = d;
        return this.d;
    }
    private class E {
        public void showE() {
            System.out.println("E.showE()");
        }
    }

    public E getE() {
        return new E();
    }

    public E e;

    public void receiveE (E e) {
        this.e = e;
        this.e.showE();
    }

}
public class Pratice9_8 {
    public static void main(String[] args) {
        A a = new A();
        //(a.getD()).Df();//无法访问
        //(a.getE()).showE();
        a.receiveE(a.getE());
        a.receiveD(a.getD());

    }
}
