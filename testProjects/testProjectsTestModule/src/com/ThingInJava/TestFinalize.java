package com.ThingInJava;

/**
 * Created by liu_y.
 * On 2016/10/7.
 */
public class TestFinalize {
    boolean useFinalize = false;
    TestFinalize(boolean useFinalize) {
        this.useFinalize = useFinalize;
    }
    protected void finalize() {
        System.out.println("uesd finalize()");
    }
    public static void main(String[] args) {
        TestFinalize tf = new TestFinalize(true);
        new TestFinalize(true);
        //System.gc();
    }
}