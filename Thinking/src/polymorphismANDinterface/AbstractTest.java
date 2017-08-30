package polymorphismANDinterface;

/**
 * Created by Anakinliu on 2017/1/17.
 */
 class abstracA {

    public abstracA() {
        print();
    }

    public void A() {

    }

    public  void print() {}
}

class realA extends abstracA {
    private int i = 9;

    public realA() {
        i = 99;
    }

    @Override
    public void print() {
        System.out.println(i);
    }
}
public class AbstractTest {
    public static void main(String[] args) {
        //new abstracA(); //abstract can't instantiated
        new realA().print();
    }
}
