package com.ThingInJava;

/**
 * Created by liu_y.
 * On 2016/10/21.
 */
enum Felling {
    COLD,MEDIUM,HOT;
}

public class TestEnum2 {
    Felling felling;
    public TestEnum2(Felling f) {
        felling = f;
    }
    public void showFelling () {
        switch (felling) {
            case COLD :
                System.out.println("a little cold.");
                break;
            case  MEDIUM :
                System.out.println("so cool.");
                break;
            case HOT :
                System.out.println("maybe too hot");
                break;
            default:
                System.out.println("no felling");
        }
    }
    public static void main(String[] args) {
        TestEnum2
                cold = new TestEnum2(Felling.COLD),
                medium = new TestEnum2(Felling.MEDIUM),
                hot = new TestEnum2(Felling.HOT);
        cold.showFelling();
        medium.showFelling();
        hot.showFelling();
    }
}
