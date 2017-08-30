package polymorphismANDinterface;

import static print.Print.*;

abstract class Dad {
}

class Son extends Dad {
    protected void print() { println("Son"); }
}

 interface AAA {

}

abstract class SecondDad {
    abstract protected void print();

    @Override
    public String toString() {
        return super.toString();
    }
}

class SecondSon extends SecondDad {
    protected void print() { println("SecondSon"); }
}

public class Ex4 {
    public static void testPrint(Dad d) {
        ((Son)d).print();
    }
    public static void secondTestPrint(SecondDad sd) {
        sd.print();
    }

    static final int x = 6;

    static final String s = "444";

    public static void setX(int x) {
        x = 9;

    }

    public static void main(String[] args) {
        Dad s = new Son();
        Ex4.testPrint(s);
        SecondSon ss = new SecondSon();
        Ex4.secondTestPrint(ss);
    }
}

