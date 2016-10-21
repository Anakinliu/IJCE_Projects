package com.ThingInJava;

/**
 * Created by liu_y.
 * On 2016/10/12.
 */
public class Testfinalize2 {
    boolean filled ;

    Testfinalize2() {
    }

    void fillIt() {
        filled = true;
    }

    void cleanIt() {
        filled = false;
    }

    protected void finalize() {
        if (filled) {
            System.out.println("is fill");
        }
        else {
            System.out.println("not fill, will clean it");
            System.gc();
        }
    }
    public static void main(String[] args) {
        Testfinalize2 t = new Testfinalize2();
        t.fillIt();
        t.cleanIt();
        //t.finalize();
        System.out.println(t.filled);

    }
}
