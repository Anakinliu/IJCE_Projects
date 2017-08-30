package polymorphismANDinterface;

/**
 * Created by Anakinliu on 2017/1/17.
 */
class FA {
    public void A() {
        System.out.println("FA.A()");
    }
}

class FB extends FA {
    public void A() {
        System.out.println("FB.A()");
    }
    public void B() {
        System.out.println("FB.B()");
    }
}
public class RTTItest {
    public static void main(String[] args) {
        FA fa1 = new FA();
        ((FB)fa1).B();//ClassCastException

        FA fa2 = new FB();
        ((FB)fa2).B();//OK
    }
}
