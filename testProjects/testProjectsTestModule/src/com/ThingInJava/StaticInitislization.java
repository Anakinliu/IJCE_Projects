package com.ThingInJava;

/**
 * Created by liu_y.
 * On 2016/10/15.
 */
class Bowl {
    //-----wan
    Bowl(int marker) {
        System.out.println("Bowl(" + marker + ")");
    }
    static void f1 (int marker) {
        System.out.println("f1(" + marker + ")");
    }
}
class Table {

    int x = f();
    int f() {
        return 11;
    }
    static Bowl b1 = new Bowl(1);
    static Bowl b2 = new Bowl(2);
    Table(int marker) {
        int y;
        System.out.println("Table(" + marker + ")");
    }

}
public class StaticInitislization {

    public static void main(String[] args) {
        Table.b1.f1(1);

        System.out.println("------------next t1 ---------------");
        Table t1 = new Table(1);
        System.out.println("------------next t2 ---------------");
        Table t2 = new Table(2);
        System.out.println(t2.x);
    }
}
