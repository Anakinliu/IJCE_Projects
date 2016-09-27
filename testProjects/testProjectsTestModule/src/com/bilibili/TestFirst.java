package com.bilibili;

/**
 * Created by liu_y.
 * On 2016/9/14.
 */
public class TestFirst {
    //2^1 - 1...........2^20 - 1
    int number;
    double result;

    TestFirst(int n) {
        number = n;
    }
    private void setNumber(int n) {
        number = n;
    }

    private double getResult() {
        return result;
    }
    private void setResult(){
        int i;
        for (i=1;i<=number;i++) {
            result = result + Math.pow(2,i) - 1.0;
        }
    }

    public static void main(String[] args) {
        TestFirst twenty = new TestFirst(20);
        twenty.setResult();
        System.out.println(twenty.getResult());
    }
}
