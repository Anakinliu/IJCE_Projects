package com.ThingInJava;

/**
 * Created by liu_y.
 * On 2016/10/22.
 */
class Connection2 {
    private static int count = 0;
    private int i = 0;
    private Connection2() { System.out.println("Connection()");}
    // Allow creation via static method:
    static Connection2 makeConnection() {
        count++;
        return new Connection2();
    }
    public static int howMany() { return count; }
    public String toString() {
        return ("Connection " + count);
    }
}
